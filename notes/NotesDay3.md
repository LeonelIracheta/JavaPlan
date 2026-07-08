# Day 3 - Clean Code + Exceptions

## Clean Code

### Naming

**Concepto:** Los nombres deben expresar claramente su propósito.

✅ Bueno

```java
CustomerService
findCustomerById()
activeCustomers
```

❌ Malo

```java
CS
process()
data
```

**Regla:** El código debe leerse como una explicación.

---

### Small Methods

**Concepto:** Los métodos deben hacer una sola cosa.

✅ Bueno

```java
validateCustomer()
saveCustomer()
sendNotification()
```

❌ Malo

```java
processCustomer()
```

Si valida, guarda, envía correos y genera reportes.

**Regla:** Un método = una responsabilidad.

---

### Immutability

**Concepto:** Un objeto no puede cambiar su estado después de crearse.

Ejemplo:

```java
public record Customer(
    Long id,
    String name
) {}
```

o

```java
private final String name;
```

**Ventajas:**

- Más seguro
- Menos bugs
- Thread-safe

---

### Defensive Programming

**Concepto:** Validar entradas y estados antes de ejecutar lógica.

Ejemplo:

```java
if (customer == null) {
    throw new IllegalArgumentException(
        "Customer cannot be null"
    );
}
```

**Objetivo:** Fallar rápido y de forma controlada.

---

# Exceptions

## ¿Qué es una Exception?

**Concepto:** Error que ocurre durante la ejecución del programa.

Ejemplo:

```java
throw new RuntimeException(
    "Unexpected error"
);
```

---

## Jerarquía Básica

```text
Throwable
 ├── Error
 └── Exception
      └── RuntimeException
```

### Throwable

Clase raíz de todos los errores y excepciones.

---

### Exception

Errores recuperables.

Ejemplos:

- IOException
- SQLException

---

### RuntimeException

Errores de programación.

Ejemplos:

- NullPointerException
- IllegalArgumentException
- IndexOutOfBoundsException

---

# Custom Exceptions

## BusinessException

**Concepto:** Error relacionado con reglas de negocio.

Ejemplo:

```java
throw new BusinessException(
    "Customer already exists"
);
```

---

## ValidationException

**Concepto:** Datos inválidos.

Ejemplo:

```java
throw new ValidationException(
    "Email is invalid"
);
```

---

## NotFoundException

**Concepto:** Recurso no encontrado.

Ejemplo:

```java
throw new NotFoundException(
    "Customer not found"
);
```

---

## Ejemplo de uso

```java
Customer customer =
    repository.findById(id)
        .orElseThrow(
            () -> new NotFoundException(
                "Customer not found: " + id
            )
        );
```

---

# Buenas Prácticas con Exceptions

### Crear excepciones específicas

✅

```java
CustomerNotFoundException
```

❌

```java
Exception
RuntimeException
```

---

### Mensajes claros

✅

```java
"Customer not found: 100"
```

❌

```java
"Error"
```

---

### No ocultar excepciones

❌

```java
catch (Exception e) {
}
```

Siempre registrar o propagar el error.

---

### Usar RuntimeException para lógica de negocio

Común en aplicaciones modernas Java.

Ejemplo:

```java
BusinessException
ValidationException
NotFoundException
```

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| Naming | Nombres claros y descriptivos |
| Small Methods | Un método, una responsabilidad |
| Immutability | Estado no modificable |
| Defensive Programming | Validar antes de ejecutar |
| Throwable | Raíz de errores y excepciones |
| Exception | Error recuperable |
| RuntimeException | Error de ejecución |
| BusinessException | Regla de negocio |
| ValidationException | Datos inválidos |
| NotFoundException | Recurso no encontrado |