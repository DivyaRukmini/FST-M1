-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

OUTPUT:

CUSTOMER_ID	CUSTOMER_NAME
3009		Geoff Cameron
3005		Graham Zusi
5003		Lauson Hen
5002		Nail Knite
3002		Nick Rimando

5 rows selected.

-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.salesman_id, a.salesman_name, b.order_no, 'highest on', b.order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, b.order_no, 'lowest on', b.order_date FROM salesman a, orders b
WHERE a.salesman_id=b.salesman_id
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

OUTPUT:
SALESMAN_ID	SALESMAN_NAME	ORDER_NO	'HIGHESTON'	ORDER_DATE
5002		Nail Knite	70001		highest on	05-OCT-12
5002		Nail Knite	70007		highest on	10-SEP-12
5002		Nail Knite	70012		highest on	27-JUN-12
5002		Nail Knite	70012		lowest on	27-JUN-12
5003		Lauson Hen	70003		highest on	10-OCT-12
5003		Lauson Hen	70004		highest on	17-AUG-12
5005		Pit Alex	70009		lowest on	10-SEP-12
5006		Pierre		70010		lowest on	10-OCT-12
5007		Paul Adam	70011		lowest on	17-AUG-12

9 rows selected.
