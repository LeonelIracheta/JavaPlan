BEGIN;

INSERT INTO customer(name,email)
VALUES
('Leonel','leo@test.com'),
('Ana','ana@test.com'),
('Carlos','carlos@test.com');

INSERT INTO orders(customer_id,total)
VALUES
(1,1500.00),
(1,300.00),
(2,900.00);

INSERT INTO order_item(order_id,product_name,quantity,price)
VALUES
(1,'Laptop',1,1500.00),
(2,'Mouse',1,300.00),
(3,'Keyboard',1,900.00);

COMMIT;