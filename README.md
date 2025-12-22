🌆 Smart City Microservices Project
📌 Overview

This project is a Smart City platform developed using a microservices architecture with Spring Boot (Java).
Each service is independent, loosely coupled, and communicates through different protocols depending on its use case.

The system includes an API Gateway for routing and an Orchestrator Service to manage business workflows between microservices.

🧱 Microservices Architecture

The platform is composed of multiple microservices, each responsible for a specific domain:

🚗 Mobility Microservice

Technology: REST

Responsibilities:

Manage mobility-related services

Handle transportation operations

Communication:

REST APIs

💸 Fines Microservice

Technology: SOAP

Responsibilities:

Manage fines and penalties

Provide legacy-compatible SOAP services

Communication:

SOAP Web Services

🌾 Agriculture Microservice

Technology: GraphQL

Responsibilities:

Manage agricultural data

Efficient data querying using GraphQL

🌦 Weather Microservice

Technology: gRPC

Responsibilities:

Provide weather information

High-performance inter-service communication

🚦 API Gateway

Technology: Spring Boot (Java)

Responsibilities:

Central entry point for all client requests

Route requests to appropriate microservices

Simplify client-side communication

🧠 Orchestrator Service

Technology: Spring Boot (Java)

Responsibilities:

Orchestrate workflows across multiple microservices

Coordinate communication between services

Aggregate responses and manage business logic spanning domains

🛠 Technologies Used

Backend: Spring Boot (Java)

Architecture: Microservices

Communication Protocols:

REST

SOAP

GraphQL

gRPC

Containerization:

Docker

Docker Compose

Testing:

Postman

Version Control:

Git & GitHub

🐳 Containerization & Deployment

Each microservice runs in its own Docker container

Databases are containerized

Docker Compose is used to orchestrate services locally

Start the system:

docker-compose up --build

🧪 Testing

REST, SOAP, and GraphQL APIs tested using Postman

gRPC services tested using appropriate gRPC clients

📂 Project Structure (Example)
smartcity-project/
│
├── api-gateway/
├── orchestrator-service/
├── mobility-service/
├── fines-service/
├── agriculture-service/<img width="1536" height="1024" alt="ChatGPT Image 11 déc  2025, 23_06_30" src="https://github.com/user-attachments/assets/e4ae1af5-ab1e-4997-a292-727e3ed02e5e" />

├── weather-service/
├── docker-compose.yml
└── README.md

🚀 Key Features

Clear separation of concerns

API Gateway for centralized routing

Orchestrator for cross-service workflows

Multiple communication protocols

Fully containerized architecture

👩‍💻 Author

Oumaima Chelly
Junior Software Engineer – Java & Microservices
