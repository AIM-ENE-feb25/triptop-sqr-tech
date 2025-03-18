@startuml C4_Context
!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Context.puml

' Definieer de personen
Person(User, "Reiziger", "Stelt zelf een reis samen en boekt deze")
Person(Agent, "Tweede-lijns Reisagent", "Ondersteunt reizigers bij hun reisplanning")
Person(IDP, "Identity Provider", "Verifieert de identiteit van gebruikers via Google, Microsoft, Airbnb")

' Definieer het systeem (Triptop)
System(TriptopApp, "Triptop Vakantieplan App", "Biedt een platform voor het plannen en boeken van reizen")

' Definieer externe systemen
System_Ext(Accommodation, "Overnachtingen", "Externe aanbieders zoals Booking, Airbnb en eigen beheer")
System_Ext(Transport, "Vervoer", "Trein (NS, Deutsche Bahn), vliegtuig (KLM), veerdienst")
System_Ext(CarRental, "Autohuur", "Autoverhuur via Sixt, Hertz")
System_Ext(Activities, "Excursies", "Excursies en activiteiten via GetYourGuide, Tripadvisor")
System_Ext(Food, "Eten & Drinken", "Restaurants en bezorgdiensten via Takeaway, Eet.nu")
System_Ext(Payment, "Betaalsysteem", "Betalingsdiensten via iDEAL, Creditcard, PayPal")

' Relaties tussen de componenten
Rel(User, IDP, "Login via Google, Microsoft, Airbnb", "OAuth")
Rel(User, TriptopApp, "Zelf reizen plannen, boeken, wijzigen en annuleren")
Rel(Agent, TriptopApp, "Biedt ondersteuning bij reisplanning")
Rel(TriptopApp, IDP, "Authenticatie aanvragen voor gebruikerslogin")
Rel(TriptopApp, Accommodation, "Boekt en beheert overnachtingen")
Rel(TriptopApp, Transport, "Boekt en beheert transportopties")
Rel(TriptopApp, CarRental, "Boekt en beheert autoverhuur")
Rel(TriptopApp, Activities, "Boekt en beheert excursies")
Rel(TriptopApp, Food, "Regelt eet- en drinkopties")
Rel(TriptopApp, Payment, "Verwerkt betalingen voor boekingen")

@enduml
