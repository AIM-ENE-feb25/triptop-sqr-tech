# API-verbindingsstrategie

**Date:** 2025-03-21
**Status:** Accepted

## Context
Bij het integreren van externe APIs in een applicatie is het essentieel om te bepalen of deze aanroepen vanuit de **frontend**, **backend**, of beide moeten plaatsvinden. Dit beïnvloedt de beveiliging, prestaties en architectuur van de applicatie. Beveiligingsrisico's zoals het blootstellen van API-sleutels en het omgaan met CORS-beperkingen spelen hierbij een belangrijke rol.

## Considered Options
### 1. API-aanroepen direct vanuit de frontend
- **Voordelen:** Snellere interactie, minder belasting op de backend.
- **Nadelen:** Beveiligingsrisico’s door blootgestelde API-sleutels, CORS-beperkingen.

### 2. API-aanroepen via de backend
- **Voordelen:** Beveiliging van API-sleutels, controle over API-verzoeken, betere logging en validatie.
- **Nadelen:** Extra netwerkverkeer en latency.

## Decision
Voor deze casus is besloten dat **alle API-aanroepen via de backend verlopen**. Dit zorgt voor een betere beveiliging en controle over de data, voorkomt CORS-problemen en zorgt ervoor dat API-sleutels niet in de frontend beschikbaar zijn.

## Consequences
- **Verbeterde beveiliging:** API-sleutels blijven verborgen en gevoelige data wordt niet blootgesteld aan de client.
- **Betere controle:** De backend kan verzoeken valideren, API-limieten beheren en foutafhandeling implementeren.
- **Hogere belasting op de backend:** Extra netwerkverkeer en verwerkingstijd kunnen invloed hebben op prestaties.
- **Mogelijke vertraging in respons:** Omdat alle API-verzoeken via de backend gaan, kan er enige vertraging optreden in de verwerking.

Over het algemeen weegt de verhoogde beveiliging en controle op tegen de extra belasting, waardoor deze aanpak de voorkeur krijgt.

## Conclusion
Door alle API-aanroepen via de backend te laten verlopen, wordt de applicatie veiliger en beter beheersbaar. Hoewel dit een extra belasting voor de server kan betekenen, zijn de voordelen op het gebied van beveiliging en controle doorslaggevend. Dit besluit zorgt voor een robuustere en duurzamere architectuur.