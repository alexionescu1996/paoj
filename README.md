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

## Setup

1. Install PostgreSQL and create the database:

   ```bash
   createdb paoj_jdbc
   psql -d paoj_jdbc -f src/main/resources/schema.sql
   ```

2. (Optional) Override connection settings via environment variables; defaults
   live in `org.example.jdbc.A_Setup.DbConfig`:

   ```bash
   export PAOJ_DB_URL=jdbc:postgresql://localhost:5432/paoj_jdbc
   export PAOJ_DB_USER=postgres
   export PAOJ_DB_PASSWORD=postgres
   ```

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
