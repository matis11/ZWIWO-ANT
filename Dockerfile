FROM guligo/jdk-maven-ant:latest

COPY zwiwo-ant /zwiwo-ant

WORKDIR /zwiwo-ant

CMD ["ant"]
