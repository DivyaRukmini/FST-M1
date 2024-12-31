-- Activity9

-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

OUTPUT:
Table created.

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

OUTPUT:
8 row(s) inserted.

-- Write an SQL statement to know which salesman are working for which customer.
SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

OUTPUT:

Customer Name	CITY		Salesman	COMMISSION
Graham Zusi	California	Nail Knite	13
Julian Green	London		Nail Knite	13
Fabian Johnson	Paris		Pierre		14
Geoff Cameron	Berlin		Lauson Hen	12
Jozy Altidor	Moscow		Paul Adam	13
Brad Guzan	London		Pit Alex	11

6 rows selected.

-- Write an SQL statement to make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman
SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city FROM customers a 
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300 
ORDER BY a.customer_id;

OUTPUT:

CUSTOMER_NAME	CITY		GRADE	Salesman	SALESMAN_CITY
Nick Rimando	New York	100	 - 	 	- 
Jozy Altidor	Moscow		200	Paul Adam	Rome
Graham Zusi	California	200	Nail Knite	Paris
Brad Davis	New York	200	 - 	 	- 
Geoff Cameron	Berlin		100	Lauson Hen	San Jose

5 rows selected.

-- Write an SQL statement to find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%.
SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a 
INNER JOIN salesman b ON a.salesman_id=b.salesman_id 
WHERE b.commission>12;

OUTPUT:

Customer Name	CITY		Salesman	COMMISSION
Graham Zusi	California	Nail Knite	13
Julian Green	London		Nail Knite	13
Fabian Johnson	Paris		Pierre		14
Jozy Altidor	Moscow		Paul Adam	13

4 rows selected.

-- Write an SQL statement to find the details of a order i.e. order number, order date, amount of order, which customer gives the order and which salesman works for that customer and commission rate he gets for an order.
SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

OUTPUT:

ORDER_NO	ORDER_DATE	PURCHASE_AMOUNT	Customer Name	GRADE	Salesman	COMMISSION
70001		05-OCT-12	150.5		Graham Zusi	200	Nail Knite	13
70007		10-SEP-12	948.5		Graham Zusi	200	Nail Knite	13
70012		27-JUN-12	250.45		Julian Green	300	Nail Knite	13
70010		10-OCT-12	1983.43		Fabian Johnson	300	Pierre		14
70004		17-AUG-12	110.5		Geoff Cameron	100	Lauson Hen	12
70003		10-OCT-12	2480.4		Geoff Cameron	100	Lauson Hen	12
70011		17-AUG-12	75.29		Jozy Altidor	200	Paul Adam	13
70009		10-SEP-12	270.65		Brad Guzan	300	Pit Alex	11
	
8 rows selected.
