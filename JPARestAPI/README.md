# 🔐 JPA REST API with Spring Security (JWT)

This is a Spring Boot project that provides secure RESTful endpoints to perform CRUD operations on `Employee` entities
using Spring Data JPA, MySQL, and Spring Security with JWT-based authentication.

---

## 🚀 REST Endpoints

### 🔓 Authentication

| Method | Endpoint      | Description             |
|--------|---------------|-------------------------|
| POST   | `/auth/login` | Login and get JWT token |

**Request Body:**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

> 🔐 All `/api/**` endpoints require a valid JWT token in the `Authorization` header:

```
Authorization: Bearer <your-token>
```

---

### 📁 Employee Management (Protected Endpoints)

| Method | Endpoint                    | Description                 |
|--------|-----------------------------|-----------------------------|
| GET    | `/api/employees`            | Get all employees           |
| GET    | `/api/employees/{id}`       | Get employee by ID          |
| POST   | `/api/employee/add`         | Create a new employee       |
| PUT    | `/api/employee/update/{id}` | Update an existing employee |
| DELETE | `/api/employee/delete/{id}` | Delete employee by ID       |

> 📝 Example: `http://localhost:8080/api/employees`

---

## 📦 Dependencies (pom.xml)

- **Spring Web**
- **Spring Data JPA**
- **Spring Security**
- **jjwt (Java JWT)**
- **MySQL Driver**
- **Spring Boot DevTools**

---

## 🛠️ Technologies Used

- Java 21
- Spring Boot
- Spring Security
- JPA (Hibernate)
- MySQL
- Maven

---

## 🔒 Security Overview

- Uses Spring Security with JWT tokens
- Stateless authentication (no sessions)
- Custom user table (`auth_user`) with username & password
- Token validation on each request via filter

---

## 🧪 How to Test with Postman

1. **Login** using `POST /auth/login`
2. Copy the `token` from the response
3. Add this to the `Authorization` header of subsequent requests:
   ```
   Authorization: Bearer <token>
   ```
4. Call any secured endpoint under `/api/**`