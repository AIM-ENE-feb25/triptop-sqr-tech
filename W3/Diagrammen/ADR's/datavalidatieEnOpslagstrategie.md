### 8.2. API Data Validatie en Opslagstrategie

**Datum:** 2025-03-21

#### Context

Bij het gebruik van externe APIs in onze applicatie is het belangrijk dat we controleren of de data die we binnenkrijgen ook daadwerkelijk past binnen ons domeinmodel. Denk hierbij aan het controleren van datatypes, verplichte velden, en of de structuur overeenkomt met wat ons systeem verwacht. Dit voorkomt fouten bij het gebruik van deze data in de applicatie of bij het opslaan ervan.

Daarnaast willen we bewust omgaan met het opslaan van data: wat slaan we op in onze eigen database, en wat kunnen we beter ophalen op het moment dat het nodig is? Het doel hiervan is om onnodige opslag te vermijden en alleen data te bewaren die relevant is voor de werking van onze applicatie.

In het kader van **modifiability** en **data-integriteit** is het niet wenselijk om klakkeloos alles op te slaan. Wanneer we bijvoorbeeld wisselende of snel verouderende data zoals actuele prijzen of beschikbaarheid opslaan, lopen we het risico dat die data niet meer klopt. We willen dus alleen opslaan wat essentieel is, stabiel is, of moeilijk opnieuw op te halen is.

---

#### Considered Options

### 1. Alle data opslaan in de database
- **Voordelen:**
    - Alles is lokaal beschikbaar voor latere uitbreiding
    - Minder afhankelijk van externe services bij gebruik
- **Nadelen:**
    - Onnodige belasting op opslag
    - Risico op verouderde of dubbele gegevens
    - Grotere kans op inconsistentie tussen opgeslagen data en de actuele data bij de bron

### 2. Alleen essentiële data opslaan
- **Voordelen:**
    - Minder opslagcapaciteit nodig
    - Minder kans op inconsistente data
    - Flexibeler systeem dat minder afhankelijk is van vaste datamodellen
- **Nadelen:**
    - Externe API moet soms alsnog real-time worden geraadpleegd
    - Mogelijk meer netwerkverkeer en vertraging bij ophalen van aanvullende gegevens

### 3. Data alleen cachen (tijdelijk bewaren)
- **Voordelen:**
    - Snelle toegang tot veelgebruikte data zonder dat het permanent opgeslagen wordt
    - Handig voor gegevens die vaak opgevraagd worden, maar snel kunnen veranderen
- **Nadelen:**
    - Data kan vervallen of verouderd zijn, cache moet goed beheerd worden
    - Bij verversing van de cache kan belangrijke informatie verloren gaan als er geen fallback-mechanisme is

---

#### Decision

We kiezen ervoor om **alleen essentiële data op te slaan**. Hierdoor blijft de database overzichtelijk en efficiënt ingericht. Niet-essentiële of snel veranderende informatie wordt alleen opgevraagd op het moment dat het nodig is, bijvoorbeeld bij het tonen van details of bij het afronden van een boeking.

Bijvoorbeeld: in het geval van overnachtingen slaan we alleen basisgegevens op zoals locatie, naam, prijsindicatie en ID. Extra informatie zoals foto's, reviews of precieze beschikbaarheid wordt opgehaald via de betreffende externe API.

---

#### Status

**Status:** Accepted

---

#### Consequences

-  **Efficiënte opslag**: Alleen de data die nodig is wordt bewaard, waardoor de database overzichtelijk blijft. Dit maakt onderhoud en query’s eenvoudiger.
-  **Veiliger systeem**: Minder gevoelige data opgeslagen betekent minder risico bij datalekken. Denk hierbij aan gebruikersdata of reserveringsinformatie die we beter niet onnodig bewaren.
-  **Afhankelijkheid van externe APIs**: Als de API niet beschikbaar is, kan bepaalde data tijdelijk niet getoond worden. Dit vereist goede fallback-logica of duidelijke meldingen aan de gebruiker.
-  **Extra latency mogelijk**: Soms is een extra API-aanroep nodig om ontbrekende info op te halen. Dit kan invloed hebben op de snelheid van bepaalde onderdelen van de applicatie, vooral bij meerdere opeenvolgende API-aanroepen.
