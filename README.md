# Building, Testing, and Serving a Maven Application

This document provides instructions on how to build, test, and serve a Maven application.

## Prerequisites

Ensure that you have the following installed on your machine:

- Java Development Kit (JDK)
- Apache Maven

You can check if they are installed by running the following commands in your terminal:

```bash
java -version
mvn -version
```

## Building the Application

To build the application, navigate to the directory containing the `pom.xml` file and run the following command:

```bash
mvn clean install
```

This command cleans the target directory, compiles your code, runs any tests, and packages your code into a JAR file.

## Testing the Application

To run the unit tests, use the following command:

```bash
mvn test
```

This command runs the unit tests defined in your project.

## Serving the Application

To serve the application, you can use the `spring-boot:run` goal. Navigate to the project directory and run:

```bash
mvn spring-boot:run
```

This command starts your application. By default, Spring Boot applications run on port 8080.
