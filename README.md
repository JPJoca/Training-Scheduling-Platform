# Training Scheduling Platform

This project implements a distributed microservice-based system for managing personal training bookings. The platform consists of three core services and an API Gateway that handles all external requests. The system supports role-based user management, training session booking, and automatic email notifications.

---

## System Overview

### 1. **User Service**
Handles registration, authentication, and authorization for three user roles:
- **Admin** (manually inserted, full access)
- **Client** (can book sessions)
- **Gym Manager** (manages gym and sessions)

#### Core Features:
- JWT authentication
- Account activation via email
- Profile update functionality
- Login blocking/unblocking by admin
- Communication via **ActiveMQ** for notifications

---

### 2. **Training Scheduling Service**
Enables clients to view, filter, and book training sessions, while gym managers can define gyms and their training programs.

#### Core Features:
- Gym CRUD (by managers)
- Training type management (group vs individual)
- Term filtering (by type, group/individual, weekday)
- Booking and cancellation logic
- Integration with User Service to get and update training count (retry pattern)
- Verloyalty program (e.g., every 10th training is free)

---

### 3. **Notification Service**
Handles all email notifications sent to clients and managers.

#### Core Features:
- Activation email
- Password reset
- Booking confirmation
- Training cancellation
- Reminder (24h before session)
- Admin-controlled notification templates
- Notification log with filtering (by type, user email, and date range)

---

## 🔧 Technologies Used

| Technology               | Used In                    |
|--------------------------|----------------------------|
| **Java 17**              | All services               |
| **Spring Boot**          | All services               |
| **Spring Data JPA**      | User & Notification        |
| **ActiveMQ**             | All services (JMS Broker)  |
| **JWT (jjwt)**           | User & Notification        |
| **Springfox Swagger**    | User & Notification        |
| **Lombok**               | All services               |
| **H2 Database**          | User & Notification        |
| **Retry Pattern**        | Training Service           |
| **Gson**                 | Training Service           |
| **API Gateway (Zuul)**   | Routing                    |
| **Eureka** |   Service Discovery                   |
| **Client App**           | Swing                     |

---

## 🔁 Service Communication

- **Asynchronous**: All notification-related events (activation, reminders, booking) are sent over **ActiveMQ**
- **Synchronous**: Training service communicates with the User Service to fetch or update training count using **HTTP REST**, with **retry mechanism** for fault-tolerance

---

## Role-Based Access

| Role       | Abilities                                                                 |
|------------|---------------------------------------------------------------------------|
| Admin      | Full control, user management, notification template management           |
| Client     | Browse & book sessions, cancel bookings, receive notifications            |
| Manager    | Manage gyms & sessions, set loyalty rules, cancel sessions                |

---

## Notification System

- All notifications are queued and processed asynchronously
- Messages are templated and customizable by the admin
- Notification archive accessible with filtering

---
