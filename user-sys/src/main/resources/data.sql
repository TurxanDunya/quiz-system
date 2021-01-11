DROP TABLE IF EXISTS real_exams;

CREATE TABLE real_exams
(
    id                   INTEGER AUTO_INCREMENT PRIMARY KEY,
    name                 VARCHAR(250),
    surname              VARCHAR(250),
    exam                 VARCHAR(250),
    exam_date            TIMESTAMP,
    exam_expiration_date TIMESTAMP,
    location             VARCHAR(255)
);

INSERT INTO real_exams (name, surname, exam, exam_date, exam_expiration_date, location)
VALUES ('Alim', 'Marcellus', 'Philophosy', '2020-12-27T17:38:30', '2020-12-27T19:08:30', '125 sayli merkez'),
       ('Bill', 'Gates', 'Software Engineer', '2020-12-27T17:38:30', '2020-12-27T19:08:30', '153 sayli merkez'),
       ('Mate', 'Adam', 'Mathematics', '2020-12-27T17:38:30', '2020-12-27T19:08:30', '45 sayli merkez'),
       ('Kate', 'Ola', 'Literature', '2020-12-27T17:38:30', '2020-12-27T19:08:30', '63 sayli merkez');

DROP TABLE IF EXISTS exam_questions_for_student;

CREATE TABLE exam_questions_for_student
(
    id      INTEGER AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(250),
    surname VARCHAR(250),
    subject VARCHAR(250),
    type    INTEGER
);

INSERT INTO exam_questions_for_student ()
VALUES ()