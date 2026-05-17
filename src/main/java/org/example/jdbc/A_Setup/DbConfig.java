package org.example.jdbc.A_Setup;

public final class DbConfig {

    public static final String URL =
            System.getenv().getOrDefault("PAOJ_DB_URL", "jdbc:postgresql://localhost:5432/paoj_jdbc");

    public static final String USER =
            System.getenv().getOrDefault("PAOJ_DB_USER", "postgres");

    public static final String PASSWORD =
            System.getenv().getOrDefault("PAOJ_DB_PASSWORD", "postgres");

    private DbConfig() {
    }
}
