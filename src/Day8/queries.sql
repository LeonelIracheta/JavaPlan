SELECT *
FROM customer;

SELECT *
FROM order_item;

SELECT *
FROM orders;

-- Ver órdenes con cliente
SELECT
    c.name,
    o.id,
    o.total
FROM customer c
JOIN orders o
ON c.id = o.customer_id;

-- Obtener total comprado por cliente
SELECT
    c.name,
    SUM(o.total) AS total_spent
FROM customer c
JOIN orders o
ON c.id = o.customer_id
GROUP BY c.name;

-- Clientes sin órdenes
SELECT
    c.name
FROM customer c
LEFT JOIN orders o
ON c.id = o.customer_id
WHERE o.id IS NULL;
