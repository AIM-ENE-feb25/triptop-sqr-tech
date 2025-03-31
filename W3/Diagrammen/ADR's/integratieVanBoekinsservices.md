### 8.4. ADR-004: Integratie van boekingsservices via Adapter Pattern

**Datum:** 2025-03-21

#### Context

Triptop integreert meerdere boekingsservices, waaronder Booking.com en interne boekingssystemen. Elk van deze services heeft een eigen API-structuur, manier van communiceren en formaat van gegevens. Deze verschillen zorgen voor technische complexiteit in de applicatie, zeker wanneer we meerdere diensten willen ondersteunen die niet dezelfde interface of response-structuur hanteren.

Daarnaast is het belangrijk dat we in de toekomst eenvoudig nieuwe boekingsservices kunnen toevoegen, zonder bestaande code te breken of aan te passen. De oplossing moet dus uitbreidbaar zijn én zorgen voor duidelijke scheiding tussen interne logica en externe systemen. Deze context speelt zich af binnen het quality attribute **interoperability**, maar raakt ook aan **modifiability**.

---

#### Considered Options

We hebben verschillende design patterns overwogen om dit probleem op te lossen:

- **State Pattern**: Dit patroon richt zich vooral op het beheren van de interne status van een object. Hoewel handig voor het regelen van toestandsveranderingen, biedt het weinig ondersteuning voor het integreren van externe services.

- **Strategy Pattern**: Dit patroon maakt het mogelijk om verschillende algoritmes uitwisselbaar toe te passen. Het is nuttig wanneer verschillende logica gekozen moet worden op runtime, maar niet specifiek gericht op integratie van systemen met een verschillende interface.

- **Adapter Pattern**: Dit patroon maakt het mogelijk om klassen met een ander interface tóch te laten samenwerken. Voor elke externe boekingsservice kan een adapter worden gemaakt die een gemeenschappelijk interface implementeert. Zo kunnen we intern werken met een eenduidige structuur, terwijl de externe verschillen worden afgevangen.

- **Facade Pattern**: Dit patroon biedt één vereenvoudigde toegang tot een complex subsysteem. Hoewel het de leesbaarheid verhoogt, lost het het probleem van verschillende interfaces niet op.

- **Factory Method**: Een patroon gericht op het flexibel aanmaken van objecten. Het zou deels toepasbaar kunnen zijn, maar biedt minder directe voordelen voor het transformeren of aanpassen van inkomende dataformaten.

---

#### Decision

We hebben besloten om het **Adapter Pattern** toe te passen voor de integratie van verschillende boekingsservices. Iedere externe service krijgt een eigen adapterklasse die een gedeelde interface implementeert, bijvoorbeeld `IBookingServiceAdapter`. De interne logica van Triptop werkt uitsluitend met deze interface, en hoeft daardoor niet te weten hoe de onderliggende service precies werkt.

Op deze manier kunnen we makkelijk een nieuwe boekingsservice toevoegen door alleen een nieuwe adapter te schrijven, zonder dat we bestaande logica of klassen hoeven aan te passen. Dit maakt de applicatie onderhoudbaar én uitbreidbaar.

---

#### Status

Accepted

---

#### Consequences

Door deze keuze kunnen we externe systemen integreren zonder afhankelijk te zijn van hun specifieke structuur of gedrag. Dit zorgt voor:

- **Positieve gevolgen**:
    - Nieuwe boekingsservices kunnen eenvoudig toegevoegd worden.
    - De interne code blijft schoon, overzichtelijk en losgekoppeld van externe APIs.
    - De leesbaarheid van de code verbetert doordat alle services via een gestandaardiseerde interface worden aangesproken.

- **Negatieve gevolgen**:
    - Voor elke nieuwe service moet een aparte adapter geschreven en onderhouden worden.
    - Bij grote verschillen tussen externe services kan de adaptercomplexiteit toenemen.
    - Er ontstaat mogelijk een grotere hoeveelheid klassen die beheerd moeten worden.

Toch wegen de voordelen zwaarder dan de nadelen, zeker gezien de schaalbaarheid en flexibiliteit die dit patroon ons biedt.

---

#### Bronnen

- [Refactoring Guru – Adapter Pattern](https://refactoring.guru/design-patterns/adapter)
- [Software-Design-Patterns.pptx – SOEX](https://aim-ene.github.io/soex/assets/files/Software-Design-Patterns-0d2fdea120bb6494d39f949233
