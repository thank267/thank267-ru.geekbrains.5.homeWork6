DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS buyers;
CREATE TABLE IF NOT EXISTS buyers (id bigserial, name VARCHAR(255) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS products (id bigserial, cost int NOT NULL , title VARCHAR(255) NOT NULL, PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS orders (buyer_id bigserial, product_id bigserial, cost int NOT NULL, PRIMARY KEY (buyer_id,product_id),CONSTRAINT `FK_PRODUCT_ID` FOREIGN KEY (product_Id) REFERENCES products (id), CONSTRAINT `FK_BUYER_ID` FOREIGN KEY (buyer_id) REFERENCES buyers (id));

INSERT INTO products (title, cost) VALUES ( 'Apple', 10 );
INSERT INTO products (title, cost) VALUES ( 'Banana', 20 );
INSERT INTO products (title, cost) VALUES ( 'Watermelon', 8 );
INSERT INTO products (title, cost) VALUES ( 'Orange', 12 );
INSERT INTO products (title, cost) VALUES ( 'Lemon', 13 );
INSERT INTO products (title, cost) VALUES ( 'Dragon fruit', 20 );
INSERT INTO products (title, cost) VALUES ( 'Blueberries', 15 );
INSERT INTO products (title, cost) VALUES ( 'Raspberry', 21 );
INSERT INTO products (title, cost) VALUES ( 'Strawberry', 18 );
INSERT INTO products (title, cost) VALUES ( 'Blackberry', 17 );

INSERT INTO buyers (name) VALUES ( 'Bob');
INSERT INTO buyers (name) VALUES ( 'John' );
INSERT INTO buyers (name) VALUES ( 'Clark');
INSERT INTO buyers (name) VALUES ( 'Mark' );
INSERT INTO buyers (name) VALUES ( 'Lemon' );

INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 1, 1, 9);
INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 1, 2, 19);
INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 1, 5, 10);

INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 3, 1, 9);
INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 3, 2, 19);
INSERT INTO orders (buyer_id, product_id, cost) VALUES ( 3, 10, 10);
