# Day 9 - JPA / Hibernate

## ¿Qué es JPA?

**Concepto:** Especificación de Java para mapear objetos a tablas de base de datos.

Permite trabajar con objetos Java en lugar de escribir SQL constantemente.

---

## ¿Qué es Hibernate?

**Concepto:** Implementación más popular de JPA.

Se encarga de:

- Generar SQL.
- Mapear objetos a tablas.
- Gestionar relaciones.
- Manejar persistencia.

---

# Entity

## Concepto

Clase Java que representa una tabla de base de datos.

Ejemplo:

```java
@Entity
public class Customer {
}
```

---

## @Id

Identifica la Primary Key.

```java
@Id
private Long id;
```

---

## @GeneratedValue

Genera IDs automáticamente.

```java
@GeneratedValue
private Long id;
```

---

# Relaciones

## @OneToMany

Un registro tiene muchos relacionados.

Ejemplo:

```text
Customer 1 ---- * Orders
```

```java
@OneToMany
private List<Order> orders;
```

---

## @ManyToOne

Muchos registros pertenecen a uno.

Ejemplo:

```text
Order * ---- 1 Customer
```

```java
@ManyToOne
private Customer customer;
```

---

# Lazy Loading

## Concepto

Los datos relacionados se cargan únicamente cuando son necesarios.

Ejemplo:

```java
customer.getOrders();
```

En ese momento Hibernate consulta la base de datos.

---

## Ventajas

- Menor consumo de memoria.
- Mejor rendimiento inicial.

---

# Eager Loading

## Concepto

Los datos relacionados se cargan inmediatamente.

Ejemplo:

```java
Customer
  +
Orders
```

Todo se obtiene en una sola operación.

---

## Ventajas

- Datos disponibles inmediatamente.

## Desventajas

- Puede traer información innecesaria.

---

# Lazy vs Eager

| Lazy | Eager |
|--------|--------|
| Carga bajo demanda | Carga inmediata |
| Más eficiente | Más simple |
| Menos datos iniciales | Más consultas grandes |

---

# N+1 Problem

## Concepto

Problema de rendimiento causado por múltiples consultas innecesarias.

Ejemplo:

```text
1 consulta para Customers
+
N consultas para Orders
```

```text
1 + N queries
```

---

## Ejemplo

```java
List<Customer> customers =
    repository.findAll();
```

Luego:

```java
customer.getOrders();
```

para cada cliente.

Resultado:

```text
1 consulta customers
10 consultas orders
```

Si hay 10 clientes.

---

## Solución

Utilizar:

```java
JOIN FETCH
```

o consultas optimizadas.

---

# Repository

## Concepto

Capa que accede a la base de datos.

Ejemplo:

```java
public interface CustomerRepository
    extends JpaRepository<
        Customer,
        Long
    > {
}
```

Spring genera automáticamente las operaciones CRUD.

---

# Bases de Datos Comunes

## PostgreSQL

Características:

- Open Source
- Muy utilizada en backend moderno
- Excelente soporte SQL

---

## MySQL

Características:

- Open Source
- Muy popular
- Fácil de aprender

---

# Flujo JPA

```text
Entity
   ↓
Repository
   ↓
Hibernate
   ↓
Database
```

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| JPA | Especificación ORM de Java |
| Hibernate | Implementación de JPA |
| @Entity | Representa una tabla |
| @Id | Clave primaria |
| @GeneratedValue | Genera IDs automáticamente |
| @OneToMany | Uno a muchos |
| @ManyToOne | Muchos a uno |
| Lazy Loading | Carga bajo demanda |
| Eager Loading | Carga inmediata |
| N+1 Problem | Exceso de consultas SQL |
| JpaRepository | CRUD automático |
| PostgreSQL | Base de datos relacional |
| MySQL | Base de datos relacional |