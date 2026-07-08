# Day 1 - Modern Java Fundamentals

## Java 8

### Lambda Expressions
**Concepto:** Forma corta de implementar una Functional Interface.

**Sintaxis:**
```java
(parameter) -> expression
```

**Ejemplo:**
```java
x -> x * 2
```

**Beneficio:** Menos código y mejor legibilidad.

---

### Functional Interface
**Concepto:** Interfaz con exactamente un método abstracto.

**Anotación:**
```java
@FunctionalInterface
```

**Ejemplo:**
```java
public interface Calculator {
    int calculate(int a, int b);
}
```

**Uso principal:** Lambdas y Method References.

---

### Predicate<T>
**Concepto:** Recibe un valor y devuelve boolean.

**Método:**
```java
boolean test(T t)
```

**Ejemplo:**
```java
age -> age >= 18
```

**Uso:** filter(), validaciones.

---

### Function<T,R>
**Concepto:** Transforma un objeto en otro.

**Método:**
```java
R apply(T t)
```

**Ejemplo:**
```java
name -> name.length()
```

**Uso:** map().

---

### Consumer<T>
**Concepto:** Consume un valor y ejecuta una acción.

**Método:**
```java
void accept(T t)
```

**Ejemplo:**
```java
System.out::println
```

**Uso:** forEach().

---

### Supplier<T>
**Concepto:** Genera un valor sin recibir parámetros.

**Método:**
```java
T get()
```

**Ejemplo:**
```java
() -> Math.random()
```

**Uso:** Creación de objetos, valores por defecto.

---

### Streams API
**Concepto:** Procesamiento declarativo de colecciones.

**Flujo:**
```text
Source -> Operations -> Result
```

**Ejemplo:**
```java
customers.stream()
         .filter(Customer::isActive)
         .map(Customer::getName)
         .toList();
```

Operaciones comunes:

| Operación | Propósito |
|------------|-----------|
| filter() | Filtrar |
| map() | Transformar |
| sorted() | Ordenar |
| distinct() | Eliminar duplicados |
| collect() | Obtener resultado |
| count() | Contar |

---

### Collectors

**toList()**
```java
.collect(Collectors.toList())
```

Convierte Stream a List.

**groupingBy()**
```java
Collectors.groupingBy(Customer::getCountry)
```

Agrupa elementos.

**counting()**
```java
Collectors.counting()
```

Cuenta elementos.

**averagingDouble()**
```java
Collectors.averagingDouble(...)
```

Calcula promedio.

---

### Optional
**Concepto:** Contenedor que puede tener o no un valor.

**Problema que resuelve:**
```text
NullPointerException
```

**Ejemplos:**
```java
Optional.of(value)
Optional.ofNullable(value)
Optional.empty()
```

**Métodos importantes:**
```java
orElse()
orElseThrow()
ifPresent()
```

---

### Date/Time API

Paquete:
```java
java.time
```

**LocalDate**
```java
LocalDate.now()
```

Fecha sin hora.

**LocalTime**
```java
LocalTime.now()
```

Hora sin fecha.

**LocalDateTime**
```java
LocalDateTime.now()
```

Fecha y hora.

**Ventajas:**
- Inmutable
- Thread-safe
- Reemplaza Date y Calendar

---

## Java 11

### String Improvements

**isBlank()**
```java
"   ".isBlank()
```

Verifica si contiene solo espacios.

**repeat()**
```java
"-".repeat(5)
```

Repite texto.

**lines()**
```java
text.lines()
```

Divide en líneas.

**strip()**
```java
text.strip()
```

Elimina espacios Unicode.

---

### HTTP Client API

Paquete:
```java
java.net.http
```

**Concepto:** Cliente HTTP moderno integrado en Java.

**Clases principales:**
```java
HttpClient
HttpRequest
HttpResponse
```

**Beneficios:**
- HTTP/2
- Soporte asíncrono
- API más sencilla

---

### JVM Improvements

**Objetivo:** Mejor rendimiento y menor consumo de recursos.

Mejoras destacadas:
- Garbage Collectors modernos
- Mejor soporte para Docker
- Menor uso de memoria
- Arranque más rápido

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| Lambda | Función anónima |
| Functional Interface | 1 método abstracto |
| Predicate | T -> boolean |
| Function | T -> R |
| Consumer | T -> void |
| Supplier | () -> T |
| Stream | Procesar colecciones |
| Optional | Evitar null |
| LocalDate | Fecha |
| LocalDateTime | Fecha y hora |
| groupingBy | Agrupar |
| HTTP Client | Consumir APIs |