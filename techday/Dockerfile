FROM frolvlad/alpine-oraclejdk8:slim

EXPOSE 8080

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

ADD techday-0.0.1-SNAPSHOT.jar app.jar

RUN chown -R 1001:0 /usr/src/app && chmod -R ug+rwx /usr/src/app

USER 1001

ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/src/app/app.jar"]
