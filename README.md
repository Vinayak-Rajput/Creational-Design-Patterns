# Creational Design Patterns in Java

This repository contains small Java examples of common **creational design patterns**. Each pattern is organized under `src/com/example/creation` and includes a problem statement plus the interfaces and classes used to model the solution.

## Patterns included

| Pattern | Example | Main idea |
| --- | --- | --- |
| Abstract Factory | Cross-platform UI toolkit | Create families of related UI objects without coupling client code to concrete classes. |
| Builder | SQL query generator | Build a complex object step by step with a fluent API. |
| Factory Method | Universal notification system | Delegate creation of a notification to a specialized factory. |
| Prototype | Video game enemy spawner | Create new objects by cloning an existing prototype. |
| Singleton | Global application logger | Ensure that a class has one shared, thread-safe instance. |

## Project structure

```text
.
├── README.md
├── Creational Design Pattern.iml
└── src
    └── com/example/creation
        ├── AbstractFactory
        │   ├── ConcreteFactories
        │   │   ├── MacUIFactory.java
        │   │   └── WinUIFactory.java
        │   ├── ConcreteFamilies
        │   │   ├── MacButton.java
        │   │   ├── MacCheckBox.java
        │   │   ├── WinButton.java
        │   │   └── WinCheckBox.java
        │   ├── FactoryInterface
        │   │   └── UIFactory.java
        │   ├── ProductInterfaces
        │   │   ├── Button.java
        │   │   └── CheckBox.java
        │   └── Problem Statement
        ├── Builder
        │   ├── QueryBuilder.java
        │   └── Problem Statement
        ├── FactoryMethod
        │   ├── ConcreteCreator
        │   │   ├── EmailNotification.java
        │   │   ├── PushNotification.java
        │   │   └── SMSNotification.java
        │   ├── ConcreteFactories
        │   │   ├── EmailFactory.java
        │   │   ├── PushNotificationFactory.java
        │   │   └── SMSNotificationFactory.java
        │   ├── CreatorFactory
        │   │   └── NotificationFactory.java
        │   ├── ProductInterface
        │   │   └── Notification.java
        │   └── Problem Statement
        ├── Prototype
        │   ├── Enemy.java
        │   ├── Goblin.java
        │   └── Problem Statement
        └── Singleton
            ├── Logger.java
            └── Problem Statement
```

## 1. Abstract Factory

**Problem:** A UI toolkit must create Windows-style or macOS-style components without mixing product families.

### Roles

- `UIFactory` defines `createButton()` and `createCheckBox()`.
- `WinUIFactory` creates `WinButton` and `WinCheckBox`.
- `MacUIFactory` creates `MacButton` and `MacCheckBox`.
- `Button` and `CheckBox` are the abstract product interfaces.
- The concrete family classes represent platform-specific products.

Example:

```java
UIFactory factory = new WinUIFactory();
Button button = factory.createButton();
CheckBox checkBox = factory.createCheckBox();
```

The client depends on `UIFactory`, `Button`, and `CheckBox`, so changing the platform does not require changing the client workflow.

## 2. Builder

**Problem:** SQL queries can contain several optional clauses, making a large constructor difficult to read and maintain.

`QueryBuilder` stores a query and exposes fluent methods for:

- `select(String column)`
- `from(String table)`
- `where(String condition)`
- `orderBy(String column)`
- `builder()`, which returns the generated query string

Example from code in the `com.example.creation.Builder` package:

```java
QueryBuilder query = new QueryBuilder()
        .select("id, name")
        .from("users")
        .where("active = true")
        .orderBy("name");

String sql = query.builder();
```

The current implementation uses package-private constructors and methods, so this example must be called from the same package. It also appends clauses as supplied and does not currently validate SQL fragments.

## 3. Factory Method

**Problem:** A notification system needs to create email, SMS, or push notifications without exposing concrete notification classes to client code.

### Roles

- `Notification` declares `send()`.
- `EmailNotification`, `SMSNotification`, and `PushNotification` implement the product interface.
- `NotificationFactory` declares `createNotification()`.
- `EmailFactory`, `SMSNotificationFactory`, and `PushNotificationFactory` create one notification type each.

Example:

```java
NotificationFactory factory = new EmailFactory();
Notification notification = factory.createNotification();
notification.send(); // Notification send via Email.
```

The factory method keeps object creation in specialized factory classes while the client works with the `Notification` abstraction.

## 4. Prototype

**Problem:** Creating many expensive game enemies from scratch can be slow. A configured enemy can be copied instead.

- `Enemy` declares `clone()`.
- `Goblin` stores `health`, `speed`, and `weapon`.
- `Goblin(Goblin target)` is a copy constructor.
- `Goblin.clone()` returns a new `Goblin` created through the copy constructor.

Example:

```java
Goblin masterGoblin = new Goblin(100, 10, "Axe");
Enemy clonedGoblin = masterGoblin.clone();
```

The clone is a separate `Goblin` object. The current fields are primitive values and an immutable `String`, so copying them creates an independent state for this model.

## 5. Singleton

**Problem:** An application logger should expose one shared instance, including when accessed concurrently by multiple threads.

`Logger` implements a lazy, thread-safe Singleton using:

- A private constructor.
- A `private static volatile` instance field.
- A public `getInstance()` method.
- Double-checked locking synchronized on `Logger.class`.

Example:

```java
Logger first = Logger.getInstance();
Logger second = Logger.getInstance();

System.out.println(first == second); // true
```

## Requirements

- Java Development Kit (JDK) 17 or newer is recommended.
- IntelliJ IDEA can open the project directly using the included `.iml` file.
- No Maven or Gradle build file is currently included.

## Compile the sources

From the repository root, compile all Java sources into a temporary output directory:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
```

The repository currently contains library-style classes rather than a `main` class, so compilation verifies the source code but does not launch an application.

## Run an example

To run an example, create a small `main` class in the relevant package, compile it with the project sources, and run it. For example, a Factory Method client can use:

```java
package com.example.creation.FactoryMethod;

import com.example.creation.FactoryMethod.ConcreteFactories.EmailFactory;
import com.example.creation.FactoryMethod.CreatorFactory.NotificationFactory;
import com.example.creation.FactoryMethod.ProductInterface.Notification;

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailFactory();
        Notification notification = factory.createNotification();
        notification.send();
    }
}
```

Compile and run the demo from the repository root:

```bash
javac -d out $(find src -name "*.java") /path/to/NotificationDemo.java
java -cp out com.example.creation.FactoryMethod.NotificationDemo
```

## Learning goals

These examples demonstrate how creational patterns can:

- Hide concrete implementation details from client code.
- Keep related objects consistent as a family.
- Replace telescoping constructors with readable construction steps.
- Reuse an existing object as a prototype.
- Centralize access to a shared service instance.

