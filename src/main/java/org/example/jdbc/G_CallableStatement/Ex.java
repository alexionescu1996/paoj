package org.example.jdbc.G_CallableStatement;

import org.example.jdbc.A_Setup.DbConfig;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * G_CallableStatement: invoke a stored procedure with IN/OUT parameters.
 *
 * The procedure student_average is defined in src/main/resources/schema.sql:
 *
 *   CREATE OR REPLACE PROCEDURE student_average(
 *       IN  p_student_id INT,
 *       OUT p_average    NUMERIC
 *   ) ...
 *
 * Notes for PostgreSQL specifically:
 *   - CALL is the SQL keyword for procedures.
 *   - OUT parameters still appear in the argument list of CALL, but the JDBC
 *     driver fills them in for you when you registerOutParameter().
 */
public class Ex {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD)) {

            for (int studentId : new int[] {1, 2, 3, 4}) {
                BigDecimal average = callStudentAverage(connection, studentId);
                System.out.printf("student #%d average grade = %s%n", studentId, average);
            }
        }
    }

    private static BigDecimal callStudentAverage(Connection connection, int studentId) throws SQLException {
        String call = "{ call student_average(?, ?) }";

        try (CallableStatement cs = connection.prepareCall(call)) {
            cs.setInt(1, studentId);
            cs.registerOutParameter(2, Types.NUMERIC);
            cs.execute();
            return cs.getBigDecimal(2);
        }
    }
}
