@startuml
skinparam backgroundColor #F5F5F5
skinparam rectangle {
BackgroundColor<<Triptop>> #ADD8E6
BackgroundColor<<Services>> #FFEB3B
BackgroundColor<<Accommodation>> #FFCDD2
BackgroundColor<<Transport>> #C8E6C9
BackgroundColor<<CarRental>> #D1C4E9
BackgroundColor<<Activities>> #FFF9C4
BackgroundColor<<Food>> #FFECB3
BackgroundColor<<Payment>> #B3E5FC
}

actor "Reiziger" as User
actor "Tweede-lijns Reisagent" as Agent
actor "Identity Provider" as IDP

rectangle "Triptop Vakantieplan App" <<Triptop>> {
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

database "Externe Services" as Services <<Services>> {
rectangle "Overnachtingen" as Accommodation <<Accommodation>> {
[Booking]
[Airbnb]
[Eigen beheer]
}
rectangle "Vervoer" as Transport <<Transport>> {
[NS]
[Deutsche Bahn]
[KLM]
[Google Maps]
[Veerdienst]
}
rectangle "Autohuur" as CarRental <<CarRental>> {
[Sixt]
[Hertz]
}
rectangle "Excursies" as Activities <<Activities>> {
[GetYourGuide]
[Tripadvisor]
}
rectangle "Eten & Drinken" as Food <<Food>> {
[Takeaway]
[Eet.nu]
}
rectangle "Betaalsysteem" as Payment <<Payment>> {
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