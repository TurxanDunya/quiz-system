CREATE TABLE questions
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(250) NOT NULL,
    subject  VARCHAR(250) NOT NULL,
    type     INTEGER      NOT NULL
);

INSERT INTO questions (question, subject, type)
VALUES ('What is about Philosophy?', 'Philosophy', '1'),
       ('What is about Mathematics?', 'Mathematics', '2'),
       ('What is about Literature?', 'Literature', '3'),
       ('What is about Software Engineering?', 'Software Engineering', '4'),
       ('Why Mathematics is so crucial?', 'Mathematics', '2'),
       ('Why Literature is so crucial?', 'Literature', '3'),
       ('Why Philosophy is so crucial?', 'Philosophy', '1'),
       ('Why Software Engineering is so crucial?', 'Software Engineering', '4'),
       ('What brances is Mathematics have?', 'Mathematics', '2'),
       ('What brances is Philosophy have?', 'Philosophy', '1'),
       ('What brances is Literature have?', 'Literature', '3'),
       ('What brances is Software Engineering have?', 'Software Engineering', '4'),
       ('What about Mathematics book?', 'Mathematics', '2'),
       ('What about Philosophy book?', 'Philosophy', '1'),
       ('What about Software Engineering book?', 'Software Engineering', '4'),
       ('What about Literature book?', 'Literature', '3');

-- This tables belongs to EXAM

CREATE TABLE exam
(
    exam_date            TIMESTAMP,
    exam_expiration_date TIMESTAMP,
    location             VARCHAR(255)
);

INSERT INTO exam (exam_date, exam_expiration_date, location)
VALUES ('2020-12-27T17:38:30', '2020-12-27T19:08:30', '125 sayli merkez');