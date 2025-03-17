To make the diagram more advanced and reduce line crossings, we can rearrange the elements and use different types of connectors. Here is an updated version of the PlantUML diagram:

```plantuml
@startuml

actor "Reiziger" as User
actor "Tweede-lijns Reisagent" as Agent
actor "Identity Provider" as IDP

rectangle "Triptop Vakantieplan App" {
  (Reis Samenstellen) as CreateTrip
  (Boeken) as BookTrip
  (Annuleren) as CancelTrip
  (Wijzigen) as ModifyTrip
  (Betalen) as PayTrip
  (Reisstatus Bekijken) as ViewStatus
}

User --> IDP : "Login via Google, Microsoft, Airbnb"
User --> CreateTrip
User --> BookTrip
User --> CancelTrip
User --> ModifyTrip
User --> PayTrip
User --> ViewStatus

Agent --> ViewStatus : "Ondersteuning bij reisplanning"

database "Externe Services" as Services {
  rectangle "Overnachtingen" as Accommodation {
    [Booking]
    [Airbnb]
    [Eigen beheer]
  }
  rectangle "Vervoer" as Transport {
    [NS]
    [Deutsche Bahn]
    [KLM]
    [Google Maps]
    [Veerdienst]
  }
  rectangle "Autohuur" as CarRental {
    [Sixt]
    [Hertz]
  }
  rectangle "Excursies" as Activities {
    [GetYourGuide]
    [Tripadvisor]
  }
  rectangle "Eten & Drinken" as Food {
    [Takeaway]
    [Eet.nu]
  }
  rectangle "Betaalsysteem" as Payment {
    [iDEAL]
    [Creditcard]
    [PayPal]
  }
}

CreateTrip --> Accommodation
CreateTrip --> Transport
CreateTrip --> CarRental
CreateTrip --> Activities
CreateTrip --> Food

BookTrip --> Accommodation
BookTrip --> Transport
BookTrip --> CarRental
BookTrip --> Activities
BookTrip --> Food

PayTrip --> Payment

@enduml
```

This version organizes the external services into nested rectangles to reduce line crossings and improve readability.