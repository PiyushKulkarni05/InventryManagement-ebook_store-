CREATE SCHEMA `inventry_management(database)`.'customer'(
'id' INT NOT AUTO_INCREMENT,
'name' VARCHAR(60) NOT NULL,
'email' VARcustomerCHAR(100) NOT NULL,
'mobile' CHAR(12) NOT NULL,
'password' VARCHAR(100) NOT NULL,
'address' VARCHAR(200) NULL,
PRIMARY KEY ('id'));

INSERT INTO customer(id,name,email,password,mobile_no) VALUES(1,'Piyush','piyushvjkulkarni2005@gmail.com','abc123','8421862563');
SELECT * FROM customer;
INSERT INTO customer1(name,email,mobile,password) VALUES('Piyush','piyush','8421862563','abc123');


CREATE TABLE customer (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    mobile_no VARCHAR(15)
);


INSERT INTO customer1(name,email,mobile,password) VALUES('Piyush','piyushvjkulkarni2005@gmail.com','8421862563','abc123');
SELECT * FROM customer1;
INSERT INTO customer1(name,email,mobile,password) VALUES('Piyush','piyush','8421862563','abc123');

DELETE FROM customer1 WHERE id=2;
UPDATE customer1 SET password = 'abc345' WHERE id = 4;

SELECT id,name,author,price FROM product;


SELECT * FROM orders;
INSERT INTO orders(group_order_id,customer_id,product_id,quantity) VALUES(1,1,1,1);
ALTER TABLE orders 

ADD group_order_id INT AFTER id;









