# Kwaliteitseisen voor een Container Diagram

Naast de voorwaarden uit de [C4 checklist](https://c4model.com/diagrams/checklist) gelden de volgende aanvullende eisen:

## Titel
- De titel volgt dit formaat: **"Container diagram van ... voor het ... systeem"**.

## Regels voor Personen en Systemen
- Dezelfde eisen als bij het [contextdiagram](https://aim-ene.github.io/soex/week-1/les-1/Lesprogramma).
- De gebruiker interageert alleen met containers binnen het systeem.
- Externe systemen zonder interactie worden weggelaten.

## Systeemgrens
- Bevat alleen containers.
- Titel van de systeemgrens is gelijk aan de naam van het systeem uit het contextdiagram.

## Container-Specificaties
- Een container moet een **naam, beschrijving en implementatietechnologie** hebben.
- **Naam**: Wat de container is en waarvoor hij dient.
- **Beschrijving**: Wat de container doet en zijn verantwoordelijkheden.
- **Implementatietechnologie**: Bijvoorbeeld Java, JavaScript, Spring Boot.
- Containers zonder interactie kunnen worden weggelaten.
- Containers zijn zelfstandig te deployen en draaien als een proces binnen het systeem.

## Interactie-Vereisten
- Interactie is alleen toegestaan tussen:
    - Persoon en containers.
    - Containers onderling.
    - Container en systeem.
- **Geen zelfverwijzingen**.
- Interactie moet het **doel** en **technische details** beschrijven:
    - Communicatiestijl (synchroon, asynchroon).
    - Mechanisme (REST, WebSockets, API's).
    - Protocollen (HTTP, HTTPS).
    - Dataformaten (JSON, XML).
    - Poortnummers.

## Leesbaarheid & Ordening
- Gebruik relevante iconen voor containers (bijv. database, webserver).
- Technologieën van containers zijn correct en bekend.
- Diagram is leesbaar van **boven naar beneden**.
- Containers zijn logisch geordend, bijvoorbeeld:
    - Persoon → Browser → Webserver → Database.

## Boundaries
- Boundaries hebben **geen relaties** en moeten **zelfbeschrijvend** zijn.
- **Houd het simpel** (KISS-principe).
