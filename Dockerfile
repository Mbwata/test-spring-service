#
# Build stage
#
FROM maven:3.6.3-jdk-8 AS build
COPY spring-boot/src /home/app/src
COPY spring-boot/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install
run ls -l /home/app/target

#
# Package stage
#
FROM tomcat:8.5

COPY tomcat_image/tomcat-users.xml /usr/local/tomcat/conf

COPY --from=build /home/app/target/claimnumber.war /usr/local/tomcat/webapps/