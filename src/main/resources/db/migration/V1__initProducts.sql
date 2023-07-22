create table if not exists products(id  bigserial NOT NULL PRIMARY KEY, title VARCHAR(50) NOT NULL, price DOUBLE NOT NULL);

INSERT INTO products (title,price)
 VALUES
('Apple', 50),
('Milk', 100),
('Eggs', 120),
('Milkshake',160),
('Bread',50);
