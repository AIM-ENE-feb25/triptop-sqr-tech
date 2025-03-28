# API Data Validatie en Opslagstrategie

**Date:** 2025-03-21
**Status:** Accepted

## Context
Bij het integreren van externe APIs is het belangrijk om te verifiëren 
of de data die we ontvangen overeenkomt met 
de verwachtingen uit ons domeindiagram. 
Daarnaast willen we bepalen welke data opgeslagen moet worden in onze database, 
om onnodige data te vermijden.

## Considered Options
### 1. Alle data opslaan in de database
- **Voordelen:** Volledige dataset beschikbaar voor eventuele uitbreidingen.
- **Nadelen:** Opslag van onnodige data, risico op dataduplicatie.

### 2. Alleen essentiële data opslaan
- **Voordelen:** Efficiënt gebruik van de database, weinig tot geen dataduplicatie.
- **Nadelen:** Mogelijke afhankelijkheid van externe API's voor ontbrekende data.

### 3. Data cachen in plaats van opslaan
- **Voordelen:** Snellere toegang tot veelgebruikte data zonder permanente opslag.
- **Nadelen:** Tijdelijke opslag kan leiden tot dataverlies bij cache-verversing.

## Decision
Na analyse is besloten om **alleen essentiële data op te slaan** in de database. Dit betekent:
- **Reisdata (Distance API en Booking.com API)**: Alleen unieke id's, naam, locatie en prijs opslaan. Gedetailleerde info kan op aanvraag via de API worden opgehaald.
- **E-mail en SMS-logboeken**: Uitsluitend transactie logs opslaan, geen inhoudelijke berichten.
- **Push-notificaties**: Geen opslag, slechts tijdelijke verwerking.
- **Gebruikersgegevens**: Alleen basisgegevens opslaan en authenticatie via een externe provider (Wiremock) beheren.

## Consequences
- **Efficiënte opslag**: Minder data-duplicatie en overzichtelijke data.
- **Externe afhankelijkheid**: Sommige data moet real-time uit de API worden opgehaald, wat vertraging kan veroorzaken.
- **Veiligheidswinst**: Minder (gevoelige) data in de database vermindert risico’s bij een datalek.

## Conclusion
Door alleen essentiële data op te slaan en andere informatie via externe APIs op te vragen, wordt de applicatie overzichtelijk, veilig en efficiënt. 
Deze strategie minimaliseert onnodige data terwijl de toegang tot belangrijke data behouden blijft.