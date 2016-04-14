FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD service-employee-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx128m","-Xss256k","-jar","/app.jar"]