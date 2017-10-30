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
### Bygga en docker image
TODO -- använd någon bättre exempel applikation  
```bash
git clone https://github.com/sadhal/mean-contactlist.git
cd mean-contactlist
docker build -t sadhal/mean-contactlist .
docker images
docker run --rm -d -p 8888:8888 sadhal/mean-contactlist
docker ps
docker stop “container id”
```
