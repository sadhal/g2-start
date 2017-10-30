
## Uppstart och grundläggande kommandon i Openshift
```bash
source <(oc completion bash)
oc cluster up
```
Hjälp för alla kommandon:
```bash
oc kommando --help
```
Starta ett lokalt Openshiftkluster
```bash
oc cluster up
```

## Skapa openshift projects
Konceptet project i Openshift är ett sätt att segmentera applikationer i olika områden.  
Låt oss logga in på vårt lokala Openshift kluster via webbgränssnittet. Logga in som developer på både Web Console och CLI. Länkar och instruktioner genereras när kommandot ```oc cluster up``` är färdigt.  
Skapa ett development project för denna övning:
```bash
oc new-project contacts-dev
```
Öppna projektet contacts-dev i Web Console och klicka på knappen Add to project.  
Klicka på knappen Datastores eller gör en sökning på Mongodb.  
Välj MongoDB ephemeral och mata in följande värden i formuläret:  
* MONGODB_DATABASE=sampledb  
* MONGODB_USER=sadhal  
* MONGODB_PASSWORD=sadhal  

Observera att alla nödvändiga uppgifter för anslutning mot databasen presenteras i webbgränssnittet. Klicka på länken Gå till översikt och kontrollera att en deployment med namn **mongodb** har skapats.  

Klicka på Applications -> Pods -> mongodb podden  
Välj fliken Logs för att se loggar  
Välj fliken Terminal för att koppla upp mot containern  
