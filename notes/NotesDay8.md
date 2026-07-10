# Day 8 - SQL Fundamentals

## ¿Qué es SQL?

**Concepto:** Lenguaje utilizado para almacenar, consultar y manipular datos en bases de datos relacionales.

Ejemplos:

- MySQL
- PostgreSQL
- SQL Server
- Oracle

---

# Tables

## Concepto

Una tabla almacena datos organizados en filas y columnas.

Ejemplo:

### Customer

| id | name | email |
|----|------|--------|
| 1 | Leonel | leo@email.com |

---

### Order

| id | customer_id | total |
|----|------------|--------|
| 1 | 1 | 150 |

---

# Primary Key (PK)

## Concepto

Identificador único de cada registro.

Ejemplo:

```sql
id
```

Características:

- Única
- No nula

---

# Foreign Key (FK)

## Concepto

Columna que referencia la Primary Key de otra tabla.

Ejemplo:

```sql
customer_id
```

Permite relacionar tablas.

---

# Relationships

## One-to-Many (1:N)

Un cliente puede tener muchas órdenes.

```text
Customer 1 ---- * Order
```

Ejemplo:

```text
Customer
  └── Order 1
  └── Order 2
  └── Order 3
```

---

## Many-to-One (N:1)

Muchas órdenes pertenecen a un cliente.

```text
Order * ---- 1 Customer
```

---

## Ejemplo de Modelo

```text
Customer
    |
    | 1
    |
    *
Order
    |
    | 1
    |
    *
OrderItem
```

---

# Indexes

## Concepto

Estructuras que aceleran las búsquedas.

Ejemplo:

```sql
CREATE INDEX idx_email
ON customer(email);
```

---

## Ventaja

Más rápido:

```sql
SELECT *
FROM customer
WHERE email = 'test@mail.com';
```

---

## Desventaja

- Ocupan espacio.
- Hacen más lentos los INSERT y UPDATE.

---

# Transactions

## Concepto

Grupo de operaciones que se ejecutan como una sola unidad.

---

## Propósito

Garantizar consistencia de los datos.

Ejemplo:

```text
Transferencia bancaria
```

```text
Cuenta A -100
Cuenta B +100
```

Ambas operaciones deben completarse o ninguna.

---

## COMMIT

Guarda los cambios.

```sql
COMMIT;
```

---

## ROLLBACK

Revierte los cambios.

```sql
ROLLBACK;
```

---

# ACID

## Atomicity

Todo o nada.

---

## Consistency

Los datos permanecen válidos.

---

## Isolation

Las transacciones no interfieren entre sí.

---

## Durability

Los cambios confirmados no se pierden.

---

# Consultas Básicas

## SELECT

Consultar datos.

```sql
SELECT *
FROM customer;
```

---

## INSERT

Crear registros.

```sql
INSERT INTO customer(name)
VALUES ('Leonel');
```

---

## UPDATE

Actualizar registros.

```sql
UPDATE customer
SET name = 'Leo'
WHERE id = 1;
```

---

## DELETE

Eliminar registros.

```sql
DELETE FROM customer
WHERE id = 1;
```

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| SQL | Lenguaje para bases de datos |
| Table | Almacena datos en filas y columnas |
| Primary Key | Identificador único |
| Foreign Key | Relaciona tablas |
| One-to-Many | Un registro tiene muchos relacionados |
| Index | Acelera búsquedas |
| Transaction | Grupo de operaciones atómicas |
| COMMIT | Guarda cambios |
| ROLLBACK | Revierte cambios |
| ACID | Garantiza integridad de datos |
| SELECT | Consultar |
| INSERT | Crear |
| UPDATE | Modificar |
| DELETE | Eliminar |