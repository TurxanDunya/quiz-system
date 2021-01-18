CREATE TABLE questions
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(250) NOT NULL,
    subject  VARCHAR(250) NOT NULL,
    type     INTEGER      NOT NULL,
    level    INTEGER      NOT NULL
);

INSERT INTO questions (question, subject, type, level)
VALUES ('What is about Philosophy?', 'Philosophy', '1', '1'),
       ('What is about Mathematics?', 'Mathematics', '2', '1'),
       ('What is about Literature?', 'Literature', '3', '1'),
       ('What is about Software Engineering?', 'Software Engineering', '4', '1'),
       ('Why Mathematics is so crucial?', 'Mathematics', '2', '2'),
       ('Why Literature is so crucial?', 'Literature', '3', '2'),
       ('Why Philosophy is so crucial?', 'Philosophy', '1', '2'),
       ('Why Software Engineering is so crucial?', 'Software Engineering', '4', '2'),
       ('What brances is Mathematics have?', 'Mathematics', '2', '3'),
       ('What brances is Philosophy have?', 'Philosophy', '1', '3'),
       ('What brances is Literature have?', 'Literature', '3', '3'),
       ('What brances is Software Engineering have?', 'Software Engineering', '4', '3'),
       ('What about Mathematics book?', 'Mathematics', '2', '4'),
       ('What about Philosophy book?', 'Philosophy', '1', '4'),
       ('What about Software Engineering book?', 'Software Engineering', '4', '4'),
       ('What about Literature book?', 'Literature', '3', '4');

-- This tables belongs to ANSWERS

CREATE TABLE answers
(
    type        INTEGER      NOT NULL,
    question_id INTEGER      NOT NULL,
    answer_A    VARCHAR(250) NOT NULL,
    answer_B    VARCHAR(250) NOT NULL,
    answer_C    VARCHAR(250) NOT NULL,
    answer_D    VARCHAR(250) NOT NULL,
    answer_E    VARCHAR(250) NOT NULL
);

INSERT INTO answers (type, question_id, answer_A, answer_B, answer_C, answer_D, answer_E)
VALUES ('1', '1', 'Philosophy', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('2', '2', 'Mathematics', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('3', '3', 'Literature', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('4', '4', 'Software Engineering', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('2', '5', 'Mathematics', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('3', '6', 'Literature', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('1', '7', 'Philosophy', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('4', '8', 'Software Engineering', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('2', '9', 'Mathematics', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('1', '10', 'Philosophy', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('3', '11', 'Literature', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('4', '12', 'Software Engineering', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('2', '13', 'Mathematics', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('1', '14', 'Philosophy', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('4', '15', 'Software Engineering', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew'),
       ('3', '16', 'Literature', 'cwecewv', 'wvwvw', 'advwvw', 'wcwcew');

-- This tables belongs to EXAM

CREATE TABLE exam
(
    exam_date            TIMESTAMP,
    exam_expiration_date TIMESTAMP,
    location             VARCHAR(255)
);

INSERT INTO exam (exam_date, exam_expiration_date, location)
VALUES ('2020-12-27T17:38:30', '2020-12-27T19:08:30', '125 sayli merkez');