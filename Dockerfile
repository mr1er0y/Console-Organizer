FROM openjdk:18
COPY target .
ADD src src
RUN chmod +x  Console-Organizer-1.1-SNAPSHOT.jar

ENTRYPOINT java -jar Console-Organizer-1.1-SNAPSHOT.jar





