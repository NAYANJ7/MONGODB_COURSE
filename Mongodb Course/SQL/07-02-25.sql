CREATE DATABASE org123;

USE org123;

CREATE TABLE Category (
  C_ID INT PRIMARY KEY,
  C_Name VARCHAR(25) NOT NULL UNIQUE,
  C_Decrp VARCHAR(250) NOT NULL
);

INSERT INTO Category VALUES (102, 'Furnitures', 'it stores all set of wooden items');

SELECT * FROM Category;

DESC Category;

CREATE TABLE Products (
  P_ID INT PRIMARY KEY,
  P_Name VARCHAR(250) NOT NULL,
  C_ID INT,
  CONSTRAINT fk_category FOREIGN KEY (C_ID)
  REFERENCES Category(C_ID)
);

DESC Products;

INSERT INTO Products VALUES (904, 'Wooden table', 102);

SELECT * FROM Products;

SELECT * FROM Category;

