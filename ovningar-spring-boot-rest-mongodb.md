
## Lägg till MongoDB i den befintliga applikationen och exponera CRUD operationer

### Uppdatera javakoden
Skapa en Entity-klass (Spring Data terminologi) och ett Repository-interface som utökar MongoRepository.  
Exempel på båda finns i katalogen techday/src/main/java/se/rsv/umea/techday. Filerna Person.java och PersonRepository.java.  

### Uppdatera application.properties med MongoDB URI
Vi kommer återanvända MongoDB podden som ni startade tidigare. Uppdatera application.properties filen med följande innehåll:
```bash
spring.data.mongodb.uri=mongodb://sadhal:sadhal@172.30.179.204:27017/sampledb
```
Där ni byter ut IPnumret 172.30.179.204 mot det IPnummer som er mongodb service har. Ni kan hitta IPnumret via Web Console eller mha kommandot `oc get svc`.    

### Kontrollera health-check endpointen från Actuator
```bash
curl localhost:8080/health
```

## Specification by example
Scenario: Endpointen `/person` med metod GET ska returnera alla personer i db  
GIVEN en endpoint lyssnar på sökvägen `/person` och metod GET  
WHEN en användare anropar endpointen  
THEN responsen är en JSON array med personer lagrade i db  

Scenario: Endpointen `/person` med metod POST ska lägga till en personer i db  
GIVEN en endpoint lyssnar på sökvägen `/person` och metod POST  
WHEN en användare anropar endpointen med JSON data  
THEN responsen är en sträng med id:t för den nya personen  


### Test 
```bash
curl localhost:8080/person

curl localhost:8080/person -d '{"firstName":"abc","lastName":"def","email":"s.h@skv.se","twitterHandle":"myTwitterHandle"}' -H "Content-type: application/json"

curl localhost:8080/person -d '{"firstName":"cba","lastName":"fed","email":"cba@skv.se","twitterHandle":"cbafed"}' -H "Content-type: application/json"

curl localhost:8080/person
```
