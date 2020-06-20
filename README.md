# Cars Garage - Cars4Sale ( Backend)
This is a Spring Boot Web application used to fetch car details for a website selling seconf hand cars

How to Run
This application is packaged as a war which has Tomcat 8 and MongoDB embedded.  You run it using the ```java -jar``` command.

## Steps needed:
* Clone this repository
* Confirm using JDK 1.8 and Maven 3.x
* You can build the project by running mvn clean package
* Once successfully built, you can run the service by one of these two methods:
```
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=default"
```


The REST API details are mentioned in the below url . The port used is 8091. 

http://localhost:8091/swagger-ui.html#/

Once this is set , navigate to the below url and set up the front end application . 

Cars4Sale - Frontend : 
https://github.com/Vdsouza22/frontend-car-garage

Once its done , access the front end using the below url.

http://localhost:8081/#/home
