# Fin Hub Microservice 
Spring-Boot application preconfigured for to generate Customer Insights.

[![Fin-Hub](https://img.icons8.com/?size=100&id=106564&format=png&color=000000)](https://github.com/devaraja0527/fin-hub)


## Features
This template provides the following:

* Spring-Boot Application with Spring Security


## Requirements
The application can be run locally or in a docker container, the requirements for each setup are listed below.



### Local
* [Java 17 SDK](https://www.oracle.com/java/technologies/downloads/?er=221886#java17)
* [Gradle](https://gradle.org/)


### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `1234`

Configure the port by changing `server.port` in __application.yml__


Application will run by default on port `8080`

Configure the port by changing `services.api.ports` in __docker-compose.yml__. Port 1234 was used by default so the value is easy to identify and change in the configuration file.


If everything is working as expected, the request should return a pleasant greeting. ;)