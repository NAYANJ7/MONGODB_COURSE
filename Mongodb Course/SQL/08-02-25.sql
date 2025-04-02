SHOW DATABASES;

USE org123;

CREATE TABLE Student (
  Sno INT PRIMARY KEY,
  Sname VARCHAR(20),
  Age INT
);

INSERT INTO Student (Sno, Sname, Age)
VALUES
  (1, 'Ankit', 17),
  (2, 'Ramya', 18),
  (3, 'Ram', 16);

CREATE TABLE Course (
  Cno INT PRIMARY KEY,
  Cname VARCHAR(20)
);

SELECT * FROM Course;

INSERT INTO Course (Cno, Cname)
VALUES
  (101, 'C'),
  (102, 'C++'),
  (103, 'DBMS');

CREATE TABLE Enroll (
  Sno INT,
  Cno INT,
  Jdate DATE,
  PRIMARY KEY (Sno, Cno),
  FOREIGN KEY (Cno)
  REFERENCES Course(Cno)
  ON DELETE CASCADE,
  FOREIGN KEY (Sno)
  REFERENCES Student(Sno)
  ON DELETE CASCADE
);

INSERT INTO Enroll (Sno, Cno, Jdate)
VALUES (2, 102, '2022-05-05');

SELECT * FROM Enroll;

DESC Enroll;

