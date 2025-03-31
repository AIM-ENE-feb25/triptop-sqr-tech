# ADR 2: API Data Validatie en Opslagstrategie

**Datum:** 2025-03-21  
**Status:** Accepted

---

## Context
Bij het gebruik van externe APIs in onze applicatie is het belangrijk dat we controleren of de data die we binnenkrijgen ook daadwerkelijk past binnen ons domeinmodel. Daarnaast willen we bewust omgaan met het opslaan van data: wat slaan we op in onze eigen database, en wat kunnen we beter ophalen op het moment dat we het nodig hebben?

In het kader van **modifiability** en **data-integriteit** is het niet wenselijk om klakkeloos alles op te slaan. We willen alleen opslaan wat essentieel is voor de werking van onze applicatie.

---

## Considered Options

### 1. Alle data opslaan in de database
- **Voordelen:**
    - Alles is lokaal beschikbaar voor latere uitbreiding
    - Minder afhankelijk van externe services bij gebruik
- **Nadelen:**
    - Onnodige belasting op opslag
    - Risico op verouderde of dubbele gegevens

### 2. Alleen essentiële data opslaan
- **Voordelen:**
    - Minder opslagcapaciteit nodig
    - Minder kans op inconsistente data
- **Nadelen:**
    - Externe API moet soms alsnog real-time worden geraadpleegd

### 3. Data alleen cachen (tijdelijk bewaren)
- **Voordelen:**
    - Snelle toegang tot veelgebruikte data zonder dat het permanent opgeslagen wordt
- **Nadelen:**
    - Data kan vervallen of verouderd zijn, cache moet goed beheerd worden

---

## Decision
We kiezen ervoor om **alleen essentiële data op te slaan**. Hierdoor blijft de database overzichtelijk en efficiënt ingericht. Niet-essentiële of snel veranderende informatie wordt alleen opgevraagd op het moment dat het nodig is.

### Concreet betekent dit:
- **Reisdata (zoals locaties en prijzen)**: Alleen unieke ID’s, naam, locatie en prijs worden opgeslagen. Voor extra info wordt de API geraadpleegd.
- **E-mail/SMS-logboeken**: Alleen basisgegevens zoals verzendtijd en status worden opgeslagen, niet de inhoud zelf.
- **Push-notificaties**: Worden direct verwerkt maar niet opgeslagen.
- **Gebruikersgegevens**: Alleen basisinformatie (zoals naam en e-mailadres), authenticatie verloopt via een externe identity provider.

---

## Consequences
- ✅ **Efficiënte opslag**: Alleen de data die nodig is wordt bewaard, waardoor de database overzichtelijk blijft.
- ✅ **Veiliger systeem**: Minder gevoelige data opgeslagen betekent minder risico bij datalekken.
- ⚠️ **Afhankelijkheid van externe APIs**: Als de API niet beschikbaar is, kan bepaalde data tijdelijk niet getoond worden.
- ⚠️ **Extra latency mogelijk**: Soms is een extra API-aanroep nodig om ontbrekende info op te halen.

---

## Conclusion
Deze aanpak zorgt voor een goede balans tussen databeheer, prestaties en veiligheid. Door alleen op te slaan wat écht nodig is, blijft het systeem flexibel en schaalbaar. Deze beslissing ondersteunt vooral de quality attributes **modifiability**, **confidentiality**, en **interoperability**.

