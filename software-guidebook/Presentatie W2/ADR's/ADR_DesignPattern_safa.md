# ADR over Design Pattern
**Date:** 28-03-2025  
**Status:** Accepted

## Context
Voor mijn vraagstuk(Hoe maak je de applicatie uitbreidbaar met nieuwe bouwstenen?) 
is een design pattern nodig dat structuur biedt om gemakkelijk meerdere bouwstenen 
aan te maken zonder al bestaande code te veranderen. 

## Considered Options

### 1. **State Pattern**
**Voordelen:**
- Duidelijke scheiding van verantwoordelijkheden.
- Maakt het toevoegen van nieuwe staten eenvoudig.

**Nadelen:**
- Kan complex worden als er veel staten zijn.

### 2. **Strategy Pattern**
**Voordelen:**
- Flexibel en uitbreidbaar.
- Houdt algoritmes gescheiden en makkelijk aanpasbaar.

**Nadelen:**
- Kan overkill zijn als er weinig varianten van een algoritme zijn.

### 3. **Adapter Pattern**
**Voordelen:**
- Zorgt ervoor dat bestaande code kan samenwerken met nieuwe code.
- Houdt code gescheiden en herbruikbaar.

**Nadelen:**
- Kan extra complexiteit toevoegen door de introductie van nieuwe interfaces.

### 4. **Facade Pattern**
**Voordelen:**
- Vereenvoudigt de interface(s) naar een complex systeem.

**Nadelen:**
- Kan leiden tot een "god object" dat te veel verantwoordelijkheden krijgt.

### 5. **Factory Method**
**Voordelen:**
- Verkleint de afhankelijkheid van specifieke klassen (losse koppeling).
- Zorgt voor een centrale plaats voor objectcreatie, wat onderhoud vergemakkelijkt.

**Nadelen:**
- Kan extra complexiteit toevoegen door de noodzaak van meerdere subklassen.

## Decision
De **Factory Method** is gekozen omdat deze het mogelijk maakt om objecten te creëren zonder afhankelijk te zijn van specifieke implementaties. 
Dit verhoogt de flexibiliteit en uitbreidbaarheid van de code.

## Consequences
- De sourcecode wordt beter gestructureerd en onderhoudsvriendelijker.
- Nieuwe typen objecten kunnen worden toegevoegd zonder bestaande code te wijzigen.

## Conclusion
De Factory Method is de beste keuze om flexibiliteit en schaalbaarheid te krijgen in de software.

## Bronnen
- [Software-Design-Patterns.pptx](https://aim-ene.github.io/soex/assets/files/Software-Design-Patterns-0d2fdea120bb6494d39f949233e45cc5.pptx)
- [Design-Patterns](https://refactoring.guru/design-patterns)  
