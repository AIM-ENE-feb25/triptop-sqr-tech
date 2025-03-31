# ADR 1: API-verbindingsstrategie

**Datum:** 2025-03-21  
**Status:** Accepted

---

## Context
Bij het integreren van externe APIs in een applicatie moet je goed nadenken over waar de aanroepen plaatsvinden: aan de kant van de **frontend**, de **backend**, of een combinatie van beide. Deze keuze heeft invloed op de beveiliging (_confidentiality_), prestaties (_performance_) en controle over hoe de applicatie werkt.

In het geval van Triptop werken we met verschillende externe diensten, zoals Booking.com, NS API, KLM, en identity providers zoals Google. Daarom is het belangrijk om bewust te kiezen waar de externe communicatie plaatsvindt in onze architectuur.

---

## Considered Options

### 1. API-aanroepen direct vanuit de frontend
- **Voordelen:**
    - Snelle interactie voor de gebruiker
    - Minder belasting op de backend
- **Nadelen:**
    - CORS-problemen (sommige APIs staan geen frontend-verkeer toe)
    - Minder grip op foutafhandeling en logging
    - Beperkte controle over validatie van gegevens

### 2. API-aanroepen via de backend
- **Voordelen:**
    - Betere controle over datavalidatie, caching en foutafhandeling
    - Geen CORS-issues
    - Logging kan centraal worden geregeld
- **Nadelen:**
    - Meer netwerkverkeer via de backend
    - Mogelijk iets langere responstijden

---

## Decision
Voor deze casus is besloten dat **alle externe API-aanroepen via de backend verlopen**.

Hierdoor hebben we meer controle over hoe externe services worden aangeroepen, kunnen we foutmeldingen en uitzonderingen beter afvangen, en voorkomen we afhankelijkheid van wat er allemaal in de browser gebeurt. Ook kunnen we centraal loggen en valideren, wat handig is bij het troubleshooten of monitoren van de applicatie.

---

## Consequences
- **Meer controle:** De backend fungeert als centrale laag waar foutafhandeling, validatie en logging plaatsvinden.
- **Geen CORS-problemen:** Omdat alles via de backend loopt, zijn er geen beperkingen door browserbeveiliging.
- **Hogere belasting op de backend:** Alle API-verzoeken lopen via onze servers, wat meer resources kost.
- **Iets meer vertraging mogelijk:** Doordat alles via de backend loopt, is er iets meer latency.

Deze aanpak ondersteunt vooral de kwaliteitseis **Confidentiality**. In de toekomst kan dit worden herzien als bepaalde externe services andere eisen of mogelijkheden bieden.

