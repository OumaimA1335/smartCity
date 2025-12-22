🌆 Smart City Microservices Project
📌 Overview

This project is a Smart City platform built using a microservices architecture with Spring Boot (Java).
The system is designed to be scalable, modular, and loosely coupled, where each microservice is responsible for a specific business domain.

An API Gateway is used for routing and centralized access, and an Orchestrator manages the coordination and communication between microservices.

🧱 Microservices Architecture

The platform is composed of four core microservices, an API Gateway, and an Orchestrator Service:

🚗 Mobility Microservice

Technologies: REST & SOAP

Responsibilities:

Manage mobility services

Handle fines and transportation operations

Communication:

REST APIs

SOAP Web Services

🌾 Agriculture Microservice

Technology: GraphQL

Responsibilities:

Manage agricultural data

Flexible data querying using GraphQL

🌦 Weather Microservice

Technology: gRPC

Responsibilities:

Provide real-time weather information

High-performance inter-service communication

🚦 API Gateway

Technology: Spring Boot (Java)

Responsibilities:

Central entry point for all client requests

Request routing to appropriate microservices

Load balancing and request forwarding

Improved security and separation of concerns

🧠 Orchestrator Service

Technology: Spring Boot (Java)

Responsibilities:

Orchestrate workflows across multiple microservices

Coordinate inter-service communication

Aggregate responses from different services

Manage business processes spanning multiple domains

🛠 Technologies Used

Backend: Spring Boot (Java)

Architecture: Microservices

Communication Protocols:

REST

SOAP

GraphQL

gRPC

Infrastructure:

Docker

Docker Compose

Testing:

Postman

Version Control:

Git & GitHub

🐳 Containerization

Each microservice is containerized using Docker

Databases are containerized

Docker Compose orchestrates all services for local deployment

Run the project:

docker-compose up --build

🧪 Testing

REST, SOAP, and GraphQL APIs tested using Postman

gRPC services tested with compatible gRPC clients

📂 Project Structure (Example)
smartcity-project/
│
├── api-gateway/
├── orchestrator-service/
├── mobility-service/
├── agriculture-service/
├── weather-service/
├── docker-compose.yml
└── README.md

🚀 Key Features

API Gateway for centralized routing

Orchestrator for service coordination

Multiple communication protocols

Fully containerized microservices

Scalable and maintainable architecture

👩‍💻 Author

Oumaima Chelly
Junior Software Engineer – Java & Microservices<img width="1536" height="1024" alt="ChatGPT Image 11 déc  2025, 23_06_30" src="https://github.com/user-attachments/assets/00eda3ed-5221-46b6-a397-2d6af2161f01" />
