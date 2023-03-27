FROM openjdk:8-jdk-slim
LABEL maintainer=yichengming
COPY ware-auth-client/target/ware-auth-client-0.0.1-SNAPSHOT.jar /auth-client.jar
COPY ware-auth-server/target/ware-auth-server-0.0.1-SNAPSHOT.jar /auth-server.jar
COPY ware-gateway/target/ware-gateway-0.0.1-SNAPSHOT.jar /gateway.jar
COPY ware-interface/target/ware-interface-0.0.1-SNAPSHOT.jar /interface.jar
COPY ware-model/target/ware-model-0.0.1-SNAPSHOT.jar /model.jar
COPY ware-service/target/ware-service-0.0.1-SNAPSHOT.jar /service.jar
ENTRYPOINT ["java","-jar","/auth-client.jar"]
ENTRYPOINT ["java","-jar","/auth-server.jar"]
ENTRYPOINT ["java","-jar","/gateway.jar"]
ENTRYPOINT ["java","-jar","/interface.jar"]
ENTRYPOINT ["java","-jar","/model.jar"]
ENTRYPOINT ["java","-jar","/service.jar"]