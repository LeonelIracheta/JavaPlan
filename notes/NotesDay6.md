# Day 6 - Testing

## ¿Qué es Testing?

**Concepto:** Proceso para verificar que el código funciona como se espera.

**Beneficios:**

- Detecta errores temprano.
- Facilita refactorizaciones.
- Aumenta la confianza en el código.

---

# Testing Pyramid

```text
       E2E
    Integration
     Unit Tests
```

## Unit Tests

**Concepto:** Prueban una clase o método de forma aislada.

- Rápidos.
- Fáciles de mantener.
- Deben ser la mayoría de las pruebas.

Ejemplo:

```java
service.getCustomerById(1L);
```

---

## Integration Tests

**Concepto:** Verifican la interacción entre varios componentes.

Ejemplo:

```text
Controller → Service → Repository
```

Comprueban que las capas trabajen juntas correctamente.

---

## End-to-End (E2E)

**Concepto:** Simulan el comportamiento real del usuario.

Ejemplo:

```text
Cliente → API → Base de Datos
```

Son las más completas pero también las más lentas.

---

# JUnit 5

## Concepto

Framework estándar para pruebas en Java.

---

## @Test

Marca un método como prueba.

```java
@Test
void shouldReturnCustomer() {
}
```

---

## Assertions

Verifican resultados esperados.

```java
assertEquals(expected, actual);
```

```java
assertTrue(condition);
```

```java
assertNotNull(object);
```

---

# Mockito

## Concepto

Framework para crear objetos simulados (Mocks).

Permite probar una clase sin depender de componentes reales.

---

## @Mock

Crea una dependencia simulada.

```java
@Mock
CustomerRepository repository;
```

---

## @InjectMocks

Inyecta los mocks en la clase bajo prueba.

```java
@InjectMocks
CustomerService service;
```

---

## when()

Define el comportamiento del mock.

```java
when(repository.findById(1L))
    .thenReturn(customer);
```

---

## verify()

Verifica que un método fue ejecutado.

```java
verify(repository)
    .findById(1L);
```

---

# Estructura AAA

## Arrange

Preparar datos.

```java
Customer customer =
    new Customer();
```

---

## Act

Ejecutar acción.

```java
service.getCustomerById(1L);
```

---

## Assert

Validar resultado.

```java
assertEquals(
    customer,
    result
);
```

---

# Buenas Prácticas

### Un test = un comportamiento

✅

```java
shouldReturnCustomerWhenIdExists()
```

❌

```java
testCustomer()
```

---

### Nombres descriptivos

Usar formato:

```text
should + ExpectedResult + Condition
```

Ejemplo:

```java
shouldThrowExceptionWhenCustomerNotFound()
```

---

### No probar implementación

Probar comportamiento.

✅

```java
Customer encontrado correctamente
```

❌

```java
Método interno llamado 5 veces
```

---

### Mantener tests independientes

Cada test debe ejecutarse sin depender de otros.

---

# Tipos de Pruebas en Spring

## Service Test

Prueba lógica de negocio.

Dependencias simuladas con Mockito.

```java
CustomerService
```

---

## Controller Test

Prueba endpoints HTTP.

```java
GET /customers
POST /customers
```

Verifica:

- Status Code
- Request
- Response

---

# Cobertura (Coverage)

## Concepto

Porcentaje de código ejecutado por las pruebas.

Objetivo recomendado:

```text
70%+
```

**Importante:**

Mayor cobertura ≠ mejor calidad.

Lo importante es probar los casos relevantes.

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| Testing | Verificar comportamiento |
| Unit Test | Prueba una clase aislada |
| Integration Test | Prueba interacción entre capas |
| E2E Test | Prueba flujo completo |
| JUnit 5 | Framework de pruebas |
| @Test | Marca una prueba |
| assertEquals | Compara resultados |
| Mockito | Simula dependencias |
| @Mock | Crea un mock |
| @InjectMocks | Inyecta mocks |
| when | Configura comportamiento |
| verify | Verifica ejecución |
| AAA | Arrange, Act, Assert |
| Coverage | % de código probado |