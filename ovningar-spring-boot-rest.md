
## Skapa en enkel RESTful endpoint
Antigen genom att öppna projektet i ett javavänligt IDE, texteditor eller granska techday-katalogen (filen RestResource.java).  

Scenario: Endpointen `/greeting` ska returnera JSON respons  
GIVEN en endpoint lyssnar på sökvägen `/greeting`  
WHEN en användare anropar endpointen  
THEN responsen är {"greeting-response":"Hello, world!"}  

Test: `curl localhost:8080/greeting`  


 


