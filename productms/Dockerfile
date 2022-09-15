FROM jdk:8 as build


# Copy the jar to the production image from the builder stage.
COPY  build/libs/productms-0.0.1-SNAPSHOT.jar /productms.jar

# Run the web service on container startup.
CMD java -jar /productms.jar