# 🏨 Hotel Booking System

![GitHub last commit](https://img.shields.io/github/last-commit/sourabh500/Hotel-booking-system?style=for-the-badge)
![GitHub repo size](https://img.shields.io/github/repo-size/sourabh500/Hotel-booking-system?style=for-the-badge)
![GitHub issues](https://img.shields.io/github/issues/sourabh500/Hotel-booking-system?style=for-the-badge)
![GitHub stars](https://img.shields.io/github/stars/sourabh500/Hotel-booking-system?style=for-the-badge)

A **microservices-based Hotel Booking System** built using **Java, Spring Boot, MySQL, JWT, and iText PDF**.  
This project allows customers to book hotel rooms, generate booking confirmations as PDF, and manage room inventory. Features include **email and SMS notifications**, **JWT-based security**, and **microservices architecture** with an **API Gateway**.

---

## 📌 Table of Contents
- [Tech Stack](#-tech-stack)
- [Features](#-features)
- [Architecture](#-architecture)
- [Getting Started](#-getting-started)
- [API Endpoints](#-api-endpoints)
- [Sample JSON](#-sample-json)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)

---

## 🛠 Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Java 21, Spring Boot 3 |
| Security | Spring Security, JWT |
| Database | MySQL |
| Microservices | Eureka Service Registry, Spring Cloud API Gateway |
| PDF Generation | iText PDF 7 |
| Notifications | JavaMail (Email), Twilio (SMS) |
| Build & Dependency | Maven |
| Version Control | Git, GitHub |

---

## ✨ Features

- ✅ Customer booking management (create, view, update)
- ✅ Room inventory management (availability check)
- ✅ Generate booking PDF confirmations
- ✅ Email booking confirmation
- ✅ SMS notifications for bookings
- ✅ JWT-based security for APIs
- ✅ Global exception handling
- ✅ Microservices architecture with API Gateway

---

## 🏗 Architecture

### Microservices

1. **Booking Service** – Handles all booking operations, generates PDFs, sends notifications.  
2. **Room Service** – Manages room inventory and availability.  
3. **Hotel Service** – Manages hotel information.  
4. **Service Registry (Eureka)** – Service discovery for microservices.  
5. **API Gateway** – Centralized entry point for routing requests to microservices.

---

## 🚀 Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL
- Git

### Clone the Repository
```bash
git clone https://github.com/sourabh500/Hotel-booking-system.git
cd Hotel-booking-system

## 🔮 Future Enhancements

- Add payment gateway integration
- Dynamic room pricing based on season
- Customer reviews & ratings
- Mobile application integration
- Analytics dashboard for bookings and revenue

## 👨‍💻 Author

Sourabh Shukla – Backend Developer
