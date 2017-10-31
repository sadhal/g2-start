# g2-start
En enklare guide till Docker och Openshift 

## Introduktion till Docker

### Vad är docker?
Docker är en typ av linuxcontainerteknik (LXC). Linux containers isolerar och kapslar in hela din applikation från den underliggande host operativsystemet.  
En av bättre beskrivningar är en jämförelse mellan docker och en klassisk virtuell maskin. Medan docker är en abstraktion på en applikationsnivå så är en virtuell maskin en abstraktion av fysisk hårdvara. Docker images är binära artefakter som genereras av dockers byggmotor. Docker containers är runtime instanser av dessa images. Vi kan se det som klasser och objekt (inom objekt orienterad programmering) där image liknar en klass och container ett objekt. 


## Introduktion till Openshift v3.6
Openshift är en PaaS lösning (platform as a service) som är framtagen av Red Hat. Den bygger på open source ramverket Kubernetes som används för orkestrering av linux containrar i stor skala.  
Openshift kan installeras på olika typer av infrastruktur: fysiska och virtuella servrar, privata, publika och hybrid molnlösningar.  
Openshift kluster omfattar flera maskiner som samverkar som en enhet. Några maskiner agerar som mastrar och har som sin huvudsakliga uppgift att styra övriga maskiner. En bra regel är att använda några maskiner som infranoder där klustergemensamma förmågor exekverar. Arbetarnoder är maskiner där egenutvecklade och/eller tredje parts applikationer deployas.  
Ett kluster kan, från version 3.6, bestå av upp till 2000 maskiner. Hur många pods (minsta driftsättningsbara enheten i kubernetes) kan deployas på en maskin beror på många faktorer där tillgång på RAM-minne och antal CPU-er är väldigt relevanta.

## Övningar
För att gå vidare med övningarna checka ut branchen `steg-1` och följ anvisningar i filen `ovningar-docker.md`.
