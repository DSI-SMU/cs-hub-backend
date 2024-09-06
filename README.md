# CS-Hub

## Overview
This is a backend service project based on Spring Boot and MySQL, containerized using Docker to manage the application and database.

## Requirements
- **JDK 17**
- **Maven 3.6+**
- **Docker**
- **Docker Compose**

## Steps to Run Locally

### 1. Check if the Project Builds Successfully

First, use Maven to clean and build the project:

```bash
mvn clean install

If the build succeeds, you should see a BUILD SUCCESS message.

### 2. Start Docker Containers
Run the following command to start the application and database containers:

```bash
docker-compose up

This will spin up two containers:

- app: Contains the Spring Boot application.
- db: Contains the MySQL database (MySQL 5.7).

### 3. Access the Application
Once the application starts, you can access it via the following URL:

```arduino
http://localhost:8080

Note: The project uses a `wait-for-it.sh` script to ensure MySQL is fully ready before the application starts.

## Configuration Files
The project’s configuration file is `application.yml`, which sets the server port to 8080.
Database details are configured in the Docker Compose file local-docker-compose.yml.

## Notes
If you encounter a port conflict, ensure the correct port is set in the application.yml file (e.g., 8080).
Make sure Docker is properly installed and running locally.
