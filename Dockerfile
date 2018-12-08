# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Nilofar.S@cognizant.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/project-manager-backend-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
# ADD ${JAR_FILE} project-manager-backend.jar

# Run the jar file 
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project-manager-backend.jar"]
