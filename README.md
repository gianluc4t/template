# Template project
____

This app is just a template base to develop Web service restfull , using 
* H2 inmemory DB, 
* hibernate as ORM, 
* spring data for data acess model, 
* spring boot as web server solution, 
* swagger-ui as documentation pattern, 
* junit+mockito for unit test layer
* docker 

____
 
** Prerequisites **

1. java 8
1. mvn 3.5

____
  
** Run test and jacoco report **
 
> mvn clean test
 
 the jacoco report can be found in {project root}\target\jacoco-ut\index.html
 
____
  
** Run local **
 
> mvn clean spring-boot:run

____
  
** docker: install **
 
> mvn clean install dockerfile:build

____
  
** docker: run **
 
> docker run -p 8080:8080 -t templatedock/template

____

** swagger **

swagger documentation/test pages can be found [here](http://localhost:8080/swagger-ui.html)