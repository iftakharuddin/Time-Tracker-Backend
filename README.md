# Time Tracker Backend

This is the **backend for a Time Tracking Application** built with **Java Spring Boot**.  
It allows users to **record daily working hours**, allocate them to projects, and fetch **daily, weekly, and monthly summaries**.

The backend is built as a **RESTful API** using **Spring Boot**, **H2 database**, and **JPA/Hibernate** for persistence.

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup & Run](#setup--run)
- [Database](#database)
- [REST API Endpoints](#rest-api-endpoints)
- [Usage](#usage)

---

## Features

- **Daily Time Tracking**
  - Record working hours per project per day
  - Minimum fields: Date, Project, Duration (hours)

- **Weekly Overview**
  - Summary of total hours per day for a given week

- **Monthly Overview**
  - Summary of total hours per month

- **Project Management**
  - Create and list projects

---

## Tech Stack

- **Language:** Java 17
- **Framework:** Spring Boot
- **Database:** H2 (in-file and persisted)
- **JPA:** Hibernate
- **Build Tool:** Maven
- **API Style:** RESTful

---

## Setup & Run

1. **Clone the repository**

```bash
git clone <your-repo-url>
cd time-tracker-backend
````

2. **Build the project**

```bash
mvn clean install
```

3. **Run the application**

```bash
mvn spring-boot:run
```

4. **Access the backend**

```
Base URL: http://localhost:8080/api
```

---

## Database

* **H2 Console:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* **JDBC URL:** `jdbc:h2:file:./data/time-tracker-db`
* **Username:** `sa`
* **Password:** *(leave blank)*

**Tables:**

* `projects` → stores project information
* `time_entries` → stores daily time entries (date, project, hours)
* `users` → optional if you extend to multi-user support

---

## REST API Endpoints

### Projects

| Method | Endpoint    | Description        | Request Body                 |
| ------ | ----------- | ------------------ | ---------------------------- |
| GET    | `/projects` | Get all projects   | -                            |
| POST   | `/projects` | Create new project | `{ "name": "Project Name" }` |

### Time Entries

| Method | Endpoint                | Description             | Request Body                                           |
| ------ | ----------------------- | ----------------------- | ------------------------------------------------------ |
| POST   | `/time-entries`         | Create a new time entry | `{ "date": "YYYY-MM-DD", "hours": 8, "projectId": 1 }` |
| GET    | `/time-entries/daily`   | Get daily time entries  | Query param: `?date=YYYY-MM-DD`                        |
| GET    | `/time-entries/weekly`  | Get weekly summary      | Query param: `?weekStart=YYYY-MM-DD`                   |
| GET    | `/time-entries/monthly` | Get monthly summary     | Query params: `?year=YYYY&month=MM`                    |

---

## Usage Examples

### Create a Project

```http
POST /api/projects
Content-Type: application/json

{
  "name": "Backend Development"
}
```

### Add Daily Time Entry

```http
POST /api/time-entries
Content-Type: application/json

{
  "date": "2026-01-18",
  "hours": 7.5,
  "projectId": 1
}
```

### Get Daily Entries

```http
GET /api/time-entries/daily?date=2026-01-18
```

### Get Weekly Summary

```http
GET /api/time-entries/weekly?weekStart=2026-01-15
```

### Get Monthly Summary

```http
GET /api/time-entries/monthly?year=2026&month=1



