<<<<<<< HEAD
# OnlineLearningManagement
=======

# Online Learning Management System

Online Learning Management System (LMS) built using Spring Boot for the backend and Angular for the frontend.

## Prerequisites

Before you can run the application, you need to have the following software installed:

- Java Development Kit (JDK) - Version 11.0+
- Node.js - Version 16.16.0
- Angular CLI - Version 16.2.2
- MySQL Database

## Backend Setup (Spring Boot)

1. Clone the repository:
   
   git clone https://github.com/Phani-E650/OnlineLearningManagement.git

# OnlineLearningManagementSystem

## Introduction
The Online Learning Management System is designed to assist teachers and students in effectively organizing online education. It offers a user-friendly interface for accessing educational resources and course content.

## Project Architecture:

![image](https://github.com/lpatcha/elearning/assets/146805651/0d3e1dfa-c9b2-49a0-9278-3f4b936c7ceb)

### Presentation Layer:
This layer is responsible for the user interface and interaction with the OLMS.
It includes components such as web browsers and user interfaces.
Users interact with the OLMS through these components, accessing features like 
i) User registration 
ii) course content 
iii) assignments etc.
Communication: The presentation layer sends user requests and input to the application layer for processing.

### Application Layer:
This layer contains the core logic and functionality of the OLMS.
It handles user authentication, course management, content delivery, and other business logic.
It includes components such as the OLMS server, application server, and database server.
Communication: The application layer receives user requests from the presentation layer and processes them. It interacts with the database server to retrieve or store data. It then formulates responses and sends them back to the presentation layer.

### Model Layer:
This layer is responsible for storing and managing the data used by the OLMS.
It includes components such as the database server or file storage server.
The data layer stores user profiles, course materials, grades, and other relevant information.
Communication: The application layer communicates with the data layer to retrieve or store data. It sends queries or commands to the database server, which processes them and returns the requested data or performs the necessary data manipulation.

## Software Prerequisites:
Before you can run the application, you need to have the following software installed:
Java Development Kit (JDK) - Version 11.0+
Node.js - Version 16.16.0
Angular CLI - Version 16.2.2
MySQL Database


## Backend Setup (Spring Boot)
Clone the repository:

git clone https://github.com/lpatcha/elearning.git
main

cd OnlineLearningManagement/backend

spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name

spring.datasource.username=your_db_username

spring.datasource.password=your_db_password



Build and run the Spring Boot application:
./mvnw spring-boot:run


## Frontend Setup (Angular)


Build and run the Spring Boot application: ./mvnw spring-boot:ru

## Frontend Setup (Angular):
main
cd OnlineLearningManagement/frontend

npm install

ng serve

The frontend now be accessible at http://localhost:4200


>>>>>>> 49f765454a9d5bcfeb1d9ae7ab95b946d1a5881d
