## Några enkla övningar
För att komma igång med docker:  
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
Detta kommando kommer låsa din terminal så du kan öppna ett nytt fönster och lista alla containers. Man kan starta containers som daemon vilket vi kommer testa lite senare.  Efter detta kan du besöka URLen [localhost:9999](localhost:9999) och verifiera att din appache instans är igång. Ett Red Hat Enterprise Linux Test Page borde visas.  
### Exekvera kommandon inuti en container
```bash
docker exec -it myapache bash
echo "Hej, världen..." > /var/www/html/index.html
```
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
