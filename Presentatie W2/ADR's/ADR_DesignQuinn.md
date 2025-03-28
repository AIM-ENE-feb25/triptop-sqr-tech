# ADR over Design Pattern
**Date:** 28-03-2025  
**Status:** Accepted

**Author** Quinn

## Context
Mijn gekozen ontwerpvraag is: Hoe kunnen verschillende boekingsservices (zoals Booking.com en eigen beheer in Triptop) worden geïntegreerd?
Ik heb een design pattern nodig waarmee ik de boekingsservices gemakkelijk kan integreren.

## Considered Options
### 1. **State Pattern**
**Voordelen:**
- Het gebruik van state pattern zorgt voor een hogere leesbaarheid.
- Het vermijd lange if-else blokken.

**Nadelen:**
- Wordt complex als je heel veel states hebt in je applicatie.

### 2. **Strategy Pattern**
**Voordelen:**
- Maakt het mogelijk om functionaliteit binnen een klasse aan te passen zonder de klasse zelf aan te passen.
- Maakt het eenvoudig om functionaliteiten/algoritmen te onderhouden(omdat het gescheiden is).

**Nadelen:**
- Kan leiden tot meer complexiteit en een groot aantal klassen.

### 3. **Adapter Pattern**
**Voordelen:**
- Zorgt ervoor dat nieuwe code gemakkelijk kan samenwerken met oude code.
- Zorgt voor een betere loskoppeling tussen componenten

**Nadelen:**
- Het kan een groot aantal adapters geven, waardoor het moeilijk te onderhouden wordt.

### 4. **Facade Pattern**
**Voordelen:**
- Het verhoogd de leesbaarheid van de code. Het systeem wordt niet intern opgesplitst.

**Nadelen:**
- Het kan gebeuren dat één facade te veel verantwoordelijkheden krijgt.

### 5. **Factory Method**
**Voordelen:**
- Het maakt het mogelijk om objecten flexibel te creëren

**Nadelen:**
- Je kan het overzicht verliezen, waardoor het moeilijker te begrijpen is hoe objecten precies worden gemaakt

## Decision
Uiteindelijk is er gekozen voor het Adapter pattern, omdat deze het makkelijk maakt om nieuwe services te integreren. Tevens verhoogd het de leesbaarheid.

## Consequences
- De inbreng van nieuwe code gaat gemakkelijk, omdat het makkelijk kan samenwerken met de oude code.
- Er ontstaat een duidelijk overicht, door de loskoppeling van componenten.

## Conclusion
Het Adapter Pattern is de beste keuze voor het integreren van boekingsservices.


## Bronnen
- [Software-Design-Patterns.pptx](https://aim-ene.github.io/soex/assets/files/Software-Design-Patterns-0d2fdea120bb6494d39f949233e45cc5.pptx)
- [Design-Patterns](https://refactoring.guru/design-patterns)  
