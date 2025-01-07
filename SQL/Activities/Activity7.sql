-- Activity7

-- Write an SQL statement to find the total purchase amount of all orders.
select SUM(purchase_amount) AS "Total sum" from orders;

OUTPUT:

Total sum
17541.18


-- Write an SQL statement to find the average purchase amount of all orders.
select AVG(purchase_amount) AS "Average" from orders;

OUTPUT:
Average
1461.765


-- Write an SQL statement to get the maximum purchase amount of all the orders.
select MAX(purchase_amount) AS "Maximum" from orders;

OUTPUT:
Maximum
5760


-- Write an SQL statement to get the minimum purchase amount of all the orders.
select MIN(purchase_amount) AS "Minumum" from orders;

OUTPUT:
Minumum
65.26


-- Write an SQL statement to find the number of salesmen listed in the table.
select COUNT(distinct salesman_id) AS "Total count" from orders;

OUTPUT:
Total count
6
