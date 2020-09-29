FROM openjdk:8u181-jre-alpine3.8
ADD /target/*.jar /
RUN mv /*.jar api-pet.jar
ENTRYPOINT exec java -jar api-pet.jar