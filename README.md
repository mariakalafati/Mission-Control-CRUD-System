# Mission-Control-CRUD-System
Lab Assignment 1 for the "Software Engineering in Practice" course at the Department of Management Science and Technology, Athens University of Economics and Business.

## Overview
This repository contains the **MarsOps** application, a Spring Boot-based CRUD system for managing space station resources. The project demonstrates **CI/CD pipeline automation**, **build automation**, and **Docker containerization** for a seamless deployment pipeline. The application provides basic CRUD functionality for space station resource management, including tracking resources like oxygen, water, and fuel, essential for space missions to Mars.

The goal of this project is to set up a fully automated **CI/CD pipeline** to ensure that code is always built, tested, and packaged properly. The pipeline integrates automated checks for code quality, tests, and Docker build automation, ensuring the deployable artifact is always ready.

### The application is designed to:
- Manage space station resources (CRUD operations).
- Integrate a **CI/CD pipeline** with **GitHub Actions**.
- Use **Docker** to containerize the backend application and integrate a simple UI for user interaction.

## Purpose
This repository serves as an example project for the "Mission: Mars Deployment" CI/CD challenge, where DevOps principles are applied to ensure that the **MarsOps CRUD Application** is always deployed in a reliable and automated way. It demonstrates:
- Code quality checks (Checkstyle).
- Unit tests and coverage (JaCoCo).
- Build automation with **Maven**.
- Docker containerization of the backend service.

The project also includes a simple HTML interface for users to interact with the backend CRUD system.

## Application Details
- **Framework**: Spring Boot 3.x (Java 21)
- **Database**: H2 (In-memory)
- **UI**: HTML, CSS, and JavaScript (simple UI for interacting with the CRUD system)
- **Build Tool**: Maven
- **CI/CD Tool**: GitHub Actions
- **Containerization**: Docker

## Getting Started

### Running Locally
1. Clone the repository
2. Build with Maven: mvn clean package
3. Run the application: java -jar target/MarsOps-0.0.1-SNAPSHOT.jar
Access the application at http://localhost:8080/resources

### Using Docker
1. Build the Docker image: docker build -t marsops:latest .
2. Run the container: docker run -p 8080:8080 marsops:latest
3. Access the application at http://localhost:8080/resources

## Licence
The project is under the Apache 2.0 Licence 
