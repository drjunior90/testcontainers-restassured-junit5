# Testcontainers Demo

This is a spring boot project that exposes /customers endpoint and data can be persisted in mongodb database.

In the Integration Tests, the Testcontainers Java library is used for starting mongodb in a docker container.
 
## How to run Application

#### Option 1:
Running application from command line using Docker, this is the cleanest way.
In order for this approach to work, of course, you need to have Docker installed in your local environment.

* From the root directory you can run the following command:<br/>
    ```docker-compose -f docker/docker-compose.yml up --build```
* Application will be running on: http://localhost:3101/api/v1/customers
* To stop it you can press Ctrl + C, and then run the following command:<br/>
    ```docker-compose -f docker/docker-compose.yml down```

#### Option 2:
In case you have mongodb installed locally, and you want to run from IDE

* Import the testcontainers-demo application as a Maven project to your IDE.
* Run maven clean install command to build the project.
* Then you can search for TestcontainersDemoApplication.java class and run it with profile 'dev'
* Application will be running on: http://localhost:8080/api/v1/customers

#### Option 3:
In case you don't have mongodb installed locally, and you want to run from IDE
   
* Import the testcontainers-demo application as a Maven project to your IDE.
* Run maven clean install command to build the project.
* From the command line run the following command to have mongodb running in a docker container:<br/>
    ```docker run -d -p 27017:27017 --name mongodb mongo:4.2.6```
* Then you can search for TestcontainersDemoApplication.java class and run it with profile 'dev'
* Application will be running on: http://localhost:8080/api/v1/customers

## How to run the Integration Test

#### Option 1:
* Import the testcontainers-demo application as a Maven project to your IDE.
* Run maven clean install with profile 'runit' to build the project and start running the IT tests.<br/>
    ```mvn clean install -Prunit```

#### Option 2:
* Import the testcontainers-demo application as a Maven project to your IDE.
* Run maven clean install command to build the project.
* Then you can search for CustomerIT.java class and run it as a junit test.