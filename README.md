
# 🌆 Smart City Microservices Project

## 📌 Overview
This project is a **Smart City platform** developed using a **microservices architecture** with **Spring Boot (Java)**.

Each service is **independent**, **loosely coupled**, and communicates through different protocols depending on its use case.

The system includes:
- an **API Gateway** for routing client requests
- an **Orchestrator Service** to manage business workflows between microservices

---

## 🧱 Microservices Architecture
The platform is composed of multiple microservices, each responsible for a specific domain.

### 🚗 Mobility Microservice
- **Technology**: REST
- **Responsibilities**:
  - Manage mobility-related services
  - Handle transportation operations
- **Communication**:
  - REST APIs

---

### 💸 Fines Microservice
- **Technology**: SOAP
- **Responsibilities**:
  - Manage fines and penalties
  - Provide legacy-compatible services
- **Communication**:
  - SOAP Web Services

---

### 🌾 Agriculture Microservice
- **Technology**: GraphQL
- **Responsibilities**:
  - Manage agricultural data
  - Efficient querying and manipulation of data

---

### 🌦 Weather Microservice
- **Technology**: gRPC
- **Responsibilities**:
  - Provide weather-related information
  - High-performance inter-service communication

---

## 🚦 API Gateway
- **Technology**: Spring Boot (Java)
- **Responsibilities**:
  - Central entry point for all client requests
  - Route requests to appropriate microservices
  - Simplify client-side communication

---

## 🧠 Orchestrator Service
- **Technology**: Spring Boot (Java)
- **Responsibilities**:
  - Orchestrate workflows across multiple microservices
  - Coordinate communication between services
  - Aggregate responses and manage cross-domain business logic

---

## 🛠 Technologies Used
- **Backend**: Spring Boot (Java)
- **Architecture**: Microservices
- **Communication Protocols**:
  - REST
  - SOAP
  - GraphQL
  - gRPC
- **Containerization**:
  - Docker
  - Docker Compose
- **Testing**:
  - Postman
- **Version Control**:
  - Git & GitHub

---

## 🐳 Containerization & Deployment
- Each microservice runs in its own Docker container
- Databases are containerized
- Docker Compose is used to orchestrate services locally

### ▶ Run the project
```bash
docker-compose up --build


<img width="1536" height="1024" alt="ChatGPT Image 11 déc  2025, 23_06_30" src="https://github.com/user-attachments/assets/99470ad4-666f-4080-9edd-394ef19756d2" />

