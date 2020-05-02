FROM maven:3.6.3-jdk-8 AS BUILD_STAGE

WORKDIR /usr/src/customer-api/

COPY . .
COPY docker/settings.xml /root/.m2/settings.xml

RUN ["mvn", "install", "-Dmaven.test.skip=true"]

FROM openjdk:8u222-jre AS EXECUTION_STAGE

COPY --from=BUILD_STAGE /usr/src/customer-api/target/*.jar /customer-api.jar

ENTRYPOINT ["java", "-jar", "/customer-api.jar"]