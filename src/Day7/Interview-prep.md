# Day 7 - Mock Interview (Java + Spring)

## HashMap

### Pregunta
¿Cómo funciona internamente un HashMap?

### Respuesta
HashMap almacena pares clave-valor utilizando `hashCode()` para calcular un bucket donde guardar el elemento. Si varias claves caen en el mismo bucket, ocurre una colisión y HashMap las maneja internamente.

---

### Pregunta
¿Qué complejidad tiene una búsqueda en HashMap?

### Respuesta
En promedio O(1), aunque en el peor caso puede llegar a O(n) debido a colisiones.

---

### Pregunta
¿Qué es una colisión en HashMap?

### Respuesta
Sucede cuando dos claves diferentes generan el mismo hash y terminan en el mismo bucket.

---

## equals() y hashCode()

### Pregunta
¿Cuál es la diferencia entre equals() y hashCode()?

### Respuesta
`equals()` compara si dos objetos son lógicamente iguales. `hashCode()` genera un valor numérico usado por colecciones como HashMap y HashSet.

---

### Pregunta
¿Por qué debemos sobrescribir equals() y hashCode() juntos?

### Respuesta
Porque si dos objetos son iguales según `equals()`, deben generar el mismo `hashCode()` para que las colecciones funcionen correctamente.

---

### Pregunta
¿Qué problema puede ocurrir si sobrescribo equals() pero no hashCode()?

### Respuesta
HashMap o HashSet podrían tratar objetos iguales como diferentes y almacenar duplicados.

---

## String Immutable

### Pregunta
¿Qué significa que String sea immutable?

### Respuesta
Que una vez creado no puede modificarse. Cualquier cambio genera un nuevo objeto String.

---

### Pregunta
¿Por qué String es immutable?

### Respuesta
Por seguridad, thread safety y optimización mediante el String Pool.

---

### Pregunta
¿Qué sucede aquí?

```java
String name = "Leo";
name.concat(" Jr");
```

### Respuesta
El valor de `name` sigue siendo `"Leo"` porque `concat()` devuelve un nuevo String.

---

## Stream vs Loop

### Pregunta
¿Cuál es la diferencia entre Stream y Loop?

### Respuesta
Un loop describe cómo recorrer una colección; un Stream describe qué transformación o filtrado queremos realizar.

---

### Pregunta
¿Cuándo usarías Streams?

### Respuesta
Cuando necesito filtrar, transformar, agrupar o procesar colecciones de forma declarativa.

---

### Pregunta
¿Cuándo preferirías un loop tradicional?

### Respuesta
Cuando la lógica es compleja o necesito depurar paso a paso.

---

### Pregunta
¿Qué hace este código?

```java
customers.stream()
         .filter(Customer::isActive)
         .map(Customer::getName)
         .toList();
```

### Respuesta
Filtra clientes activos, obtiene sus nombres y devuelve una lista de nombres.

---

## Optional

### Pregunta
¿Qué es Optional?

### Respuesta
Es un contenedor que puede contener un valor o estar vacío.

---

### Pregunta
¿Qué problema intenta resolver Optional?

### Respuesta
Reducir el riesgo de NullPointerException.

---

### Pregunta
¿Cuál es la diferencia entre orElse() y orElseThrow()?

### Respuesta
`orElse()` devuelve un valor por defecto. `orElseThrow()` lanza una excepción si no existe valor.

---

### Pregunta
¿Cuándo usarías Optional?

### Respuesta
Principalmente como valor de retorno cuando un resultado podría no existir.

---

## Dependency Injection

### Pregunta
¿Qué es Dependency Injection?

### Respuesta
Es un patrón donde Spring proporciona automáticamente las dependencias que una clase necesita.

---

### Pregunta
¿Cuál es el beneficio principal de Dependency Injection?

### Respuesta
Reduce el acoplamiento entre clases y facilita las pruebas unitarias.

---

### Pregunta
¿Qué es mejor, inyección por constructor o por campo?

### Respuesta
Inyección por constructor porque facilita testing y asegura dependencias obligatorias.

---

## Bean Lifecycle

### Pregunta
¿Qué es un Bean?

### Respuesta
Es un objeto administrado por Spring dentro del Application Context.

---

### Pregunta
¿Qué es el Application Context?

### Respuesta
Es el contenedor de Spring encargado de crear y administrar Beans.

---

### Pregunta
Describe brevemente el ciclo de vida de un Bean.

### Respuesta

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

## @Component vs @Service

### Pregunta
¿Cuál es la diferencia entre @Component y @Service?

### Respuesta
Ambas crean Beans, pero `@Service` se utiliza específicamente para lógica de negocio mientras que `@Component` es una anotación genérica.

---

### Pregunta
¿Cuándo usarías @Service?

### Respuesta
En clases que contienen reglas de negocio o procesos de la aplicación.

---

### Pregunta
¿Cuándo usarías @Component?

### Respuesta
Para componentes auxiliares o utilidades que no pertenecen a una capa específica.

---

## Preguntas Rápidas (Flash Cards)

### ¿Qué método usa HashMap para calcular el bucket?
**Respuesta:** `hashCode()`

### ¿Qué método compara igualdad lógica?
**Respuesta:** `equals()`

### ¿String puede modificarse después de crearse?
**Respuesta:** No.

### ¿Qué devuelve Optional.empty()?
**Respuesta:** Un Optional sin valor.

### ¿Qué anotación define una clase de negocio?
**Respuesta:** `@Service`

### ¿Qué anotación define un Bean genérico?
**Respuesta:** `@Component`

### ¿Qué contenedor administra los Beans?
**Respuesta:** Application Context.

### ¿Qué ventaja tiene Dependency Injection?
**Respuesta:** Menor acoplamiento y mejor testabilidad.

---

# Resumen de Entrevista

Si solo recuerdas una frase por tema:

```text
HashMap → hashCode() determina el bucket.

equals/hashCode → deben ser consistentes.

String → es immutable.

Stream → procesamiento declarativo de colecciones.

Optional → evita trabajar directamente con null.

Dependency Injection → Spring proporciona dependencias.

Bean → objeto administrado por Spring.

@Service → lógica de negocio.
@Component → Bean genérico.
```