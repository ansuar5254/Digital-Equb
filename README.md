Digital Equb Management System

Introduction
The Digital Equb Management System is a web-based platform that modernizes the traditional Ethiopian Equb system by enabling users to manage Equb groups digitally.
The system allows users to create and join Equb groups, manage payments, communicate through group chats, and automate Equb receiver selection.
This project is developed as an Advanced Java Programming Project using Spring Boot and MySQL.

Features
Authentication & Authorization
User Registration
User Login
JWT-based Authentication
Role-Based Authorization
Password Encryption using BCrypt

Equb Group Management
Create Equb Groups
Search Groups by:
Region
Contribution Amount
Payment Frequency
Join Multiple Equb Groups
Group Membership Management

Join Request System
Members Can:
Send Join Requests
Upload National ID Documents
Submit Bank Account Information
Admins Can:
Approve Requests
Reject Requests
Review Uploaded Documents

Payment Management
Payment Tracking
Paid/Unpaid Member Monitoring
Payment History Management
Admin Payment Confirmation

Random Equb Receiver Selection
Randomly Select Equb Receiver
Prevent Duplicate Winners
Store Winner History

Group Chat System
Real-Time Group Communication
Private Group Chat Rooms
WebSocket-Based Messaging

System Roles
Member

Members can:

Join Equb Groups
Send Join Requests
Upload Documents
Participate in Group Chats
View Group Information
Admin

Admins can:

Create Equb Groups
Manage Members
Approve/Reject Requests
Confirm Payments
Manage Group Activities

Technologies Used
  Backend
  Java
  Spring Boot
  Spring Security
  Spring Data JPA
  JWT Authentication
  WebSocket
Database
  MySQL
Build Tool
  Maven
Testing Tools
  Postman
Version Control
  Git
  GitHub

System Architecture
Client (Frontend)
       ↓
REST API + WebSocket
       ↓
Spring Boot Backend
       ↓
MySQL Database

Project Structure
src
 └── main
     ├── java
     │    └── com.equb
     │         ├── controller
     │         ├── service
     │         ├── repository
     │         ├── model
     │         ├── dto
     │         ├── security
     │         ├── websocket
     │         └── config
     │
     └── resources
          ├── application.properties
          └── static
