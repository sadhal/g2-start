
## Paketera javaapplikationen mha gradle
För att vår javaapplikation ska hitta mongodb inne i Openshift kommer vi använda Kubernetes Service för service discovery. Se den uppdaterade application.properties filen.  
Vi behöver skapa en task som ska bygga en docker image. Det gör vi i vår `build.gradle` fil. Exempel på detta finns i techday/build.gradle filen.  
Task buildDocker, som vi nu har skapat, använder sig av en Dockerfile som:  
 * utgår ifrån en base image som har jdk8  
 * exponerar port 8080  
 * skapar en katalog och sätter den som working directory  
 * lägger till vår färdigbyggda artefakt (fat jar)  
 * ändrar rättigheter till katalogen
 * växlar till icke root användare  
 * startar applikationen

Denna Dockerfile hittar du under katalogen techday.  
Med kommandot `./gradlew buildDocker` kommer du nu bygga en image som heter `172.30.1.1:5000/myproject/my-cool-app:0.0.1-SNAPSHOT` men då vi inte har loggat in mot docker registryt inne i vårt Openshift kluster får vi ett fel när gradle försöker pusha upp imagen.  
För att råda bot på detta måste vi logga in mot detta docker registry. Det är ett vanligt docker kommando: `docker login -u developer -p $(oc whoami -t) 172.30.1.1:5000`.  

Kör kommandot `./gradlew buildDocker` igen och nu ska docker push ha gått igenom.  

## Deploya applikationen på Openshift
Navigera till Openshift Web Console -> Add to project -> Deploy Image och välj:  
 * Namespace: contacts-dev
 * Image stream: my-cool-app  
 * Tag: 0.0.1.SNAPSHOT

Gå tillbaka till Översikten och expandera raden my-cool-app.  
Om allt har gått bra ska applikationen deployas och en blå ring runt siffran för antal poddar visas.  

## Verifiera
```bash
curl $(oc get svc | grep my-cool-app | awk '{ print $2}'):8080/person
```
