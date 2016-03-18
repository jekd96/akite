CREATE SEQUENCE hibernate_sequence;
CREATE TABLE clients (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  uuid                VARCHAR
);

CREATE TABLE groups (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,
  name                VARCHAR
);

CREATE TABLE students (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,
  name                VARCHAR,
  surname             VARCHAR,
  patronymic          VARCHAR,
  year_birth          DATE,
  year_revenue        DATE,
  group_id            BIGINT,
  speciality_id BIGINT,
  phone_student VARCHAR,
  phone_parents VARCHAR,
  address VARCHAR,
  sex_id BIGINT DEFAULT 3,
  passport_data VARCHAR,
  indifikatsionny_code VARCHAR,
  form_training_id BIGINT
);

CREATE TABLE sex (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,
  name                VARCHAR
);

CREATE TABLE form_training (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,
  name                VARCHAR
);

INSERT INTO sex(name) VALUES ('Мужской');
INSERT INTO sex(name) VALUES ('Женский');
INSERT INTO sex(name) VALUES ('Не определено');

INSERT INTO sex(name) VALUES ('Бюджет');
INSERT INTO sex(name) VALUES ('Контракт');
INSERT INTO sex(name) VALUES ('Не определено');

CREATE TABLE employees (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,

  name VARCHAR,
  date_of_birth TIMESTAMP DEFAULT now(),
  position_id BIGINT,
  date_of_issue TIMESTAMP DEFAULT now(),
  phone VARCHAR,
  home_address VARCHAR,
  place_of_residence VARCHAR,
  series_passport_number VARCHAR,
  indifikatsionny_code VARCHAR
);

CREATE TABLE position (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,

  position_name VARCHAR

);

CREATE TABLE speciality (
  id                  SERIAL PRIMARY KEY,
  version             BIGINT    DEFAULT 0,
  created_date        TIMESTAMP DEFAULT now(),
  last_modified_date  TIMESTAMP DEFAULT now(),
  created_by_id       BIGINT,
  last_modified_by_id BIGINT,
  client_id           BIGINT,

  name_speciality VARCHAR
)

