##  ING Mars Rover

This project is part of the ING coding challenge, the mars-rover service will connect to the NASA Api and return the photos of out query search.
Also it will save some auditing information, like the request method name, date of the query, response time; into our H2 DB.


## Project Structure

### src/main/java

Under this path we have several packages mentioned below:

1. com.ing.marsRover -> We have the Spring Boot Application and the Swagger configuration files.

2. com.ing.marsRover.controller -> Application controllers

3. com.ing.marsRover.helper -> Helper class with Constants

4. com.ing.marsRover.dto -> DTO class to separate the service layer of the persistance layer.

5. com.ing.marsRover.entities -> Objects to map the entities needed in the application

6. com.ing.marsRover.enums -> An Enum to manage the search criteria

7. com.ing.marsRover.repository -> Interface of the repository to interact with the H2 schema

8. com.ing.marsRover.service -> Application services 


### src/main/resources

1. H2 files -> schema.sql is the script to create the schema in H2.


### src/test/java

1. com.ing.marsRover-> Integration test

2. com.ing.marsRover.controller  -> Unit test to check the controller's functionality

3. com.ing.marsRover.service -> Unit test to check the service's functionality



## Getting Started

This is a Spring Tool Suite(Eclipse) based, Gradle project written in Java 8, with Spring Boot, Lombok, and Swagger.
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.



### Prerequisites

So please follow these instructions so you can setup the environment properly.

1. Get Git in your local -> In case you don’t have it already, go ahead and follow this guide: [Install-Git](https://www.atlassian.com/git/tutorials/install-git)

2. Get your IDE -> Since this is a Gradle project you can use the IDE of your preference, (I used Spring Tool Suite) just make sure to import the project as an “Existing Gradle Project”

3. Point your IDE to the right JRE version -> This project is build over Java 8 so please make sure that your Java Build Path is pointing to the JRE 1.8 version. You’ll find this option under: Preferences-> Java -> Installed JREs (Eclipse based IDE)

4. Get Lombok -> Lombok is an external jar that needs to be added into your IDE. For more information on how to add Lombok to your IDE (Eclipse or IntelliJ) follow this guide: [Lombok-IDE](https://www.baeldung.com/lombok-ide) Also there’s a copy of the jar file (Lombok.jar) in the project under the root folder.


#### For testing the backend

You can test the endpoints via Postman.

```
http://localhost:8080/mars-rover/v1/retrievePhotos
```
And since there's an actuator you can also hit that to test connectivity.

```
http://localhost:8080/actuator/health 
```

##### Installing Postman

1. Download the app from the official site: [Postman](https://www.getpostman.com/downloads/)

2. Import the Json file containing the Collection of endpoints you’ll need to test the app. You can find the file MarsRoverCollection.postman_collection.json under the root folder of the project. Just hit the “Import” button on the left corner, choose Import File, and drag and drop the file there. Or if you prefer you can use a shareable link, so click the Import button on the left corner, choose Import From link and copy this link [Postman Collection](TODO)



### Installing

Once your development environment is setup, we can go ahead and get the project into your IDE and run it. So please follow the next steps to do so:

1. Clone the repo into your local: https://github.com/kalfie88/ingMarsRover.git or download the zip folder.

```
git clone https://github.com/kalfie88/ingMarsRover.git
```

2. Import the project into your IDE: Right click -> Import -> Gradle -> Existing Gradle Project and follow the wizard.

3. Try Clean and Build first to make sure everything is compile and really. 

4. Run the project: This is a Spring Boot project, so just go to src/main/java/com/ing/marsRover/MarsRoverApplication.java and right click on it -> Run As -> Spring Boot App.

5. The project is running under: http://localhost:8080/

6. To hit the Endpoints: Open Postman and run each of the endpoints in the collection imported in the section above (Prerequisites)


#### Endpoints available 

To see the documentation of the endpoints available you can refer to Swagger.

1. Run the app following the step #4 of the Installing section

2. Open a browser and type:

```
http://localhost:8080/swagger-ui.html#/

```

You’ll find the description for the endpoints here

```
http://localhost:8080/swagger-ui.html#/mars-rover-controller

```


## Running the tests

For this project, we have one integration test, and several unit test under the src/main/test path.
But for a more visual test you can use Postman.



## Author

* **Katherine Alfaro Ramirez** - *Initial work* - [kalfie88](https://github.com/kalfie88)
