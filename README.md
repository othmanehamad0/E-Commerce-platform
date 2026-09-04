# E-Commerce Backend

A **Java/Spring Boot microservices-based backend** for an e-commerce application. The project is designed with a modular architecture where different business functionalities are developed as independent services.

The current implementation focuses on **authentication, user management, role-based access, password encryption, database persistence, and service-oriented backend architecture**.

## Features

* User registration and management
* Role-based user management
* Authentication service
* Password encryption using BCrypt
* REST API structure
* JPA/Hibernate database persistence
* MySQL integration
* Layered backend architecture
* Microservices-based architecture
* Modular and scalable service design

## Technologies

* **Java**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **REST API**
* **BCrypt**

## Microservices Architecture

The project follows a **microservices architecture**, where each major business functionality is designed to operate as an independent service.

Planned system structure:

```text
                    Client
                      │
                      ▼
                API / Services
                      │
       ┌──────────────┼──────────────┐
       ▼              ▼              ▼
   Auth Service   Order Service   Payment Service
       │              │              │
       ▼              ▼              ▼
     MySQL          MySQL          MySQL

       ┌──────────────┴──────────────┐
       ▼                             ▼
Notification Service          Product / Inventory
       │
       ▼
   Email Service
```

The architecture is designed to allow each service to be developed, maintained, and expanded independently.

## Current Project Structure

```text
authservice/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── ecommerce/
│       │           └── auth/
│       │               ├── Config/
│       │               ├── Controller/
│       │               ├── Entity/
│       │               ├── Enums/
│       │               └── Repository/
│       │
│       └── resources/
│           └── application.properties
│
└── pom.xml
```

## Security

The project uses **Spring Security** and **BCryptPasswordEncoder** to securely hash user passwords before storing them in the database.

Passwords and sensitive credentials should never be stored directly in source code or committed to GitHub.

## Database

The application uses **MySQL** with **Spring Data JPA/Hibernate**.

Configure the local database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/authServiceDatabase
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Replace the placeholder values with your local configuration.

## How to Run

### 1. Clone the repository

```bash
git clone YOUR_REPOSITORY_URL
cd ecommerce-backend
```

### 2. Configure MySQL

Create the required database and configure the database credentials in `application.properties`.

### 3. Start the application

```bash
mvn spring-boot:run
```

Or using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Main Concepts Practiced

This project was developed to practice:

* Java OOP
* Spring Boot
* Spring Security
* Microservices architecture
* Password hashing
* REST API development
* Dependency Injection
* JPA/Hibernate
* Entity relationships
* Repository pattern
* Service layer architecture
* MySQL integration
* Backend system design
* Modular application architecture

## Planned Services

The project will be expanded with additional microservices to cover the main components of an e-commerce system.

### Order System

An **Order Service** will manage:

* Order creation
* Order status
* Order history
* Order items
* Customer orders

### Payment System

A dedicated **Payment Service** will handle:

* Payment processing
* Payment status
* Transaction management
* Integration with external payment APIs

### Notification System

A **Notification Service** will be responsible for sending notifications to users, including:

* Order confirmation emails
* Payment confirmation emails
* Order status update emails
* Other important account and order notifications

The notification system will use **email-based communication** to keep users informed about their orders and transactions.

## Project Goal

The goal of this project is to build a **scalable e-commerce backend using Java, Spring Boot, and microservices architecture**, while gaining practical experience in backend development, distributed systems, security, databases, REST APIs, and service-to-service communication.

## Author

**Othmane Hamad**

Software Engineering Graduate

## License

This project is for educational and portfolio purposes.
