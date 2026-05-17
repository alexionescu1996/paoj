# paoj — JDBC tutorial

Progressive JDBC examples against PostgreSQL. Each package under
`org.example.jdbc` contains one `Ex.java` with a `main` method you can run
on its own.

## Packages

| Order | Package                              | Topic                                                  |
|-------|--------------------------------------|--------------------------------------------------------|
| A     | `jdbc.A_Setup`                       | Driver, DriverManager, opening a Connection            |
| B     | `jdbc.B_Statement`                   | Static SELECT via `Statement`                          |
| C     | `jdbc.C_PreparedStatement`           | Parameterized queries with `PreparedStatement`         |
| D     | `jdbc.D_SqlInjection`                | Vulnerable `Statement` counterexample + safe fix       |
| E     | `jdbc.E_ResultSet`                   | INSERT + generated keys, `ResultSetMetaData`, types    |
| F     | `jdbc.F_Joins`                       | INNER JOIN transcript, LEFT JOIN + GROUP BY headcount  |
| G     | `jdbc.G_CallableStatement`           | Calling a stored procedure with an OUT parameter       |

## The PostgreSQL driver in `pom.xml`

JDBC is part of the JDK (`java.sql.*`), but the JDK does **not** ship a
driver for any specific database. To talk to PostgreSQL we add exactly
one dependency in `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.4</version>
</dependency>
```

What happens when you build/run:

1. Maven resolves the coordinates `org.postgresql:postgresql:42.7.4` from
   Maven Central and caches the jar under `~/.m2/repository`.
2. The jar is placed on the compile and runtime classpath.
3. Inside that jar there is a file
   `META-INF/services/java.sql.Driver` listing `org.postgresql.Driver`.
   From JDBC 4.0 onwards `DriverManager` uses `ServiceLoader` to find
   every such file on the classpath and auto-registers the drivers.
4. When we call
   `DriverManager.getConnection("jdbc:postgresql://...")`, the manager
   asks each registered driver "do you handle this URL?"; the Postgres
   driver answers yes and opens the connection.

That is why package `A_Setup` works **without** `Class.forName("org.postgresql.Driver")`.
The call is kept there only to make the registration step visible.

This is plain Java + Maven — no Spring, no JPA, no extra framework.

## Setup

1. Install PostgreSQL and create the database:

   ```bash
   createdb paoj_jdbc
   psql -d paoj_jdbc -f src/main/resources/schema.sql
   ```

2. Adjust the connection settings in
   `org.example.jdbc.A_Setup.DbConfig` if your local Postgres differs from
   the defaults (`jdbc:postgresql://localhost:5432/paoj_jdbc`,
   `postgres`/`postgres`).

3. Build and run any example, for example:

   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass=org.example.jdbc.A_Setup.Ex
   ```

   Or run the `main` of each `Ex` class directly from your IDE.

## Schema

Three tables form a many-to-many relationship between `student` and `course`:

```
student (id, name, email, gpa)
course  (id, code, title, credits)
enrollment (student_id, course_id, grade)
```

Plus a stored procedure `student_average(IN id, OUT average)` used by
package G.
