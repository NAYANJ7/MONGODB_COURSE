USE org123;

SELECT * FROM Worker;

SELECT department, COUNT(department) FROM Worker 
WHERE department IN ('admin', 'account') GROUP BY department;

SELECT department, COUNT(department) AS highest_head_count
FROM Worker
GROUP BY department
HAVING COUNT (department) >= 3;

CREATE TABLE vitBhopal (
  id INT PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  department VARCHAR(25) NOT NULL
);

INSERT INTO vitBhopal VALUES
  (104, 'Shubham', 'cs'),
  (103, 'Anjali', 'BEd');

CREATE TABLE vit (
  id INT PRIMARY KEY,
  name VARCHAR(20) NOT NULL,
  department VARCHAR(25) NOT NULL
);

INSERT INTO vit VALUES
  (104, 'Shubham', 'Samastipur'),
  (103, 'Anjali', 'Vidyapati');

SELECT * FROM vit;

SELECT * FROM vitBhopal;

SELECT vb.name AS WinnerOfTheYear
FROM vitBhopal vb
JOIN vit v ON vb.id = v.id;

