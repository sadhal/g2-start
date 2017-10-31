## Några enkla övningar
För att komma igång med docker:  

### Docker hjälpen
```bash
docker COMMAND --help
```
### Lista alla images på din dator
```bash
docker images
```
### Lista alla aktiva containers
```bash
docker ps
```
### Ladda hem några images
```bash
docker pull centos
docker pull frolvlad/alpine-oraclejdk8:slim
docker pull centos/httpd-24-centos7
```
### Starta en container från en image
```bash
docker run --rm --name myapache -p 9999:8080 docker.io/centos/httpd-24-centos7
```
Växeln `--rm` talar om för docker engine att automatiskt ta bort containern och all dess data efter avslutad exekvering.  
Växeln `--name` sätter ett namn på containern. Om växeln `--rm` inte hade använts skulle vi kunna starta upp instansen `myapache` på nytt med kommandot `docker start myapache`.  
Växeln `-p` talar om hur vi vill mappa localhostens portar mot containerns portar.  
Observera att detta kommando kommer låsa din terminal så du kan öppna ett nytt fönster och lista alla containers. Man kan starta containers som daemon vilket vi kommer testa lite senare.  Efter detta kan du besöka URLen [localhost:9999](localhost:9999) och verifiera att din appache instans är igång. Ett Red Hat Enterprise Linux Test Page borde visas.  
### Exekvera kommandon inuti en container
```bash
docker exec -it myapache bash
echo "Hej, världen..." > /var/www/html/index.html
```
Växeln `-it` talar om för docker engine att vi önskar köra containern i interaktivt läge och att allokera pseudo-TTY.  
Uppdatera din webbläsare och texten `Hej, världen...` borde visas istället för RHELs testsida. Du kan stoppa din container mha av kommandot `docker stop myapache`.
### Bygga en egen docker image
Skapa en fil som ska paketeras inuti en docker image:   
```bash
echo "Hejsan från Umeå" > minfil.txt
```
Skapa en fil som heter Dockerfile (ex: `gedit Dockerfile`) och har följande innehåll:
```bash
FROM centos
COPY minfil.txt min-super-applikation.txt
CMD cat min-super-applikation.txt
```
Bygg imagen från Dockerfile (obs! glöm inte punkten i build kommandot):  
```bash
docker build -t techday/heavy .
docker images
docker run --rm -it techday/heavy
```
Vi skulle i princip kunna paketera vad som helst i en docker image. Tänk på att det är EN process som ska startas i sista kommandot och det bör vara er applikation eller ett skript som startar den.
