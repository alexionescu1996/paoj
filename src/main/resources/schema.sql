-- PostgreSQL setup script for the JDBC tutorial examples.
-- Run once against your database before executing the examples.
--
--   createdb paoj_jdbc
--   psql -d paoj_jdbc -f src/main/resources/schema.sql
--
-- The examples read connection settings from environment variables or
-- fall back to the defaults defined in jdbc.A_Setup.DbConfig.

DROP TABLE IF EXISTS enrollment;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS student;

CREATE TABLE student (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    gpa         NUMERIC(3, 2) NOT NULL DEFAULT 0.0
);

CREATE TABLE course (
    id          SERIAL PRIMARY KEY,
    code        VARCHAR(10)  NOT NULL UNIQUE,
    title       VARCHAR(100) NOT NULL,
    credits     INT          NOT NULL
);

CREATE TABLE enrollment (
    student_id  INT NOT NULL REFERENCES student(id)  ON DELETE CASCADE,
    course_id   INT NOT NULL REFERENCES course(id)   ON DELETE CASCADE,
    grade       NUMERIC(4, 2),
    PRIMARY KEY (student_id, course_id)
);

INSERT INTO student (name, email, gpa) VALUES
    ('Alice Popescu',  'alice@example.com',  9.25),
    ('Bogdan Ionescu', 'bogdan@example.com', 8.10),
    ('Carmen Stan',    'carmen@example.com', 9.80),
    ('Dorian Vlad',    'dorian@example.com', 7.40);

INSERT INTO course (code, title, credits) VALUES
    ('PAO101', 'Object Oriented Programming', 6),
    ('DB201',  'Databases',                   5),
    ('ALG301', 'Algorithms',                  6);

INSERT INTO enrollment (student_id, course_id, grade) VALUES
    (1, 1, 9.5),
    (1, 2, 9.0),
    (2, 1, 8.0),
    (2, 3, 7.5),
    (3, 2, 10.0),
    (3, 3, 9.5),
    (4, 1, 7.0);

-- Stored procedure used by jdbc.G_CallableStatement.
-- Returns the average grade of a given student via an OUT parameter.
CREATE OR REPLACE PROCEDURE student_average(
    IN  p_student_id INT,
    OUT p_average    NUMERIC
)
LANGUAGE plpgsql AS $$
BEGIN
    SELECT AVG(grade) INTO p_average
    FROM enrollment
    WHERE student_id = p_student_id;
END;
$$;
