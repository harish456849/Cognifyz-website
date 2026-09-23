# Cognifyz Internship – Full Stack Development

## Backend Application

This repository contains the **backend implementation** developed as part of the Cognifyz IT Solutions Full Stack Development Internship.

The backend provides REST APIs, validation, authentication, database interaction, and business logic required by the frontend application.

## Internship

**Organization:** Cognifyz IT Solutions Pvt. Ltd.
**Role:** Full-stack Development Intern
**Internship Duration:** 07/09/2026 – 07/10/2026
**Mode:** Remote

The Cognifyz Full Stack Development internship requires completion of at least **5 out of 8 tasks** covering Beginner, Intermediate, Advanced, and Expert levels.

## Backend Technology Stack

* **Java 21**
* **Spring Boot**
* **Spring MVC / REST**
* **Spring Data JPA**
* **Spring Security**
* **MySQL**
* **JWT**
* **Maven**
* **Bean Validation**
* **Lombok**

The current Maven configuration uses Java 21 and includes Spring Web MVC, Spring Security, Spring Data JPA, MySQL Connector, Spring Validation, and JWT dependencies.

## Tasks Covered

The backend implementation follows the requirements provided in the Cognifyz Full Stack Development task list.

### Level 1 – Beginner

#### Task 1: HTML Structure and Basic Server Interaction

Backend responsibilities include:

* Providing server-side API endpoints.
* Receiving requests from the frontend.
* Processing submitted data.
* Returning appropriate responses.

#### Task 2: Basic Interaction and Server-Side Validation

Backend responsibilities include:

* Receiving form data.
* Validating submitted information.
* Rejecting invalid input.
* Processing valid input.

The Cognifyz task specifically requires server-side validation and temporary server-side storage for this level.

### Level 2 – Intermediate

#### Task 3: Advanced Styling and Responsive Design

This task is primarily frontend-focused. The backend provides the APIs required by the frontend application.

#### Task 4: Complex Form Validation and Dynamic DOM Manipulation

This task is primarily frontend-focused, while the backend supports the application through REST endpoints and data processing.

### Level 3 – Advanced

#### Task 5: API Integration and Front-End Interaction

The backend provides RESTful API endpoints for frontend communication.

General flow:

```text
React Frontend
      ↓
HTTP Request
      ↓
Spring Boot REST Controller
      ↓
Service Layer
      ↓
Repository Layer
      ↓
MySQL Database
      ↓
Response
      ↓
React Frontend
```

The Cognifyz task requires RESTful API endpoints supporting CRUD operations and frontend interaction with those APIs.

#### Task 6: Database Integration and User Authentication

The backend integrates:

* MySQL database
* Spring Data JPA
* Spring Security
* JWT-based authentication
* API authorization
* Request validation

The Cognifyz task requires database integration, user authentication, and authorization checks for protected API endpoints.

### Level 4 – Expert

#### Task 7: Advanced API Usage and External API Integration

The backend architecture can support advanced API functionality including:

* Authentication
* Error handling
* External API communication
* Rate limiting where required

The Cognifyz task specifically mentions OAuth, external APIs, rate limiting, and error handling.

#### Task 8: Advanced Server-Side Functionality

The task focuses on advanced backend functionality such as:

* Middleware/request processing
* Logging
* Background processing
* Job queues
* Server-side caching

These features can be incorporated according to the final implementation requirements.

## Project Structure

```text
backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── cognifyz/
│   │   │           └── backend/
│   │   │               ├── controller/
│   │   │               ├── dto/
│   │   │               ├── entity/
│   │   │               ├── repository/
│   │   │               ├── security/
│   │   │               └── service/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
```

The current backend repository contains separate controller, DTO, entity, repository, security, and service packages.

## Database

The backend uses **MySQL** with Spring Data JPA.

Database configuration should be provided through the application's configuration/environment rather than committing passwords or other sensitive credentials to GitHub.

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

> Do not commit real database passwords, JWT secrets, API keys, or other credentials to the repository.

## Authentication

Authentication is implemented using Spring Security and JWT.

General authentication flow:

```text
User
 ↓
Login Request
 ↓
Authentication Controller
 ↓
Authentication Service
 ↓
Spring Security
 ↓
JWT Generation
 ↓
JWT returned to Client
```

For protected requests:

```text
Client
 ↓
JWT Token
 ↓
Spring Security Filter
 ↓
Authorization
 ↓
Controller
 ↓
Service
 ↓
Database
```

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/harish456849/Cognifyz_Internship.git
```

### 2. Switch to the backend branch

```bash
git checkout backend
```

### 3. Configure MySQL

Create the required MySQL database and configure the database properties in the application's configuration.

### 4. Build the project

Windows:

```bash
mvnw.cmd clean install
```

Linux/macOS:

```bash
./mvnw clean install
```

### 5. Run the application

Windows:

```bash
mvnw.cmd spring-boot:run
```

Linux/macOS:

```bash
./mvnw spring-boot:run
```

The backend server will run on the configured Spring Boot port.

## API Testing

REST APIs can be tested using tools such as:

* Postman
* Browser
* React frontend
* cURL

Example:

```text
Frontend
   ↓
POST /api/...
   ↓
Spring Boot Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```

## Frontend Integration

The backend is designed to communicate with the React frontend maintained in the `frontend` branch.

Repository branches:

* `frontend` – React frontend
* `backend` – Spring Boot backend

Full-stack communication:

```text
             Cognifyz Full Stack Application

 ┌─────────────────────┐
 │   React Frontend    │
 │   Port: 3000        │
 └──────────┬──────────┘
            │
            │ REST API
            ↓
 ┌─────────────────────┐
 │  Spring Boot Backend│
 │     Java 21         │
 └──────────┬──────────┘
            │
       ┌────┴─────┐
       ↓          ↓
  Security     Service
       │          │
       └────┬─────┘
            ↓
      Spring Data JPA
            ↓
       MySQL Database
```

## Security Considerations

The project follows basic security practices including:

* Password protection through the authentication system.
* JWT-based authentication.
* Protected API endpoints.
* Server-side input validation.
* Avoiding hard-coded database credentials.
* Avoiding sensitive information in source control.

## Internship Objective

The backend implementation demonstrates full-stack development concepts including:

* REST API development
* CRUD operations
* Database integration
* Server-side validation
* Authentication
* Authorization
* Secure API communication
* Frontend-backend integration

## Author

**Rai Harish**

GitHub:
https://github.com/harish456849/Cognifyz_Internship

## Acknowledgement

Developed as part of the **Cognifyz IT Solutions Full Stack Development Internship Program**.

All work in this repository is developed for the internship assignment and follows the requirement to submit original work.
