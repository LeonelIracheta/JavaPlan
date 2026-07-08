# Day 4 - Spring Boot Fundamentals

## ¿Qué es Spring Boot?

**Concepto:** Framework que simplifica el desarrollo de aplicaciones Java, especialmente APIs REST y aplicaciones empresariales.

**Beneficios:**

- Menos configuración.
- Desarrollo rápido.
- Servidor embebido (Tomcat).
- Integración con Spring Framework.

---

# Spring Core Concepts

## IoC (Inversion of Control)

**Concepto:** Spring controla la creación y administración de objetos.

Antes:

```java
CustomerService service =
    new CustomerService();
```

Con Spring:

```java
@Autowired
private CustomerService service;
```

**Idea:** No creas objetos manualmente; Spring los administra.

---

## Dependency Injection (DI)

**Concepto:** Spring inyecta las dependencias que una clase necesita.

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

**Beneficio:** Menor acoplamiento y mayor facilidad para pruebas.

---

## Bean

**Concepto:** Objeto administrado por Spring.

Ejemplos:

```java
@Service
@Repository
@Controller
@Component
```

Spring crea una instancia y la mantiene disponible para la aplicación.

---

## Application Context

**Concepto:** Contenedor principal de Spring.

Responsabilidades:

- Crear Beans.
- Gestionar dependencias.
- Administrar el ciclo de vida de objetos.

**Idea:** Es el "cerebro" de Spring.

---

# Arquitectura por Capas

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

## Controller

**Responsabilidad:** Recibir peticiones HTTP.

Ejemplo:

```java
@RestController
@RequestMapping("/customers")
public class CustomerController {
}
```

**No debe contener lógica de negocio compleja.**

---

## Service

**Responsabilidad:** Lógica de negocio.

Ejemplo:

```java
@Service
public class CustomerService {
}
```

Aquí viven las validaciones, reglas y procesos.

---

## Repository

**Responsabilidad:** Acceso a datos.

Ejemplo:

```java
@Repository
public interface CustomerRepository {
}
```

Se comunica con la base de datos.

---

## Database

**Responsabilidad:** Persistir información.

Ejemplos:

- MySQL
- PostgreSQL
- SQL Server
- Oracle

---

# Dependencias Comunes

## Spring Web

Permite crear APIs REST.

Incluye:

- Controllers
- JSON
- Servidor web embebido

---

## Validation

Permite validar datos de entrada.

Ejemplo:

```java
@NotBlank
private String name;
```

Evita datos inválidos antes de procesarlos.

---

## Lombok

Reduce código repetitivo.

Ejemplo:

```java
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
```

Genera automáticamente getters, setters y constructores.

---

# Anotaciones Importantes

### @SpringBootApplication

Punto de entrada de la aplicación.

```java
@SpringBootApplication
public class Application {
}
```

---

### @RestController

Expone endpoints REST.

---

### @Service

Define la capa de negocio.

---

### @Repository

Define la capa de acceso a datos.

---

### @Autowired

Inyecta dependencias automáticamente.

---

# Resumen Rápido

| Concepto | Idea Principal |
|-----------|---------------|
| Spring Boot | Framework para aplicaciones Java |
| IoC | Spring controla los objetos |
| DI | Spring inyecta dependencias |
| Bean | Objeto administrado por Spring |
| Application Context | Contenedor principal de Spring |
| Controller | Maneja peticiones HTTP |
| Service | Contiene lógica de negocio |
| Repository | Acceso a datos |
| Spring Web | Crear APIs REST |
| Validation | Validar datos |
| Lombok | Reducir código repetitivo |