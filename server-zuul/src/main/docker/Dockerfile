FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD server-zuul-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Xmx128m","-Xss256k","-jar","/app.jar"]