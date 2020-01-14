FROM adoptopenjdk:11-jre-hotspot

COPY build/libs/time-0.0.1-SNAPSHOT.jar /tpmsTime.jar
RUN chmod 777 tpmsTime.jar
CMD ["java","-jar", "tpmsTime.jar"]