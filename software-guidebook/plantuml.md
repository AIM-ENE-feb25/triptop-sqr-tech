@startuml C4_Context
!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Context.puml

' Definieer de personen
Person(User, "Reiziger", "Boekt en beheert reizen")
Person(Agent, "Tweede-lijns Reisagent", "Ondersteunt reizigers")
Person(IDP, "Identity Provider", "Verifieert gebruikersidentiteit")

' Definieer het systeem (Triptop)
System(TriptopApp, "Triptop Vakantieplan App", "Beheert reisplanning en boekingen")

' Definieer externe systemen
System_Ext(Services, "Externe Services", "Externe aanbieders voor reizen, accommodatie en betalingen")

' Relaties tussen de componenten
Rel(User, IDP, "Login met Google, Microsoft, Airbnb", "OAuth")
Rel(User, TriptopApp, "Beheert reizen en boekingen")
Rel(Agent, TriptopApp, "Biedt ondersteuning aan reizigers")
Rel(TriptopApp, Services, "Interactie met externe aanbieders voor boekingen en betalingen")
Rel(TriptopApp, IDP, "Aanvragen van gebruikersauthenticatie")

@enduml
