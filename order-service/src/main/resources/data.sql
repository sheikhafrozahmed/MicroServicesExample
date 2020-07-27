DROP TABLE IF EXISTS orders;

CREATE TABLE orders (id int auto_increment,
			name varchar(200) NOT NULL,
			order_date date default SYSDATE,
			address varchar(200) NOT NULL,
			product_id int,
			price int);
			
		
INSERT INTO orders (name,address,product_id,price) VALUES 
			('A','Hyderabad',3,26000),
			('B','Hyderabad',2,9000),
			('C','Hyderabad',1,10000),
			('A','Hyderabad',1,10000),
			('D','Hyderabad',2,9000);