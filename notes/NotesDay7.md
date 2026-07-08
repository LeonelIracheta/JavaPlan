# Day 7 - Review + Interview Preparation

## Java

### HashMap Internals

**Concepto:** Estructura de datos que almacena pares clave-valor.

**Características:**

- Búsqueda promedio O(1).
- Utiliza hashing.
- Permite una clave null.

**Proceso:**

```text
key → hash → bucket → value
```

**Entrevista:**
¿Qué pasa si dos claves tienen el mismo hash?

→ Ocurre una colisión y HashMap almacena múltiples elementos en el mismo bucket.

---

### equals() y hashCode()

**equals()**

Determina si dos objetos son lógicamente iguales.

```java
customer1.equals(customer2)
```

---

**hashCode()**

Genera un número utilizado por estructuras como HashMap y HashSet.

```java
customer.hashCode()
```

---

**Regla importante:**

Si dos objetos son iguales según equals():

```java
a.equals(b)
```

Entonces:

```java
a.hashCode() == b.hashCode()
```

Debe ser verdadero.

---

### String Immutable

**Concepto:** Un String no puede modificarse después de ser creado.

Ejemplo:

```java
String name = "Leo";

name.concat(" Jr");
```

Resultado:

```java
"Leo"
```

Se crea un nuevo String.

---

**Ventajas:**

- Seguridad.
- Thread-safe.
- Mejor rendimiento mediante String Pool.

---

### Stream vs Loop

#### Loop

```java
for(Customer c : customers) {
}
```

**Ventajas:**

- Fácil de depurar.
- Mejor para lógica compleja.

---

#### Stream

```java
customers.stream()
         .filter(...)
         .map(...);
```

**Ventajas:**

- Más declarativo.
- Más legible para transformaciones.
- Permite procesamiento paralelo.

---

**Entrevista:**

¿Cuál es mejor?

→ Depende del caso de uso. Streams para transformaciones; loops para lógica compleja o altamente personalizada.

---

### Optional

**Concepto:** Representa la posible ausencia de un valor.

Ejemplo:

```java
Optional<Customer>
```

---

**Beneficio principal:**

Reducir:

```java
NullPointerException
```

---

**Métodos comunes:**

```java
orElse()
orElseThrow()
ifPresent()
```

---

## Spring

### Dependency Injection (DI)

**Concepto:** Spring proporciona automáticamente las dependencias de una clase.

Ejemplo:

```java
@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(
        CustomerRepository repository
    ) {
        this.repository = repository;
    }
}
```

---

**Beneficios:**

- Bajo acoplamiento.
- Fácil testing.
- Mejor mantenimiento.

---

### Bean Lifecycle

**Concepto:** Ciclo de vida de un Bean administrado por Spring.

Flujo simplificado:

```text
Creación
    ↓
Inyección de dependencias
    ↓
Inicialización
    ↓
Uso
    ↓
Destrucción
```

---

**Idea para entrevista:**

Spring crea y administra los Beans dentro del Application Context.

---

### @Component vs @Service

## @Component

Anotación genérica para registrar un Bean.

```java
@Component
public class Utility {
}
```

---

## @Service

Especialización de @Component.

```java
@Service
public class CustomerService {
}
```

Se utiliza para clases de lógica de negocio.

---

**¿Cuál usar?**

```text
@Component → propósito general
@Service → lógica de negocio
@Repository → acceso a datos
@Controller → capa web
```

---

# Preguntas Frecuentes de Entrevista

### ¿Cómo funciona HashMap?

Utiliza hashCode() para determinar en qué bucket almacenar un elemento.

---

### ¿Por qué sobrescribir equals() y hashCode() juntos?

Porque colecciones como HashMap y HashSet dependen de ambos métodos.

---

### ¿Por qué String es immutable?

Por seguridad, rendimiento y thread safety.

---

### ¿Cuándo usar Streams?

Cuando se necesiten transformaciones, filtros o agregaciones sobre colecciones.

---

### ¿Para qué sirve Optional?

Representar ausencia de valor y reducir NullPointerException.

---

### ¿Qué es Dependency Injection?

Spring proporciona automáticamente las dependencias necesarias.

---

### ¿Qué es un Bean?

Objeto administrado por Spring.

---

### Diferencia entre @Component y @Service

@Service indica lógica de negocio; @Component es una anotación genérica.

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| HashMap | Almacena pares clave-valor usando hashing |
| equals() | Compara igualdad lógica |
| hashCode() | Determina bucket en colecciones hash |
| String Immutable | No puede modificarse |
| Stream | Procesamiento declarativo de colecciones |
| Loop | Iteración imperativa |
| Optional | Evita null explícitamente |
| DI | Spring inyecta dependencias |
| Bean | Objeto administrado por Spring |
| Bean Lifecycle | Crear → Inyectar → Usar → Destruir |
| @Component | Bean genérico |
| @Service | Bean de lógica de negocio |