# ADR – Solution Exploration: Strategy Pattern voor vervoer in Triptop

**Titel:** Verkenning van het Strategy Pattern voor vervoer tussen overnachtingen  
**Status:** In onderzoek  
**Datum:** 28 maart 2025  
**Auteur:** Rick Schoenmaker  
**Onderdeel van:** Les 3 – Vervoer tussen Overnachtingen (Triptop)

---

## 1. Context

Triptop is een applicatie waarmee gebruikers zelf hun vakantietrip kunnen plannen. Een belangrijk onderdeel hiervan is het plannen van vervoer tussen overnachtingen. Reizigers moeten kunnen kiezen uit meerdere vervoersopties zoals auto, trein, vleigtuig of boot, en deze moeten afzonderlijk kunnen worden gepland en geboekt.

Elke vervoersvorm heeft:
- een eigen manier van route bepalen
- een eigen prijsbepaling
- en een specifieke boekingslogica

Het systeem moet uitbreidbaar zijn, makkelijk te onderhouden, en goed te testen. We kijken daarom naar architectuur opties die deze eigenschappen ondersteunen.

---

## 2. Ontwerpvraag

**Hoe zorgen we ervoor dat `TransportPlanner` flexibel omgaat met verschillende vormen van vervoer, zonder directe afhankelijkheid van concrete implementaties zoals `CarTransport` of `TrainTransport`? etc**

---

## 3. Considered Options

###  Optie 1: Strategy Pattern via `TransportOption` interface

- `TransportOption` is een interface die de gedeelde logica van transport definieert.
- Concrete klassen zoals `CarTransport`, `TrainTransport` en `BoatTransport` implementeren deze interface.
- `TransportPlanner` gebruikt polymorfisme om een transportopte te kiezen en aan te spreken.

**Voordelen:**
- Volgt *Open/Closed Principle* en *DIP*.
- Eenvoudig uit te breiden met nieuwe vormen van vervoer.
- Goed testbaar via mocks van de interface.
- Losse koppeling tussen planner en transportvormen.

**Nadelen:**
- Extra abstractielaag.
- Strategie-keuze moet elders worden opgelost (bijv. via configuratie).

---

###  Optie 2: `if`/`switch` in `TransportPlanner`

- `TransportPlanner` bevat alle logica en kiest zelf via `if` of `switch`-statements wat voor transport gebruikt wordt.

**Voordelen:**
- Simpel in kleine systemen.

**Nadelen:**
- Slecht schaalbaar en onderhoudbaar.
- Schending van meerdere design principles (SRP, OCP).
- Niet testbaar per transportoptie.

---

###  Optie 3: Factory Pattern + interface

- Een aparte `TransportFactory` levert een concrete `TransportOption` op basis van invoer.
- Combineerbaar met Strategy Pattern.

**Voordelen:**
- Scheiding tussen creatie en gebruik.
- Goed bij gebruik van gebruikersvoorkeuren of externe data.

**Nadelen:**
- Complexer ontwerp.
- Factory moet worden beheerd/configureerbaar gemaakt.

---

## 4. Class/Component Diagram (Illustratie van Optie 1)

Onderstaande diagram toont hoe het Strategy Pattern wordt toegepast in het transportontwerp van Triptop:

```plantuml
@startuml
!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Component.puml

Person(user, "Gebruiker", "Gebruikt Triptop om vervoer tussen overnachtingen te plannen")

System_Boundary(transportSystem, "Transport System") {

  Container(controller, "TransportPlanner Controller", "Java", 
    "Plant vervoersopties tussen overnachtingen en coördineert strategieën")

  Container(service, "CarTransport", "Java", 
    "Implementeert vervoer per auto: route, prijs en boeking")

  Container(service, "TrainTransport", "Java", 
    "Implementeert vervoer per trein: route, prijs en boeking")

  Container(service, "BootTransport", "Java", 
    "Implementeert vervoer per boot: route, prijs en boeking")

  Container(interface, "TransportOption Interface", "Java Interface", 
    "Interface met getRoute(), getPrice(), book()")

  Container(service, "TransportTracker Service", "Java", 
    "Beheert de status van transport: gepland, geboekt, betaald")
}

Rel(user, controller, "Vraagt vervoer aan via planTransport(from, to)")
Rel(controller, interface, "Gebruikt als interface voor opties")
Rel(controller, service, "Roept concrete optie aan (Car/Train/Boat)")
Rel(service, service, "Stelt status in via TransportTracker")
@enduml

```
## 5. Resultaat en vervolgstappen
Deze oplossingsverkenning laat zien dat het Strategy Pattern de best passende optie is voor het plannen van vervoer binnen Triptop, omdat zijn uitbreidbaarheid, testbaarheid en onderhoudsgemak meer kwaliteit bied.

Deze optie is technisch haalbaar en sluit aan op ontwerpprincipes, maar de definitieve keuze wordt in een volgende fase vastgelegd.