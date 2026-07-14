# Day 10 - Repository Pattern

## Repository Pattern

### Concepto

Patrón que encapsula el acceso a datos.

Su objetivo es separar la lógica de negocio de la lógica de persistencia.

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

---

# JpaRepository

## Concepto

Interfaz de Spring Data JPA que proporciona operaciones CRUD automáticamente.

```java
public interface CustomerRepository
    extends JpaRepository<Customer, Long> {
}
```

---

## Métodos Comunes

Buscar por ID:

```java
findById(id)
```

Guardar:

```java
save(customer)
```

Obtener todos:

```java
findAll()
```

Eliminar:

```java
deleteById(id)
```

---

# Derived Queries

## Concepto

Spring genera consultas automáticamente a partir del nombre del método.

---

## Ejemplos

Buscar por nombre:

```java
findByName(String name)
```

---

Buscar por email:

```java
findByEmail(String email)
```

---

Buscar clientes activos:

```java
findByActive(Boolean active)
```

---

Buscar por nombre y país:

```java
findByNameAndCountry(
    String name,
    String country
)
```

---

## Ventaja

No es necesario escribir SQL o JPQL para consultas simples.

---

# Custom Queries

## Concepto

Consultas definidas manualmente cuando las Derived Queries no son suficientes.

---

## @Query

```java
@Query("""
SELECT c
FROM Customer c
WHERE c.country = :country
""")
List<Customer> findByCountry(
    String country
);
```

---

## Cuándo usar

- Consultas complejas.
- Joins.
- Agregaciones.
- Optimización de rendimiento.

---

# Pagination

## Concepto

Permite dividir grandes cantidades de datos en páginas.

---

## Problema

Sin paginación:

```java
findAll()
```

Podría devolver miles de registros.

---

## Pageable

```java
Pageable pageable =
    PageRequest.of(0, 10);
```

---

## Ejemplo

```java
Page<Customer> customers =
    repository.findAll(pageable);
```

---

## Resultado

```text
Página 0
10 registros
```

---

# Clase Page

## Concepto

Representa una página de resultados.

---

## Métodos útiles

Contenido:

```java
page.getContent()
```

---

Total de elementos:

```java
page.getTotalElements()
```

---

Total de páginas:

```java
page.getTotalPages()
```

---

# Sorting

## Concepto

Permite ordenar resultados.

---

## Ejemplo

```java
Sort.by("name")
```

---

Orden ascendente:

```java
Sort.by("name").ascending()
```

---

Orden descendente:

```java
Sort.by("name").descending()
```

---

# Ventajas de Spring Data JPA

- Menos código boilerplate.
- CRUD automático.
- Paginación integrada.
- Ordenamiento integrado.
- Consultas derivadas.
- Integración con Hibernate.

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| Repository Pattern | Separa acceso a datos de la lógica de negocio |
| JpaRepository | CRUD automático |
| findById | Buscar por ID |
| save | Guardar entidad |
| findAll | Obtener registros |
| deleteById | Eliminar registro |
| Derived Query | Consulta generada por el nombre del método |
| @Query | Consulta personalizada |
| Pageable | Configura paginación |
| Page | Resultado paginado |
| Sort | Ordenar resultados |