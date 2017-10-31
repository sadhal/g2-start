
## Skapa en enkel tjänst mha Spring Boot
Navigera till [Spring initalizr](https://start.spring.io/) och generera skelettet till din applikation.  
Följande värden kan vi använda:  
 * byggstöd: gradle  
 * programmeringsspråk: java  
 * Spring Boot version: 1.5.8
 * group: se.rsv.umea
 * artifact: techday  
 * selected dependencies: actuator, web, mongodb, sleuth
 
Klicka på Generate project knappen och extrahera den zippade filen. Alternativt använder ni katalogen techday i detta repo.  
Kompilera applikationen mha `gradlew` skriptet. Kommandot är: `./gradlew build`.  
