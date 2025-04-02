CREATE TABLE Persons (
  ID INT NOT NULL,
  LastName VARCHAR(255) NOT NULL,
  FirstName VARCHAR(255),
  Age INT,
  Salary INT,
  CHECK (Salary >= 200000 AND Salary <= 400000)
);

ALTER TABLE Persons
ADD CHECK (Age >= 18);

CREATE TABLE Persons1 (
  ID INT NOT NULL,
  LastName VARCHAR(255) NOT NULL,
  FirstName VARCHAR(255),
  Age INT,
  City VARCHAR(255) DEFAULT 'Coimbatore'
);

DESC Persons1;

USE org123;

SHOW TABLES FROM org123;

SELECT * FROM Worker;

SELECT * FROM Worker WHERE first_name LIKE '_i_a%';

SELECT * FROM Worker WHERE salary LIKE '8%';

CREATE VIEW admin_more_salary AS
SELECT * FROM Worker 
WHERE department = 'Admin' AND salary >= 100000 ORDER BY salary DESC;

SELECT * FROM admin_more_salary;

