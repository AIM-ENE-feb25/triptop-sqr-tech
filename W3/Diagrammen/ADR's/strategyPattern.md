## 8.5. ADR: Verkenning van het Strategy Pattern voor vervoer tussen overnachtingen

#### Status
In onderzoek — 28 maart 2025  
**Auteur:** Rick Schoenmaker  
**Onderdeel van:** Les 3 – Vervoer tussen Overnachtingen (Triptop)

---

#### Context

Triptop is een applicatie waarmee    gebruikers hun vakantietrip kunnen samenstellen. Een essentieel onderdeel hiervan is het plannen van vervoer tussen overnachtingen. Gebruikers moeten kunnen kiezen uit verschillende vervoersopties zoals auto, trein, vliegtuig of boot.

Elke vervoersvorm heeft zijn eigen logica voor het berekenen van routes, prijzen en het boeken van tickets. Deze verschillen maken het lastig om alle vormen op één uniforme manier te behandelen in de code.

Het systeem moet bovendien goed onderhoudbaar zijn, makkelijk uit te breiden met nieuwe vormen van transport, en eenvoudig te testen. We zoeken daarom een architectuuroplossing die voldoet aan de kwaliteitsattributen **modifiability**, **scalability** en **testability**.

---

#### Considered Options

### Optie 1: Strategy Pattern met een `TransportOption` interface

In deze optie wordt een interface (`TransportOption`) geïntroduceerd die de gedeelde functies van transport vastlegt, zoals `getRoute()`, `getPrice()` en `book()`. Elke concrete vervoersoptie (zoals `CarTransport`, `TrainTransport`, `BoatTransport`) implementeert deze interface.

De `TransportPlanner` maakt gebruik van deze interface en werkt via polymorfisme met het juiste vervoertype.

**Voordelen:**
- Ondersteunt het *Open/Closed Principle*: nieuwe vervoersvormen kunnen toegevoegd worden zonder bestaande code aan te passen.
- Maakt gebruik van het *Dependency Inversion Principle*: de planner is niet afhankelijk van concrete implementaties.
- Makkelijk te testen met behulp van mocks of stubs van de interface.
- Verhoogt herbruikbaarheid en flexibiliteit van de code.

**Nadelen:**
- Vereist een extra abstractielaag (de interface).
- De keuze van de juiste strategie (welk type transport) moet elders bepaald worden, bijvoorbeeld via een factory of configuratiebestand.

---

### Optie 2: `if`/`switch`-constructies binnen `TransportPlanner`

In deze aanpak bevat de `TransportPlanner` zelf alle logica en bepaalt via `if`- of `switch`-statements welk vervoertype gebruikt wordt.

**Voordelen:**
- Snel te implementeren voor eenvoudige of tijdelijke oplossingen.

**Nadelen:**
- Schendt het *Single Responsibility Principle* en *Open/Closed Principle*.
- Moeilijk onderhoudbaar bij uitbreiding (bijvoorbeeld nieuwe vervoersopties).
- Lastig testbaar per vervoersvorm omdat de logica samengevoegd is.
- Zorgt voor een starre architectuur en herhaling van code.

---

### Optie 3: Factory Pattern gecombineerd met interface

Deze optie gebruikt een `TransportFactory` die op basis van invoer (bijvoorbeeld gebruikerskeuze of data) het juiste `TransportOption` object teruggeeft. De factory werkt samen met het Strategy Pattern om de juiste implementatie in te zetten.

**Voordelen:**
- Duidelijke scheiding tussen objectcreatie en gebruik.
- Makkelijk uitbreidbaar met nieuwe vervoersopties.
- Logica over strategie-keuze zit op één centrale plek.

**Nadelen:**
- Iets complexer qua opzet en beheer.
- De factory moet goed geconfigureerd worden (bijvoorbeeld met registraties of mappings).

---

#### Decision

We geven de voorkeur aan **Optie 1: het Strategy Pattern met een gedeelde `TransportOption` interface**. Dit patroon maakt het mogelijk om flexibel met meerdere vervoersopties om te gaan, zonder directe afhankelijkheid van concrete klassen.

Elke vervoersvorm kan geïsoleerd worden ontwikkeld, getest en uitgebreid. De `TransportPlanner` blijft hierdoor schoon, overzichtelijk en toekomstbestendig. In een latere fase kan dit eventueel gecombineerd worden met een Factory voor automatische selectie van de juiste strategie.

---

#### Consequences

- **Uitbreidbaar**: Nieuwe vervoersopties kunnen eenvoudig worden toegevoegd zonder aanpassingen aan bestaande klassen.
- **Testbaar**: Iedere transportstrategie is afzonderlijk te testen.
- **Flexibel en onderhoudbaar**: Geen `if`/`switch`-blokken, en duidelijke scheiding van verantwoordelijkheden.
- **Complexiteit**: Iets meer code nodig door extra interface en implementatieklassen.
- **Strategiekeuze**: Er is aanvullende logica nodig om de juiste strategie te kiezen op basis van invoer (bijv. gebruikersvoorkeuren of bestemming).

---

#### Bronnen

- [Refactoring Guru – Strategy Pattern](https://refactoring.guru/design-patterns/strategy)
- [Software-Design-Patterns.pptx – SOEX](https://aim-ene.github.io/soex/assets/files/Software-Design-Patterns-0d2fdea120bb6494d39f949233e45cc5.pptx)
