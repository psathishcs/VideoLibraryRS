FROM java:8
VOLUME /tmp
ADD build/libs/VideoLibraryRS-1.0.1.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Duser.timezone=GMT", "-jar","/app.jar"]