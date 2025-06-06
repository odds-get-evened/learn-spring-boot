FROM registry.ny.gov/artifactory/its_docker_virt/ubi9/ubi-minimal:9.4

WORKDIR /app

COPY target/*.jar /app/app.jar

RUN microdnf install java-17-openjdk -y

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]