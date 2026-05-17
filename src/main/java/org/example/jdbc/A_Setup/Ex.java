package org.example.jdbc.A_Setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A_Setup: explicit driver loading + DriverManager.getConnection().
 *
 * In JDBC 4.0+ the driver is auto-discovered via the ServiceLoader as soon as
 * postgresql-*.jar is on the classpath, so Class.forName is no longer
 * strictly required. We still call it here to show what the JVM is doing under
 * the hood: it loads org.postgresql.Driver, whose static initializer registers
 * an instance with DriverManager.
 */
public class Ex {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        // 1. Explicitly load the driver class. This triggers Driver's
        //    static block: DriverManager.registerDriver(new Driver()).
        Class.forName("org.postgresql.Driver");

        // 2. DriverManager picks the right driver for this URL by asking each
        //    registered driver whether it can handle "jdbc:postgresql:...".
        try (Connection connection = DriverManager.getConnection(
                DbConfig.URL, DbConfig.USER, DbConfig.PASSWORD)) {

            System.out.println("Connected to:        " + connection.getMetaData().getURL());
            System.out.println("Database product:    " + connection.getMetaData().getDatabaseProductName());
            System.out.println("Database version:    " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver name:         " + connection.getMetaData().getDriverName());
            System.out.println("Driver version:      " + connection.getMetaData().getDriverVersion());
            System.out.println("Auto-commit enabled: " + connection.getAutoCommit());
        }
    }
}
