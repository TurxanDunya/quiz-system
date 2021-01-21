DROP TABLE IF EXISTS teachers;

CREATE TABLE teachers
(
    id      INTEGER AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(250) NOT NULL,
    surname VARCHAR(250) NOT NULL,
    subject VARCHAR(250) NOT NULL
);

INSERT INTO teachers (name, surname, subject)
VALUES ('Alim', 'Marcellus', 'Philophosy'),
       ('Bill', 'Gates', 'Software Engineer'),
       ('Mate', 'Adam', 'Mathematics'),
       ('Kate', 'Ola', 'Literature');

-- From now, rest of the table belongs to students

CREATE TABLE students
(
    id      INTEGER AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(250) NOT NULL,
    surname VARCHAR(250) NOT NULL
);

INSERT INTO students (name, surname)
VALUES ('Sam', 'Brown'),
       ('Mike', 'James'),
       ('John', 'Saint'),
       ('Miles', 'Morales');
