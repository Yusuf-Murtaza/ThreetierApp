# File Upload API

This is a Spring Boot project that demonstrates a file upload API using Spring Boot, Spring Data JPA, PostgreSQL, and Swagger. The project includes a REST endpoint for uploading XML files and saving the associated metadata to a PostgreSQL database.

## Pre-requisites

Before you can run this project, you need to have the following software installed on your local machine:

1. Java Development Kit (JDK) 17 - https://access.redhat.com/documentation/en-us/openjdk/17/html-single/installing_and_using_openjdk_17_for_windows/index 
For mac - https://www.codejava.net/java-core/install-openjdk-17-on-macos 
2. PostgreSQL 13 database server - https://www.postgresql.org/download/windows/
For mac - https://www.postgresql.org/download/macosx/
3. Gradle (optional, as the project includes a Gradle Wrapper)
4. IntelliJ - Set Project SDK to level 17 , java 17 - https://crunchify.com/intellij-idea-project-module-and-latest-java-setup-java-17-or-newer/ 
Also, make sure to set up the PostgreSQL database according to the project configuration.

## Setting up the PostgreSQL database

1. Install and run the PostgreSQL server on your local machine.
2. Create a new database called `sampledb`.
3. Update the `application.properties` file in the project with the appropriate PostgreSQL configuration (username, password).

The project includes a `schema.sql` file that contains the schema creation script for the required tables. The Spring Boot application will automatically create the tables when you run the project for the first time.

## Building the project

To build the project, navigate to the project directory and run the following command:

./gradlew build 


This command will compile the project and create an executable JAR file in the `build/libs` directory.

## Running the project

To run the project, execute the following command from the project directory:

./gradlew bootRun


The Spring Boot application will start, and you can access the API at `http://localhost:8080`.

## Using the /upload endpoint

To test the file upload use case, you can use a REST client like [Postman](https://www.postman.com) or [curl](https://curl.se) to make a POST request to the `/upload` endpoint:

POST http://localhost:8080/upload/{pligtigNummer}


Replace `{pligtigNummer}` with an appropriate integer value. Include the following request parameters:

- `year`: An integer value (required)
- `datafil`: An XML file to upload (required)



