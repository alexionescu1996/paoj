package org.example.jdbc.B_Statement;

import org.example.jdbc.A_Setup.DbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * B_Statement: run a static SQL query with java.sql.Statement.
 *
 * Use Statement only for queries with no user-supplied values (DDL, fixed
 * SELECTs, admin scripts). For anything that mixes in parameters, jump to
 * PreparedStatement in package C.
 */
public class Ex {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = DriverManager.getConnection(
                     DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(
                     "SELECT id, name, gpa FROM student ORDER BY id")) {

            System.out.printf("%-4s %-20s %s%n", "id", "name", "gpa");
            System.out.println("--------------------------------------");
            while (rs.next()) {
                int    id   = rs.getInt("id");
                String name = rs.getString("name");
                double gpa  = rs.getDouble("gpa");
                System.out.printf("%-4d %-20s %.2f%n", id, name, gpa);
            }
        }
    }
}
