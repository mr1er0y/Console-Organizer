FROM openjdk:18
COPY out/artifacts/Console_Organizer_jar/ .
ADD src src
RUN chmod +x  Console-Organizer.jar

ENTRYPOINT java -jar Console-Organizer.jar





