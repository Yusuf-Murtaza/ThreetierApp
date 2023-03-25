# File Upload API

This is a Spring Boot project that demonstrates a file upload API using Spring Boot, Spring Data JPA, PostgreSQL, and Swagger. The project includes a REST endpoint for uploading XML files and saving the associated metadata to a PostgreSQL database.

## Pre-requisites

Before you can run this project, you need to have the following software installed on your local machine:

1. Java Development Kit (JDK) 17 - https://access.redhat.com/documentation/en-us/openjdk/17/html-single/installing_and_using_openjdk_17_for_windows/index 
For mac - https://www.codejava.net/java-core/install-openjdk-17-on-macos 
2. PostgreSQL 13 database server - https://www.postgresql.org/download/windows/
If you are using MAC OS Montrey use PostgreSQL 15
For mac - https://www.postgresql.org/download/macosx/
3. Download the "DBeaver" from Google and Install in your MAC as per Intel/Apple chip
4. Gradle (optional, as the project includes a Gradle Wrapper)
5. IntelliJ - Set Project SDK to level 17 , java 17 - https://crunchify.com/intellij-idea-project-module-and-latest-java-setup-java-17-or-newer/
Also, make sure to set up the PostgreSQL database according to the project configuration.

Opening the Gradle Project in Intellij:
1. Goto File-> New -> Project from existing Sources and browse the "threetier" project
2. Select the "build.gradle" file and open it in Intellij as "New Project"

Changes to be done in DBeaver
1. Select the "postgres" from list of option and click "Next"
2. Once you have installed postgres, the name of your MAC machine will be the super-user
3. Remember the user which we created for Postgres having user name as "user_2" and password as "test321"
4. "user_2" will have same set of features as what we have for super-user
5. Click on postgres on top left side and click Create connection. Provide the database as "sampledb" and username as super-user name. Leave password as blank
6. Click on "Test Connection" and it should be successful

Running the project from Intellij:
1. Goto src->main->java->ThreetierApplication and click on RUN button on top Left. It will start running the project
2. Once run is successful we have to launch postman and hit POST url "http://localhost:8080/upload/{pligtigNummer}" where pligtigNummer is any integer number
3. Create any abc.xml file in your system and try to upload it via postman
4. For success of step 3, we need to check the database whether abc.xml file got uploaded or not. In DBeaver goto sampledb->schemas->public->table and open the table named "Files" which got created and see the "abc.xml" over there


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



