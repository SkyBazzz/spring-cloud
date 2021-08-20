FROM openjdk:8-jdk-alpine

COPY target/service.jar /usr/app/service.jar
EXPOSE 8801
ENV JAVA_OPTS="local"
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -jar /usr/app/service.jar --spring.cloud.config.uri=http://configserver:9000 --eureka.client.serviceUrl.defaultZone=http://eurekaserver:8761/eureka/
