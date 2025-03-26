# Composition above Inheritance

## Wat is Composition over Inheritance?
- Een ontwerpprincipe dat de voorkeur geeft aan objectsamenstelling boven klasse-overerving
- Bouwt systemen door eenvoudigere objecten te combineren in plaats van complexe overervingshiërarchieën te creëren
- Benadrukt "heeft-een" relaties boven "is-een" relaties

## Waarom Kiezen voor Composition?
- **Flexibiliteit**: Gedrag kan tijdens uitvoering worden gewijzigd door componenten te verwisselen
- **Verminderde koppeling**: Objecten blijven onafhankelijk van elkaar
- **Eenvoudiger onderhoud**: Wijzigingen aan één component veroorzaken geen cascade-effect door de hiërarchie
- **Betere testbaarheid**: Componenten kunnen afzonderlijk worden getest

## Problemen met Inheritance
- **Sterke koppeling**: Childclasses zijn afhankelijk van implementatiedetails van de parent
- **Kwetsbare basisklasse-probleem**: Wijzigingen in de parent class kunnen child classes breken
- **Opgeblazen overervingshiërarchie**: Complexe hiërarchieën worden moeilijk te begrijpen

## Voorbeeld

```java
abstract class Voertuig {
    public void starten() { /* ... */ }
    public void rijden() { /* ... */ }
}

class Auto extends Voertuig {
    public void toeteren() { /* ... */ }
}

class Raceauto extends Auto {
    public void turboAanzetten() { /* ... */ }
}

// Probleem: wat als we een Vrachtwagen willen die kan toeteren maar geen turbo heeft?
```

```java
// SAMENSTELLING AANPAK (BETER)
interface Motor {
    void starten();
}

class BrandstofMotor implements Motor {
    public void starten() { System.out.println("Motor start met brandstof..."); }
}

class ElektrischeMotor implements Motor {
    public void starten() { System.out.println("Elektromotor start geruisloos..."); }
}

interface Geluidssysteem {
    void geluidMaken();
}

class Claxon implements Geluidssysteem {
    public void geluidMaken() { System.out.println("Toet toet!"); }
}

class Voertuig {
    private Motor motor;
    private Geluidssysteem geluidssysteem;
    
    public Voertuig(Motor motor, Geluidssysteem geluidssysteem) {
        this.motor = motor;
        this.geluidssysteem = geluidssysteem;
    }
    
    public void starten() {
        motor.starten();
    }
    
    public void geluidMaken() {
        geluidssysteem.geluidMaken();
    }
}

// Nu kunnen we flexibel voertuigen samenstellen:
// Auto auto = new Voertuig(new BrandstofMotor(), new Claxon());
// ElektrischeAuto eAuto = new Voertuig(new ElektrischeMotor(), new Claxon());
```

## Wanneer Overerving Gebruiken
- Duidelijke "is-een" relaties die waarschijnlijk niet zullen veranderen
- Hergebruik van code in een beperkt domein
- Wanneer gedeeld gedrag fundamenteel is voor de identiteit

## Best Practices
- Kies standaard voor samenstelling boven overerving
- Gebruik interfaces om gedragscontracten te definiëren
- Overweeg het Strategie-patroon voor verwisselbaar gedrag
- Geef de voorkeur aan delegatie boven overerving
- Houd basisklassen eenvoudig en gericht

## Voordelen in Spring Boot
- Spring's dependency injection stimuleert samenstelling
- Components, Services en Repositories worden samengesteld in plaats van overgeërfd
- Gemakkelijker te testen met mocks en stubs
- Flexibelere architectuur