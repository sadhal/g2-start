
## Uppstart och grundläggande kommandon i Openshift
Förbered terminalen med command completion:  
```bash
source <(oc completion bash)
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

## Deploya en applikation via Web Console
Öppna projektet contacts-dev i Web Console och klicka på knappen Add to project.  
Klicka på knappen Datastores eller gör en sökning på Mongodb.  
Välj MongoDB ephemeral och mata in följande värden i formuläret:  
* MongoDB Connection Username : sadhal  
* MongoDB Connection Password : sadhal  

Observera att alla nödvändiga uppgifter för anslutning mot databasen presenteras i webbgränssnittet. Klicka på länken Gå till översikt och kontrollera att en deployment med namn **mongodb** har skapats.  

## Visa information om en podd
Klicka på Applications -> Pods -> mongodb podden.  
Fliken Details visar grundläggande information om podden.  
Fliken Environment visar miljövariabler som injectas i poddens alla containrar.  
Fliken Metrics visas bara om den funktionen är installerad.  
Fliken Logs visar allt som loggas på stdout och stderr för poddens alla containrar. Samma data hamnar i aggregerad loggning.      
Fliken Terminal används för att undersöka containrar. Ungefär som att ssh:a in på en linuxserver.  
Fliken Events visar viktiga händelser som inträffar under poddens livscykel.  

## Visa information om en Deployment
Klicka på Applications -> Deployments -> mongodb -> deploymentnummer (senaste).  
Fliken Details visar konfiguration som används vid driftsättning av en podd.  
Resten kan ni undersöka själva.  
För att skala upp antal instanser av en applikation kan du klicka på uppåt pekande pilen på Details fliken, bredvid den blåa cirkeln.  
För att skala ner antal instanser av en applikation kan du klicka på nedåt pekande pilen på Details fliken, bredvid den blåa cirkeln.  

Undersök gärna även Services och Routes.  
Prova gärna att exponera din applikation

