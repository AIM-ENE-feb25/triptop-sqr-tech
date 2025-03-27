# Huiswerk Les 3: Vervoer tussen Overnachtingen

## **Stap 1: Componenten en Verantwoordelijkheden**

De componenten in dit ontwerp zullen de volgende verantwoordelijkheden hebben:

- **TransportPlanner**: Verantwoordelijk voor het plannen van het vervoer tussen twee locaties.
- **TransportOption**: Algemene interface voor vervoersopties (zoals auto, trein, boot).
- **CarTransport**: Concrete implementatie van **TransportOption** voor vervoer per auto.
- **TrainTransport**: Concrete implementatie van **TransportOption** voor vervoer per trein.
- **BootTransport**: Concrete implementatie van **TransportOption** voor vervoer per boot (toegevoegd om de flexibiliteit te vergroten).
- **TransportTracker**: Houdt de status bij van het vervoer (bijv. gepland, betaald).

## **Stap 2: Interfaces en Methodes**

In de **Strategy Pattern** moet de interface voor **TransportOption** flexibel zijn, zodat je het sorteeralgoritme kunt veranderen zonder de **TransportPlanner** aan te passen.

- **TransportOption** interface:
    - `getRoute()`: Retourneert de route voor het vervoer.
    - `getPrice()`: Retourneert de prijs van het vervoer.
    - `book()`: Boekt het vervoer.

- **TransportPlanner**:
    - `planTransport(from: Location, to: Location)`: Retourneert een **TransportOption** afhankelijk van de keuze van het vervoermiddel (auto, trein, boot).

- **TransportTracker**:
    - `setStatus(id: string, status: string)`: Zet de status van het transport.
    - `getStatus(id: string)`: Haalt de status van het transport op.

## **Stap 3: Volgorde van Aanroepen**

De volgorde van aanroepen tussen de componenten is als volgt:

1. **Gebruiker** roept **TransportPlanner.planTransport(from, to)** aan.
2. **TransportPlanner** kiest de juiste **TransportOption** (bijv. **CarTransport** of **TrainTransport**) en roept de methoden aan om de route en prijs op te halen.
3. Gebruiker kiest de beste **TransportOption**.
4. **TransportOption** roept `book()` aan om het vervoer te boeken.
5. **TransportTracker** roept `setStatus()` aan om de status van het transport bij te werken naar "Geboekt".

## **Stap 4: Class Diagram met Strategy Pattern**

We gebruiken de **Strategy Pattern** om het vervoer flexibel te maken door verschillende **TransportOption**-strategieën te bieden. De **TransportPlanner** kan de juiste strategie kiezen op basis van de gebruiker en de voorkeuren voor het vervoermiddel.

### PlantUML Code voor Class Diagram

```plantuml
@startuml

interface TransportOption {
    +getRoute(): List<Location>
    +getPrice(): float
    +book(): boolean
}

class TransportPlanner {
    +planTransport(from: Location, to: Location): TransportOption
}

class CarTransport implements TransportOption {
    +getRoute(): List<Location>
    +getPrice(): float
    +book(): boolean
}

class TrainTransport implements TransportOption {
    +getRoute(): List<Location>
    +getPrice(): float
    +book(): boolean
}

class BootTransport implements TransportOption {
    +getRoute(): List<Location>
    +getPrice(): float
    +book(): boolean
}

class TransportTracker {
    +setStatus(id: string, status: string): void
    +getStatus(id: string): string
}

TransportPlanner --> TransportOption : uses
TransportOption <|.. CarTransport
TransportOption <|.. TrainTransport
TransportOption <|.. BootTransport
TransportPlanner --> TransportTracker : updates status

@enduml
# Conclusie: Vervoer tussen Overnachtingen

Met de **Strategy Pattern** kunnen we het vervoer tussen overnachtingen flexibel en uitbreidbaar maken. Door de **TransportOption** interface te gebruiken, kunnen verschillende vervoersopties zoals **CarTransport**, **TrainTransport** en **BootTransport** worden geïmplementeerd. Het systeem blijft eenvoudig uitbreidbaar, wat betekent dat we in de toekomst snel nieuwe vervoersopties kunnen toevoegen zonder de bestaande code aan te passen.

De **TransportPlanner** kiest dynamisch de juiste vervoersoptie op basis van de situatie, en de gebruiker kan gemakkelijk het gewenste vervoer kiezen en boeken. Het gebruik van de **Strategy Pattern** maakt het systeem schaalbaar en onderhoudbaar.

### Voordelen van het ontwerp:
- **Flexibiliteit**: Nieuwe vervoersopties kunnen eenvoudig worden toegevoegd zonder de bestaande code te breken.
- **Uitbreidbaarheid**: Het systeem kan gemakkelijk worden aangepast aan nieuwe eisen, zoals het toevoegen van nieuwe transporttypes.
- **Eenvoudige integratie van strategieën**: De **TransportPlanner** kan de juiste strategie kiezen voor het plannen van het vervoer, afhankelijk van de voorkeuren van de gebruiker.
- **Bevordering van codehergebruik**: Door de abstractie van vervoersopties kunnen verschillende implementaties van **TransportOption** onafhankelijk van elkaar worden ontwikkeld en hergebruikt.

In conclusie, de toepassing van de **Strategy Pattern** in dit ontwerp maakt het systeem flexibeler, onderhoudbaarder en eenvoudiger uit te breiden met nieuwe vervoersopties.
