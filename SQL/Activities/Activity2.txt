-- Activity2
-- Insert one row
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- View data from all columns
SELECT * FROM salesman;


OUTPUT:


SALESMAN_ID	SALESMAN_NAME	SALESMAN_CITY	COMMISSION
5002		Nail Knite	Paris		13
5005		Pit Alex	London		11
5006		McLyon		Paris		14
5007		Paul Adam	Rome		13
5003		Lauson Hen	San Jose	12

5 rows selected.