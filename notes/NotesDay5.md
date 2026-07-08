# Day 5 - REST API Best Practices

## ¿Qué es una REST API?

**Concepto:** Interfaz que permite la comunicación entre sistemas mediante HTTP.

Generalmente intercambia datos en formato JSON.

Ejemplo:

```http
GET /customers
```

---

# HTTP Methods

## GET

**Concepto:** Obtener información.

Ejemplo:

```http
GET /customers
GET /customers/1
```

**No modifica datos.**

---

## POST

**Concepto:** Crear un nuevo recurso.

Ejemplo:

```http
POST /customers
```

---

## PUT

**Concepto:** Reemplazar completamente un recurso existente.

Ejemplo:

```http
PUT /customers/1
```

---

## PATCH

**Concepto:** Actualizar parcialmente un recurso.

Ejemplo:

```http
PATCH /customers/1
```

---

## DELETE

**Concepto:** Eliminar un recurso.

Ejemplo:

```http
DELETE /customers/1
```

---

# HTTP Status Codes

## 200 OK

**Concepto:** Solicitud exitosa.

Ejemplo:

```http
GET /customers/1
```

---

## 201 CREATED

**Concepto:** Recurso creado correctamente.

Ejemplo:

```http
POST /customers
```

---

## 400 BAD REQUEST

**Concepto:** Datos inválidos enviados por el cliente.

Ejemplo:

```http
{
  "name": ""
}
```

---

## 404 NOT FOUND

**Concepto:** El recurso solicitado no existe.

Ejemplo:

```http
GET /customers/999
```

---

## 500 INTERNAL SERVER ERROR

**Concepto:** Error inesperado en el servidor.

Ejemplo:

```java
NullPointerException
```

---

# API Design

## URLs orientadas a recursos

✅ Bueno

```http
GET /customers
GET /customers/1
POST /customers
```

❌ Malo

```http
GET /getCustomers
POST /createCustomer
DELETE /deleteCustomer
```

**Regla:** Los endpoints representan recursos, no acciones.

---

## Usar nombres en plural

✅

```http
/customers
/orders
/products
```

❌

```http
/customer
/order
/product
```

---

## Mantener consistencia

✅

```http
/customers
/customers/1
```

❌

```http
/getCustomers
/customerDetails
/customerById
```

---

# DTO (Data Transfer Object)

## Concepto

Objeto utilizado para intercambiar información entre cliente y servidor.

Ayuda a desacoplar la API de las entidades internas.

---

## CustomerRequest

**Propósito:** Recibir datos del cliente.

Ejemplo:

```java
public class CustomerRequest {

    private String name;
    private String email;
}
```

---

## CustomerResponse

**Propósito:** Enviar datos al cliente.

Ejemplo:

```java
public class CustomerResponse {

    private Long id;
    private String name;
}
```

---

# Nunca Exponer Entidades

## ❌ Incorrecto

```java
@GetMapping
public Customer getCustomer() {
    return customer;
}
```

Problemas:

- Expone campos internos.
- Acopla la API a la base de datos.
- Riesgos de seguridad.

---

## ✅ Correcto

```java
@GetMapping
public CustomerResponse getCustomer() {
    return response;
}
```

La API controla exactamente qué datos expone.

---

# Flujo Recomendado

```text
Request
   ↓
Controller
   ↓
CustomerRequest
   ↓
Service
   ↓
Entity
   ↓
Database

Database
   ↓
Entity
   ↓
Service
   ↓
CustomerResponse
   ↓
Client
```

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| REST API | Comunicación vía HTTP |
| GET | Obtener datos |
| POST | Crear recurso |
| PUT | Reemplazar recurso |
| PATCH | Actualizar parcialmente |
| DELETE | Eliminar recurso |
| 200 | Operación exitosa |
| 201 | Recurso creado |
| 400 | Datos inválidos |
| 404 | Recurso no encontrado |
| 500 | Error interno |
| DTO | Objeto para intercambio de datos |
| Request DTO | Entrada de datos |
| Response DTO | Salida de datos |
| API Design | URLs basadas en recursos |
| Entidades | No deben exponerse directamente |