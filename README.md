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
```

If the build succeeds, you should see a BUILD SUCCESS message.

### 2. Start Docker Containers
Run the following command to start the application and database containers:

```bash
docker-compose up
```

This will spin up two containers:

- app: Contains the Spring Boot application.
- db: Contains the MySQL database (MySQL 5.7).

### 3. Remove the app Docker Image
After starting the containers, manually delete the app image either using the command line or the Docker Desktop UI. This ensures that the application can be run directly via IntelliJ or from the command line.

Command to remove the app image:

```bash
docker rmi app
```

### 4. Run the Application via IntelliJ or Command Line
Once the app image is removed, you can run the application either through IntelliJ IDEA or using the command line:

- Run via IntelliJ IDEA:

Open the project in IntelliJ.
Navigate to the CS-Hub application class (usually located in src/main/java).
Right-click on the class and select Run 'CS-HubApplication'.

- Run via command line:

```bash
mvn spring-boot:run
```

### 5. Test the Application
Once the application is running, you can verify that it is working by visiting the following URL in your browser:

```bash
http://localhost:8080/health
```
This will check if the service is up and running.

## Project Structure

This project is a Spring Boot application that follows a modular architecture, organized into different packages for maintainability and scalability. Below is a detailed breakdown of the project structure.


```bash
.
├── .mvn/wrapper
│   ├── maven-wrapper.jar
│   ├── maven-wrapper.properties
├── imgs
│   ├── springboot-boilerplate.jpg
│   ├── swagger-1.jpg
│   ├── swagger-2.jpg
├── src/main
│   ├── java/com/smu
│   │   ├── common
│   │   │   └── # Common utilities, constants, and helpers.
│   │   ├── configuration
│   │   │   └── # Configuration classes for Spring beans, security, etc.
│   │   ├── controller
│   │   │   └── # REST API controllers that handle incoming HTTP requests.
│   │   ├── exceptions
│   │   │   └── # Custom exception handling for the application.
│   │   ├── model
│   │   │   └── # Entity classes and data models representing the application’s domain.
│   │   ├── repository
│   │   │   └── # Data access layer, containing interfaces for database operations.
│   │   ├── security
│   │   │   └── # Security configuration, e.g., authentication, authorization.
│   │   ├── service
│   │   │   └── # Service layer that handles business logic.
│   │   ├── utils
│   │       └── # Utility classes for common operations like date parsing, validation, etc.
│   ├── resources
│   │   ├── messages
│   │   │   └── # Resource bundles for localized messages.
│   │   ├── exception
│   │   │   └── # Templates for exception messages.
│   │   ├── general
│   │   │   └── # General resource files, such as banners.
│   │   ├── validation
│   │       └── # Validation messages and configuration.
│   ├── application.yml
│   ├── banner.txt
├── .DS_Store
├── .dockerignore
├── .gitignore
├── Dockerfile
├── LICENSE
├── README.md
├── docker-compose.yml
├── local-docker-compose.yml
├── pom.xml
```


## Configuration Files
The project’s configuration file is application.yml, which sets the server port to 8080.
Database details are configured in the Docker Compose file local-docker-compose.yml.

## Notes
If you encounter a port conflict, ensure the correct port is set in the application.yml file (e.g., 8080).
Make sure Docker is properly installed and running locally.
Let me know if you need any other changes!







