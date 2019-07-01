FROM openjdk:11.0.3-jdk-slim-stretch
ADD ./target/neo4j-demo-0.0.1-SNAPSHOT.jar  /app/demo/neo4j-demo-0.0.1-SNAPSHOT.jar
WORKDIR   app/demo
ENTRYPOINT  ["java","-jar","neo4j-demo-0.0.1-SNAPSHOT.jar"]