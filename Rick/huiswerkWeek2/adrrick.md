# ADR – Solution Exploration: Strategy Pattern voor vervoer in Triptop

**Titel:** Verkenning van het Strategy Pattern voor vervoer tussen overnachtingen  
**Status:** In onderzoek  
**Datum:** 28 maart 2025  
**Auteur:** [Jouw naam]  
**Onderdeel van:** Les 3 – Vervoer tussen Overnachtingen (Triptop)

---

## 1. Context

Triptop is een applicatie waarmee gebruikers zelf hun vakantietrip kunnen plannen. Een belangrijk onderdeel hiervan is het plannen van vervoer tussen overnachtingen. Reizigers moeten kunnen kiezen uit meerdere vervoersopties zoals auto, trein of boot, en deze moeten afzonderlijk kunnen worden gepland, geboekt en gevolgd.

Elke vervoersvorm heeft:
- een eigen manier van route bepalen (`getRoute()`)
- een eigen prijsbepaling (`getPrice()`)
- en een specifieke boekingslogica (`book()`)

Het systeem moet uitbreidbaar zijn, makkelijk te onderhouden, en goed te testen. We verkennen daarom architectuurpatronen die deze eigenschappen ondersteunen.

---

## 2. Ontwerpvraag

**Hoe zorgen we ervoor dat `TransportPlanner` flexibel omgaat met verschillende vormen van vervoer, zonder directe afhankelijkheid van concrete implementaties zoals `CarTransport` of `TrainTransport`?**

---

## 3. Considered Options

###  Optie 1: Strategy Pattern via `TransportOption` interface

- `TransportOption` is een interface die de gedeelde logica van transport definieert.
- Concrete klassen zoals `CarTransport`, `TrainTransport` en `BootTransport` implementeren deze interface.
- `TransportPlanner` gebruikt polymorfisme om een transportoptie te kiezen en aan te spreken.

**Voordelen:**
- Volgt *Open/Closed Principle* en *DIP*.
- Eenvoudig uit te breiden met nieuwe vormen van vervoer.
- Goed testbaar via mocks van de interface.
- Losse koppeling tussen planner en transportvormen.

**Nadelen:**
- Extra abstractielaag.
- Strategie-keuze moet elders worden opgelost (bijv. via Factory of configuratie).

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
