package org.example.jdbc.C_PreparedStatement;

import org.example.jdbc.A_Setup.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * C_PreparedStatement: parameterized SELECT.
 *
 * PreparedStatement:
 *   - sends the SQL template once and binds parameters separately, so values
 *     cannot change the structure of the statement (no SQL injection),
 *   - lets the driver/database cache the parsed plan,
 *   - handles type conversion + escaping for you.
 *
 * Parameter indexes are 1-based.
 */
public class Ex {
    public static void main(String[] args) throws SQLException {

        String sql = "SELECT id, name, email, gpa FROM student WHERE gpa >= ? ORDER BY gpa DESC";

        try (Connection connection = DriverManager.getConnection(
                     DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDouble(1, 9.0);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Students with GPA >= 9.0:");
                while (rs.next()) {
                    System.out.printf("  #%d  %-18s %-22s gpa=%.2f%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getDouble("gpa"));
                }
            }

            // Re-execute the same prepared statement with a different value.
            ps.setDouble(1, 7.5);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("\nStudents with GPA >= 7.5:");
                while (rs.next()) {
                    System.out.printf("  #%d  %-18s gpa=%.2f%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("gpa"));
                }
            }
        }
    }
}
