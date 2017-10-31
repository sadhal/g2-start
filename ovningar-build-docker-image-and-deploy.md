
## Paketera javaapplikationen mha gradle
Vi behöver skapa en task som ska bygga en docker image. Det gör vi i vår `build.gradle` fil. Exempel på detta finns i techday/build.gradle filen.  
Task buildDocker, som vi nu har skapat, använder sig av en Dockerfile som:  
 * utgår ifrån en base image som har jdk8  
 * exponerar port 8080  
 * skapar en katalog och sätter den som working directory  
 * lägger till vår färdigbyggda artefakt (fat jar)  
 * ändrar rättigheter till katalogen
 * växlar till icke root användare  
 * startar applikationen

