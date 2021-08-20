FROM openjdk:8-jdk-alpine

COPY target/service.jar /usr/app/service.jar
EXPOSE 9000

ENTRYPOINT java -Djava.net.preferIPv4Stack=true -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -jar /usr/app/service.jar --spring.cloud.config.uri=http://configserver:9000
