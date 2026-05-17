package org.example.jdbc.E_ResultSet;

import org.example.jdbc.A_Setup.DbConfig;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * E_ResultSet: working with ResultSet in more depth.
 *
 *   1. Insert a row and read back the auto-generated primary key.
 *   2. Iterate a result set using its metadata so we don't hard-code columns.
 *   3. Use typed getters (BigDecimal for NUMERIC) when precision matters.
 */
public class Ex {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD)) {

            int newId = insertStudent(connection, "Eva Marin", "eva+" + System.currentTimeMillis() + "@example.com", 8.75);
            System.out.println("Inserted student with generated id = " + newId);

            System.out.println();
            System.out.println("All students (driven by ResultSetMetaData):");
            dumpAllStudents(connection);
        }
    }

    private static int insertStudent(Connection connection, String name, String email, double gpa) throws SQLException {
        String sql = "INSERT INTO student (name, email, gpa) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setBigDecimal(3, BigDecimal.valueOf(gpa));

            int affected = ps.executeUpdate();
            System.out.println("Rows inserted: " + affected);

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
                throw new SQLException("No generated key returned");
            }
        }
    }

    private static void dumpAllStudents(Connection connection) throws SQLException {
        String sql = "SELECT id, name, email, gpa FROM student ORDER BY id";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            for (int i = 1; i <= columns; i++) {
                System.out.printf("%-20s", md.getColumnLabel(i));
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    Object value = rs.getObject(i);
                    System.out.printf("%-20s", value);
                }
                System.out.println();
            }
        }
    }
}
