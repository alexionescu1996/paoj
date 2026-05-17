package org.example.jdbc.D_SqlInjection;

import org.example.jdbc.A_Setup.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * D_SqlInjection: side-by-side demo of WHY PreparedStatement matters.
 *
 * Imagine a login form that looks up a user by email. A naive implementation
 * concatenates the user input directly into the SQL string. A malicious user
 * can then close the string literal and inject extra SQL that always evaluates
 * to true, bypassing the filter and dumping every row.
 *
 * The PreparedStatement version treats the same input as a literal value, so
 * the apostrophes and the "OR '1'='1" are matched against the email column
 * and find no rows.
 *
 * Run jdbc.A_Setup first to ensure the database is reachable, and
 * src/main/resources/schema.sql to seed the data.
 */
public class Ex {

    // What an attacker types into the "email" field of a login form.
    private static final String MALICIOUS_INPUT = "anything' OR '1'='1";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD)) {

            System.out.println("=== VULNERABLE: Statement + string concatenation ===");
            vulnerableLookup(connection, MALICIOUS_INPUT);

            System.out.println();
            System.out.println("=== SAFE: PreparedStatement with bound parameter ===");
            safeLookup(connection, MALICIOUS_INPUT);
        }
    }

    /**
     * DO NOT WRITE CODE LIKE THIS. Educational counterexample only.
     *
     * Final SQL sent to the server becomes:
     *   SELECT id, name, email FROM student WHERE email = 'anything' OR '1'='1'
     * The OR clause is always true => the WHERE filter is gone and every
     * student row is returned.
     */
    private static void vulnerableLookup(Connection connection, String userInput) throws SQLException {
        String sql = "SELECT id, name, email FROM student WHERE email = '" + userInput + "'";
        System.out.println("SQL sent: " + sql);

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            int rows = 0;
            while (rs.next()) {
                rows++;
                System.out.printf("  leaked row: #%d %-18s %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
            System.out.println("Rows returned: " + rows + "  <-- should have been 0");
        }
    }

    /**
     * Same user input, but bound as a parameter. The driver sends the SQL
     * template and the value separately; the value is never parsed as SQL,
     * so it is just an unusual email address that does not match anything.
     */
    private static void safeLookup(Connection connection, String userInput) throws SQLException {
        String sql = "SELECT id, name, email FROM student WHERE email = ?";
        System.out.println("SQL template: " + sql);
        System.out.println("Bound param 1: " + userInput);

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, userInput);
            try (ResultSet rs = ps.executeQuery()) {
                int rows = 0;
                while (rs.next()) {
                    rows++;
                    System.out.printf("  row: #%d %-18s %s%n",
                            rs.getInt("id"), rs.getString("name"), rs.getString("email"));
                }
                System.out.println("Rows returned: " + rows + "  <-- the injection had no effect");
            }
        }
    }
}
