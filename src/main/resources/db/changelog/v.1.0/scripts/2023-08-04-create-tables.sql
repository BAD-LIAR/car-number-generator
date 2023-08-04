CREATE TABLE IF NOT EXISTS car_number (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    country varchar(255) DEFAULT NULL,
    letters_numb integer DEFAULT NULL,
    number_value integer DEFAULT NULL,
    state_value integer DEFAULT NULL
    );