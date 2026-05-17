package org.example.jdbc.F_Joins;

import org.example.jdbc.A_Setup.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * F_Joins: pull data from the student / course / enrollment tables together.
 *
 *   - INNER JOIN: rows that exist in all three tables (a transcript).
 *   - LEFT JOIN + GROUP BY: list every course, even ones with no enrollments,
 *     plus how many students are in each.
 */
public class Ex {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD)) {

            printTranscript(connection, "alice@example.com");
            System.out.println();
            printCourseHeadcount(connection);
        }
    }

    private static void printTranscript(Connection connection, String email) throws SQLException {
        String sql = """
                SELECT s.name      AS student,
                       c.code      AS code,
                       c.title     AS course,
                       e.grade     AS grade
                FROM   student    s
                JOIN   enrollment e ON e.student_id = s.id
                JOIN   course     c ON c.id         = e.course_id
                WHERE  s.email = ?
                ORDER  BY c.code
                """;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Transcript for " + email + ":");
                System.out.printf("  %-8s %-32s %s%n", "code", "course", "grade");
                while (rs.next()) {
                    System.out.printf("  %-8s %-32s %.2f%n",
                            rs.getString("code"),
                            rs.getString("course"),
                            rs.getDouble("grade"));
                }
            }
        }
    }

    private static void printCourseHeadcount(Connection connection) throws SQLException {
        String sql = """
                SELECT c.code,
                       c.title,
                       COUNT(e.student_id) AS enrolled
                FROM   course     c
                LEFT   JOIN enrollment e ON e.course_id = c.id
                GROUP  BY c.code, c.title
                ORDER  BY c.code
                """;

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Course headcount:");
            System.out.printf("  %-8s %-32s %s%n", "code", "course", "enrolled");
            while (rs.next()) {
                System.out.printf("  %-8s %-32s %d%n",
                        rs.getString("code"),
                        rs.getString("title"),
                        rs.getInt("enrolled"));
            }
        }
    }
}
