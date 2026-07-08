# Day 2 - Object-Oriented Design

## Encapsulation

Ocultar los detalles internos de una clase y controlar el acceso a los datos.

```java
private String name;

public String getName() {
    return name;
}
```

---

## Inheritance

Permite que una clase herede atributos y comportamientos de otra.

```java
class Animal {}
class Dog extends Animal {}
```

---

## Polymorphism

Un mismo tipo puede tener diferentes comportamientos según la implementación.

```java
Animal animal = new Dog();
animal.makeSound();
```

---

## Abstraction

Mostrar solo lo necesario y ocultar la complejidad.

```java
abstract class Payment {
    abstract void pay();
}
```

---

# SOLID

## Single Responsibility Principle (SRP)

Una clase debe tener una única responsabilidad.

❌ Mal:

```java
OrderService {
    saveOrder();
    sendEmail();
    generateInvoice();
}
```

✅ Mejor:

```java
OrderService
EmailService
InvoiceService
```

---

## Open/Closed Principle (OCP)

Abierto para extensión, cerrado para modificación.

Agregar nuevas funcionalidades sin modificar código existente.

---

## Liskov Substitution Principle (LSP)

Las clases hijas deben poder reemplazar a la clase padre sin romper el comportamiento.

---

## Interface Segregation Principle (ISP)

Es mejor tener interfaces pequeñas y específicas.

```java
Printer
Scanner
```

En lugar de:

```java
Machine
```

---

## Dependency Inversion Principle (DIP)

Depender de abstracciones, no de implementaciones concretas.

```java
PaymentService
    -> PaymentProcessor
```

---

# Design Patterns

## Factory

Crea objetos sin exponer la lógica de creación.

```java
PaymentProcessor processor =
    paymentFactory.create(PaymentType.CARD);
```

Uso: cuando existen múltiples implementaciones.

---

## Strategy

Permite intercambiar algoritmos o comportamientos.

```java
CreditCardPayment
PayPalPayment
BankTransferPayment
```

Todas implementan:

```java
PaymentStrategy
```

---

## Builder

Construye objetos complejos paso a paso.

```java
User user = User.builder()
    .name("Leo")
    .age(30)
    .build();
```

---
