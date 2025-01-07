-- Activity3
-- Show data from the salesman_id and city columns
SELECT salesman_id, salesman_city FROM salesman;

OUTPUT:

SALESMAN_ID	SALESMAN_CITY
5002		Paris
5005		London
5006		Paris
5007		Rome
5003		San Jose

5 rows selected.

-- Show data of salesman from Paris
SELECT * FROM salesman WHERE salesman_city='Paris';

OUTPUT:

SALESMAN_ID	SALESMAN_NAME	SALESMAN_CITY	COMMISSION
5002		Nail Knite	Paris		13
5006		McLyon		Paris		14

2 rows selected.

-- Show salesman_id and commission of Paul Adam
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Paul Adam';

OUTPUT:

SALESMAN_ID	COMMISSION
5007		13