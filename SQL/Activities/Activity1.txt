-- Activity1

-- Create salesman table
CREATE TABLE salesman (
    salesman_id int NOT NULL,
    salesman_name varchar2(32),
    salesman_city varchar2(32),
    commission int
);

DESC salesman;

OUTPUT:

TABLE SALESMAN 
Column		Null?		Type
SALESMAN_ID	NOT NULL	NUMBER
SALESMAN_NAME	 - 		VARCHAR2(32)
SALESMAN_CITY	 - 		VARCHAR2(32)
COMMISSION	 - 		NUMBER

4 rows selected.