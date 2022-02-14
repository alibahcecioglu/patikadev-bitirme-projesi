# Gittigidiyor Java Spring Bootcamp Grauduation Project

## How to Run?
* Clone this repository
* What do you need?
  * Java IDE(Intellij IDEA)
  * JDK 1.8
  * Maven 3.x
  * Mysql Server
 
### MYSQL Server
* CREATE DATABASE graduation;

### SPRING BOOT
* 1 - **eurekaserver Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/eurekaserver-1.0.0.jar
  ```
  
* 2 - **configserver Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/configserver-1.0.0.jar
  ```
  * Check the stdout or boot_example.log file to make sure no exceptions are thrown
  
* 3 - **customerservice Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/customerservice-1.0.0.jar
  ```
  
* 4 - **scoreservice Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/scoreservice-1.0.0.jar
  ```
  
* 5 - **smsservice Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/smsservice-1.0.0.jar
  ```
  
* 6 - **applyservice Module**
  * You can build the project and run the tests by running ```mvn clean package```
  * You have to build the module::
  ```
        java -jar -Dspring.profiles.active=test target/applyservice-1.0.0.jar
  ```

  ## About Services
  * Eureka Server
  * Config Server
  * Customer Service
  * Score Service
  * Sms Service
  * Apply Service
