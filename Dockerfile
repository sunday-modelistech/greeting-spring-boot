FROM alpine/git as clonerepo
WORKDIR /app
RUN git clone https://github.com/sunday-modelistech/greeting-spring-boot.git

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /app
COPY --from=clonerepo /app/greeting-spring-boot /app
RUN mvn -B package --file pom.xml

FROM alpine:latest
RUN apk add openjdk8
RUN mkdir /usr/local/webservice
COPY --from=build /app/target/webservice-greeting.jar /usr/local/webservice/webservice-greeting.jar
RUN chmod +x /usr/local/webservice/webservice-greeting.jar
EXPOSE 8080