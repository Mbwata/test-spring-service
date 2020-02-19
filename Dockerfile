#
# Build stage
#
#FROM claimbuild:latest AS build
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /home/app
COPY spring-boot/pom.xml /home/app
RUN mvn dependency:go-offline
COPY spring-boot/src /home/app/src
RUN mvn package
#RUN mvn -f /home/app/pom.xml clean install
RUN mvn -f /home/app/ sonar:sonar \
 -Dsonar.projectKey=claimno-service \
 #-Dsonar.host.url=http://sonarqube-service:9442 \
 #-Dsonar.host.url=http://sonarqube-service:9000 \ 
 -Dsonar.host.url=http://10.105.189.117:9442 \ 
 -Dsonar.login=084e51d5120719dc236b3af4e30b3f7de04b2a8d

#
# Package stage
#
FROM tomcat:8.5

COPY postgresql-42.2.9.jar /usr/local/tomcat/lib
COPY tomcat_image/tomcat-users.xml /usr/local/tomcat/conf

COPY --from=build /home/app/target/claimnumber.war /usr/local/tomcat/webapps/