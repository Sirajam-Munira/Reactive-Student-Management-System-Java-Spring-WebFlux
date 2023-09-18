# Reactive Student Management System: Java, Spring WebFlux

# Reactive Student Management System

![Java](https://img.shields.io/badge/Java-11-orange)
![Spring WebFlux](https://img.shields.io/badge/Spring%20WebFlux-2.5.4-brightgreen)
![Reactor](https://img.shields.io/badge/Reactor-3.4.15-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen)
![UUID](https://img.shields.io/badge/UUID-Unique%20IDs-lightgrey)
![Lombok](https://img.shields.io/badge/Lombok-Reduced%20Boilerplate%20Code-yellow)
![Maven](https://img.shields.io/badge/Maven-Dependency%20Management-blueviolet)

This simple project is a reactive web application that manages student data using Spring WebFlux, a framework for building reactive applications in Java. 
It allows for the creation, retrieval, updating and deletion of student records.

## Tech Stack

- **Java**: The primary programming language used for developing the application.
- **Spring WebFlux**: A reactive programming framework for building asynchronous and non-blocking web applications.
- **Reactor**: A library for building reactive and event-driven applications in Java.
- **Spring Boot**: A framework that simplifies the setup and configuration of Spring applications.


## Features

- **Reactive Endpoints**: Provides reactive RESTful endpoints for managing student records.
- **Student Data Model**: The `Student` class represents the data model for student records including fields such as `id`, `name`, and `email`.
- **Student Controller**: Defines REST endpoints for retrieving a stream of students, adding a student, updating a student and deleting a student.
- **Student Service**: Acts as an intermediary between the controller and the DAO (Data Access Object) and provides methods for handling student-related operations.
- **Student DAO**: Responsible for managing the student data including adding, updating, deleting and retrieving students using Reactor's Flux and Mono for asynchronous processing.
- **UUID Generation**: Each student record is assigned a unique identifier (`UUID`) during creation.
- **Exception Handling**: Includes exception handling to manage scenarios where students are not found.
- **Reactive Programming**: Leverages reactive programming concepts enabling it to handle multiple requests concurrently without blocking.
- **Maven Dependency Management**: Uses Maven for managing project dependencies, making it easy to build and package the application.
