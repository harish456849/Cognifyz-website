# Cognifyz Internship – Full Stack Development

## Frontend Application

This repository contains the **frontend implementation** developed as part of the Cognifyz IT Solutions Full Stack Development Internship.

The frontend is responsible for the user interface, client-side validation, navigation, user interaction, and communication with the backend REST APIs.

## Internship

**Organization:** Cognifyz IT Solutions Pvt. Ltd.
**Role:** Full-stack Development Intern
**Internship Duration:** 07/09/2026 – 07/10/2026
**Mode:** Remote

The internship task list requires completion of at least **5 out of 8 tasks** across four levels: Beginner, Intermediate, Advanced, and Expert.

## Tasks Covered

The application is being developed according to the Cognifyz Full Stack Development task list.

### Level 1 – Beginner

#### Task 1: HTML Structure and Basic Server Interaction

* Created the frontend structure and user input forms.
* Designed the UI for interacting with backend functionality.
* Prepared the frontend for server-side/API communication.

#### Task 2: Inline Styles, Basic Interaction, and Server-Side Validation

* Added user interactions and form handling.
* Implemented client-side validation.
* Connected frontend form data with backend validation.

### Level 2 – Intermediate

#### Task 3: Advanced CSS Styling and Responsive Design

* Created structured webpage layouts.
* Used CSS and Bootstrap for styling.
* Implemented responsive UI design for different screen sizes.


#### Task 4: Complex Form Validation and Dynamic DOM Manipulation

* Added complex form validation rules.
* Implemented dynamic UI updates based on user interaction.
* Added client-side navigation using React Router.

### Level 3 – Advanced

#### Task 5: API Integration and Front-End Interaction

* Connected the React frontend with RESTful backend APIs.
* Sent requests to backend endpoints.
* Retrieved and displayed backend data.
* Implemented frontend interaction with CRUD-based APIs.

#### Task 6: Database Integration and User Authentication

* Integrated the frontend with backend authentication functionality.
* Implemented user registration and login interfaces.
* Added authenticated interaction with protected backend APIs.

### Level 4 – Expert

#### Task 7: Advanced API Usage and External API Integration

* Prepared the frontend architecture for advanced API communication.
* Supports handling API responses and errors.
* External API functionality can be added where required.

#### Task 8: Advanced Server-Side Functionality

* Frontend communicates with backend services designed to support advanced server-side processing.
* Provides the user interface required for interacting with backend functionality.

## Technology Stack

* **React**
* **JavaScript**
* **HTML5**
* **CSS3**
* **Bootstrap 5**
* **React Router**
* **REST API**

The current project configuration uses React, React DOM, React Router DOM, Bootstrap, and Create React App tooling.

## Project Structure

```text
frontend/
│
├── public/
│
├── src/
│   ├── components/
│   ├── pages/
│   ├── services/
│   └── ...
│
├── package.json
├── package-lock.json
├── .gitignore
└── README.md
```

> The exact contents of the `src` directory may change as the internship tasks are completed.

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/harish456849/Cognifyz_Internship.git
```

### 2. Switch to the frontend branch

```bash
git checkout frontend
```

### 3. Install dependencies

```bash
npm install
```

### 4. Start the application

```bash
npm start
```

The application runs in development mode at:

```text
http://localhost:3000
```

## Available Commands

### Start development server

```bash
npm start
```

### Create production build

```bash
npm run build
```

### Run tests

```bash
npm test
```

## Backend Connection

The frontend communicates with the Spring Boot backend through REST APIs.

Typical flow:

```text
User
  ↓
React Frontend
  ↓
REST API Request
  ↓
Spring Boot Backend
  ↓
Database
  ↓
REST API Response
  ↓
React Frontend
  ↓
User
```

The backend is maintained separately on the `backend` branch.

## Internship Objective

The objective of this project is to demonstrate full-stack development skills by implementing frontend functionality that works together with a backend REST API.

The Cognifyz task list covers:

* HTML forms
* Server interaction
* Validation
* Responsive design
* Dynamic DOM manipulation
* REST API integration
* Database integration
* Authentication
* Advanced API concepts
* Advanced server-side functionality

## Author

**Rai Harish**

GitHub:
https://github.com/harish456849/Cognifyz_Internship

## Acknowledgement

Developed as part of the **Cognifyz IT Solutions Full Stack Development Internship Program**.

All work in this repository is developed for the internship assignment and follows the requirement to submit original work.
