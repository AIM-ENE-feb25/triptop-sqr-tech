# Huiswerk Les 3: Hoe regel ik het Vervoer tussen de Overnachtingen

## **Stap 1: Componenten en Verantwoordelijkheden**

- **TransportPlanner**: Kiest en plant vervoer tussen overnachtingen.
- **TransportOption**: Algemene vorm voor vervoer (auto, trein, boot).
- **CarTransport**: Regelt vervoer per auto.
- **TrainTransport**: Regelt vervoer per trein.
- **TransportTracker**: Houdt de status van vervoer bij (bijv. gepland, betaald).

## **Stap 2: Interfaces en Methodes**

### **TransportPlanner**
- **planTransport(from, to)**: Retourneert een **TransportOption**.

### **TransportOption** (interface)
- **getRoute()**: Retourneert een lijst van locaties (`List<Location>`).
- **getPrice()**: Retourneert de prijs van het transport (`float`).
- **book()**: Boekt het transport en retourneert een `boolean`.

### **CarTransport** / **TrainTransport** (implementaties van TransportOption)
- **getRoute()**: Retourneert de route voor de specifieke vervoersoptie.
- **getPrice()**: Retourneert de prijs voor de specifieke vervoersoptie.
- **book()**: Boekt het transport.

### **TransportTracker**
- **setStatus(id, status)**: Zet de status van het transport (`id` en `status`).
- **getStatus(id)**: Haalt de status op van het transport.

## **Stap 3: Volgorde van Aanroepen**

1. **Gebruiker**
    - Roept **TransportPlanner.planTransport(from, to)** aan.

2. **TransportPlanner**
    - Roept **CarTransport.getRoute()** en **CarTransport.getPrice()** aan.
    - Roept **TrainTransport.getRoute()** en **TrainTransport.getPrice()** aan.

3. **Gebruiker** kiest de beste **TransportOption**.

4. **TransportOption** (bijvoorbeeld **CarTransport** of **TrainTransport**) roept **book()** aan om het transport te boeken.
