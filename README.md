# spring-boot-calculator api-application

    Calculator Test Application

# For this microservice, we need installed and correctly configured the next tools:

    Java 16
    Apache Maven 3.8.4
    Spring Boot 2.7.12
    Lombok 
    Junit 5

# Port where the microservice publish the API Methods

    Microservice Port: 8081: Active profile = default profile

# We add the next dependency to the main pom.xml file

# we create a new folber called lib in the path: ${project.basedir}/lib and we copy the file tracer-1.0.0.jar to this path

        <dependency>
            <groupId>io.corp.calculator</groupId>
            <artifactId>tracer</artifactId>
            <version>1.0.0</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/lib/tracer-1.0.0.jar</systemPath>
        </dependency>

# Compile and run the microservice:

# To Compile and run this microservice, in a sheel command, we change to the main project folder, and we execute the following command line

    $> mvn -Dmaven.compiler.fork=true clean install -U spring-boot:run -Dmaven.test.skip=true -f pom.xml

# Run Test

    mvn test

# Swagger URL

# In the path: ${project.basedir}/src/main/resources/public/api we have a file: operation-service.yml with a definition of the api-rest implemented on the controller

    We can test the operation of the microservice with swagger in the next URL: http://localhost:<server.port>

# EndPoints

    http://localhost:8081/api/calculator/v1/add?firstValue=10&secondValue=5
    http://localhost:8081/api/calculator/v1/add?firstValue=10&secondValue=5xx
    http://localhost:8081/api/calculator/v1/add?firstValue=10xx&secondValue=5xx

    http://localhost:8081/api/calculator/v1/subtract?firstValue=10&secondValue=5
    http://localhost:8081/api/calculator/v1/subtract?firstValue=10&secondValue=5xx
    http://localhost:8081/api/calculator/v1/subtract?firstValue=10xx&secondValue=5xx

# Technologies

    Java 16, Swagger Spring Boot 2.7.12, Lombok Junit 5 Mockito, rest-assured Intellij Maven
