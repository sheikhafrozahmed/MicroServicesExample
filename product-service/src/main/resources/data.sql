DROP TABLE IF EXISTS products;

CREATE TABLE products (
			id int auto_increment PRIMARY KEY,
			name VARCHAR(200) NOT NULL,
			quantity int);
			
INSERT INTO products (name,quantity) VALUES 
			('Mobiles', 10),
			('Vacuum Cleaner', 25),
			('Laptops', 8),
			('TV', 5);