In this application we are using the basic security provided by spring. In the starter you need to choose the dependency as - Core -> security.

The dependency in the pom.xml will look like:
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency

Things required in the application
==================================
1) Use the annotation @EnableGlobalMethodSecurity in the starter application 
2) In application.properties provide the credentials e.g. 
		security.user.name=guest
		security.user.password=guest123
3) While testing in JUnit test case, you need to provide these credentials through HttpHeaders

Running the application
==============================
While accessing the web-service, you need to provide the credentials. Credentials has been set in the application.properties.

Rest we will see in the application. Happy coding...