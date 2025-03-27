# Dependency Inversion Principle (DIP)

## 1. Definitie van het Principe:
Het **Dependency Inversion Principle** stelt dat:
- Hoge-niveau modules mogen **niet** afhankelijk zijn van lage-niveau modules.
- Beide moeten afhankelijk zijn van **abstracties** (zoals interfaces).
- Abstracties mogen **niet** afhankelijk zijn van details; de **details** moeten afhankelijk zijn van abstracties.

## 2. Consequenties van het Toepassen van DIP:
- **Flexibiliteit:** Door abstracties te gebruiken, kun je eenvoudig de implementatie van bijvoorbeeld een database of externe service wijzigen zonder impact op de rest van de applicatie.
- **Testbaarheid:** Makkelijker testen doordat je mock- of stub-objecten kunt gebruiken in plaats van concrete implementaties.
- **Minder afhankelijkheden:** Het vermindert de afhankelijkheden tussen verschillende onderdelen van het systeem, wat onderhoud vergemakkelijkt.
- **Herbruikbaarheid:** Abstracties kunnen hergebruikt worden in andere toepassingen of contexten zonder dat er veel wijzigingen nodig zijn aan de onderliggende implementaties.

## 3. Eigen Codevoorbeeld:

### Zonder DIP (directe afhankelijkheid van een specifieke implementatie):

```java
class EmailService {
    public void sendEmail(String message) {
        // Email versturen via een specifieke provider
    }
}

class UserRegistration {
    private EmailService emailService;

    public UserRegistration() {
        this.emailService = new EmailService();  // Directe afhankelijkheid van EmailService
    }

    public void registerUser(String user) {
        // Gebruiker registreren en bevestigingsmail sturen
        emailService.sendEmail("Welcome " + user);
    }
}


