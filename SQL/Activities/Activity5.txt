-- Activity5

-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

OUTPUT:
1 row(s) updated.

-- Update the grade score of James Hoog to 300.
UPDATE salesman SET grade=300 WHERE salesman_name='James Hoog';

OUTPUT:
0 row(s) updated.

-- Update the name McLyon to Pierre.
UPDATE salesman SET salesman_name='Pierre' WHERE salesman_name='McLyon';

OUTPUT:
1 row(s) updated.

-- Display modified data
SELECT * FROM salesman;

OUTPUT:

SALESMAN_ID	SALESMAN_NAME	SALESMAN_CITY	COMMISSION	GRADE
5002		Nail Knite	Paris		13		100
5005		Pit Alex	London		11		100
5006		Pierre		Paris		14		100
5007		Paul Adam	Rome		13		200
5003		Lauson Hen	San Jose	12		100

5 rows selected.