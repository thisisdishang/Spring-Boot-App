# JPA Rest API

This is a Spring Boot project that provides RESTful endpoints to perform CRUD operations on `Employee` entities using
Spring Data JPA and MySQL.

## 🚀 REST Endpoints

| Method | Endpoint                    | Description                 |
|--------|-----------------------------|-----------------------------|
| GET    | `/api/employees`            | Get all employees           |
| GET    | `/api/employees/{id}`       | Get employee by ID          |
| POST   | `/api/employee/add`         | Create a new employee       |
| PUT    | `/api/employee/update/{id}` | Update an existing employee |
| DELETE | `/api/employee/delete/{id}` | Delete employee by ID       |

> 📝 Example: `http://localhost:8080/api/employees`

## 📦 Dependencies (pom.xml)

- **Spring Web**
- **Spring Data JPA**
- **MySQL Driver**
- **Spring Boot DevTools**

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- JPA (Hibernate)
- MySQL
- Maven
