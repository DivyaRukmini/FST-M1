-- Activity4

-- Add the grade column
ALTER TABLE salesman ADD grade int;

OUTPUT:
Table altered.

-- Update the values in the grade column
UPDATE salesman SET grade=100;

OUTPUT:
5 row(s) updated.

-- Display data
SELECT * FROM salesman;

OUTPUT:

SALESMAN_ID	SALESMAN_NAME	SALESMAN_CITY	COMMISSION	GRADE
5002		Nail Knite	Paris		13		100
5005		Pit Alex	London		11		100
5006		McLyon		Paris		14		100
5007		Paul Adam	Rome		13		100
5003		Lauson Hen	San Jose	12		100

5 rows selected.