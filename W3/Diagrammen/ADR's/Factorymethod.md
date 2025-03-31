### 8.3. ADR: Gebruik van Factory Method voor uitbreidbare bouwstenen

**Datum:** 2025-03-21

#### Context

Binnen het Triptop-project willen we een systeem ontwerpen waarin gebruikers hun reis kunnen opbouwen uit verschillende bouwstenen, zoals overnachtingen, vervoer, excursies, enzovoort. Eén van de belangrijkste eisen is dat dit systeem **gemakkelijk uitbreidbaar** moet zijn met nieuwe soorten bouwstenen in de toekomst, zonder dat bestaande code herschreven hoeft te worden.

We willen deze uitbreidbaarheid op een nette, onderhoudbare manier realiseren. Dit betekent: lage koppeling tussen componenten, herbruikbaarheid van code, en het vermijden van duplicatie.

Deze ontwerpbeslissing speelt zich af in de context van het quality attribute **modifiability**, waarbij het belangrijk is dat nieuwe functionaliteit eenvoudig toegevoegd kan worden, zonder bestaande logica te breken of te herschrijven.

---

#### Considered Options

We hebben verschillende design patterns overwogen om deze uitbreidbaarheid te realiseren:

- **State Pattern**: Dit patroon is vooral handig voor het beheren van toestanden binnen een object. Hoewel nuttig voor statusbeheer, biedt het weinig voordelen bij het toevoegen van compleet nieuwe bouwstenen.

- **Strategy Pattern**: Zeer geschikt voor het verwisselen van algoritmes of gedrag op runtime. Dit patroon helpt bij het variëren van gedrag, maar richt zich niet direct op het aanmaken van nieuwe objecten of bouwstenen.

- **Adapter Pattern**: Dit patroon is waardevol voor integratie met externe APIs die een ander formaat of interface gebruiken. Het ondersteunt interoperabiliteit, maar niet specifiek de creatie van nieuwe domeinobjecten.

- **Facade Pattern**: Dit patroon maakt een subsysteem eenvoudiger te gebruiken door een vereenvoudigde interface aan te bieden. Het is nuttig voor gebruiksgemak, maar biedt weinig ondersteuning voor uitbreidbare objectcreatie.

- **Factory Method Pattern**: Dit patroon biedt een manier om objecten te creëren zonder direct afhankelijk te zijn van hun concrete klassen. Nieuwe objecttypen kunnen eenvoudig toegevoegd worden door een subklasse toe te voegen zonder de bestaande fabriek of clientcode aan te passen.

---

#### Decision

We kiezen voor het **Factory Method Pattern** om de creatie van bouwstenen te structureren. Dit maakt het mogelijk om nieuwe typen bouwstenen (zoals bijvoorbeeld een 'Wellness-arrangement' of 'Lokale gids') toe te voegen zonder bestaande code te hoeven aanpassen.

We implementeren een centrale `BouwsteenFactory`, die bepaalt welk type object wordt aangemaakt op basis van input (bijvoorbeeld type, locatie of ID). Elke bouwsteensoort krijgt zijn eigen klasse die een gedeelde interface implementeert. Deze aanpak sluit goed aan op onze behoefte aan flexibiliteit en schaalbaarheid.

---

#### Status

**Status:** Accepted

---

#### Consequences

De keuze voor het Factory Method Pattern heeft de volgende gevolgen:

- **Positief**:
    - De applicatie wordt makkelijker uit te breiden met nieuwe bouwstenen.
    - We houden de codebase modulair en overzichtelijk.
    - Bestaande functionaliteit blijft intact bij uitbreidingen.

- **Negatief**:
    - Er moet voor elke nieuwe bouwsteensoort een aparte klasse worden gemaakt.
    - De introductie van extra abstracties (zoals een interface en subklassen) kan de leercurve voor nieuwe ontwikkelaars iets verhogen.

Al met al wegen de voordelen van flexibiliteit, loskoppeling en onderhoudbaarheid zwaarder dan de extra complexiteit.

---

#### Bronnen

- [Refactoring Guru – Factory Method](https://refactoring.guru/design-patterns/factory-method)
- [Software-Design-Patterns.pptx (SOEX)](https://aim-ene.github.io/soex/assets/files/Software-Design-Patterns-0d2fdea120bb6494d39f949233e45cc5.pptx)
