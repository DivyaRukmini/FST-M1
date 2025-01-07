-- Activity10

-- Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * FROM orders
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

OUTPUT:
ORDER_NO	PURCHASE_AMOUNT	ORDER_DATE	CUSTOMER_ID	SALESMAN_ID
70002		65.26		05-OCT-12	3002		5001
70005		2400.6		27-JUL-12	3007		5001
70008		5760		15-AUG-12	3002		5001
70013		3045.6		25-APR-12	3002		5001

4 rows selected.

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

OUTPUT:
no data found

-- Write a query to find all orders attributed to a salesman in Paris.
SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='Paris');

OUTPUT:

ORDER_NO	PURCHASE_AMOUNT	ORDER_DATE	CUSTOMER_ID	SALESMAN_ID
70001		150.5		05-OCT-12	3005		5002
70007		948.5		10-SEP-12	3005		5002
70012		250.45		27-JUN-12	3008		5002
70010		1983.43		10-OCT-12	3004		5006

4 rows selected.


-- Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE salesman_city='New York');

-- corrected query:
-- Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

OUTPUT:

GRADE	COUNT(*)
200	3
300	3

2 rows selected.

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders
WHERE salesman_id IN( SELECT salesman_id FROM salesman
WHERE commission=( SELECT MAX(commission) FROM salesman));

OUTPUT:

ORDER_NO	PURCHASE_AMOUNT	ORDER_DATE	SALESMAN_ID
70010		1983.43		10-OCT-12	5006
