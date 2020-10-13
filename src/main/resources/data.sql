DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS companies;

CREATE TABLE customers (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  ADDRESS VARCHAR(250) NOT NULL,
  COMPANIES VARCHAR(250) NOT NULL
);

INSERT INTO customers (ID, FIRST_NAME, LAST_NAME, ADDRESS, COMPANIES) VALUES
  (1, 'Ismo', 'Laitela', 'Pihlajakatu 6', '1,2'),
  (2, 'Esko', 'Aho', 'Ahokatu 2', '2'),
  (3, 'Pekka', 'Pouta', 'Pekankatu 4', '3'),
  (4, 'Ruben', 'Stiller', 'Pekankatu 4', '1,2,3');

CREATE TABLE companies (
  id INT PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  PHONE_NUMBER VARCHAR(250) NOT NULL
);

INSERT INTO companies (ID, NAME, PHONE_NUMBER) VALUES
  (1, 'Einon Makkara Ky', '050 456456'),
  (2, 'Siwa', '0400 567456'),
  (3, 'Gigantti', '044 345345');