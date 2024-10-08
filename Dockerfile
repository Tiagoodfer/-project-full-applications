# Use a base image with Java 17, which matches your JDK version
FROM openjdk:17-oracle

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
