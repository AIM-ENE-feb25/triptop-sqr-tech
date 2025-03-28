# API-verbindingsstrategie

**Date:** 2025-03-21
**Status:** Accepted

## Context
Bij het integreren van externe APIs in een applicatie is het essentieel om te bepalen of deze aanroepen vanuit de **frontend**, **backend**, of beide moeten plaatsvinden. 
Dit beïnvloedt de beveiliging, prestaties en architectuur van de applicatie. 

## Considered Options
### 1. API-aanroepen direct vanuit de frontend
- **Voordelen:** Snellere interactie, minder belasting op de backend.
- **Nadelen:** CORS-problemen (Sommige api's staan dit niet toe), blootstelling van API-sleutels (kan lekken in browser).

### 2. API-aanroepen via de backend
- **Voordelen:** Beveiliging van API-sleutels, controle over API-verzoeken, betere validatie.
- **Nadelen:** Extra drukte op je back-end en langere wachttijden.

## Decision
Voor deze casus is besloten dat **alle API-aanroepen via de backend verlopen**. 
Dit zorgt voor een betere beveiliging, 
voorkomt CORS-problemen en zorgt ervoor dat API-sleutels niet in de front-end(browser) kunnen lekken.

## Consequences
- **Verbeterde beveiliging:** API-sleutels blijven verborgen en gevoelige data wordt niet blootgesteld aan de client.
- **Betere controle:** De backend kan verzoeken valideren, API-limieten beheren en foutafhandeling implementeren.
- **Hogere belasting op de backend:** Extra netwerkverkeer en verwerkingstijd kunnen invloed hebben op prestaties voor de eindgebruiker.

Wij vinden beveiliging belangrijker dan de extra belasting dat zich meebrengt op de back-end waardoor deze aanpak de voorkeur krijgt.

## Conclusion
Door alle API-aanroepen via de backend te laten verlopen, wordt de applicatie veiliger en beter beheersbaar. 
Hoewel dit een extra belasting voor de back-end kan betekenen, 
zijn de voordelen op het gebied van beveiliging en controle een hogere prioriteit. 