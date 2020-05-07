Feature: getDeltaDag
  Description: Udviklingsleder kan bestille ny aktivitet som er tilsluttet et projekt
  Actor: Udviklingsleder
#Main Scenario
  Scenario: Udviklingsleder bestiller ny aktivitet
    Given Brugeren er logget ind med gyldige initialer "ADM"
    When Bruger bestiller aktivitet og er udviklingsleder
    And Bruger tilfoejer gyldig tidsramme "tidsramme"
    And Bruger tilfoejer gyldig arbejdstimer "arbejdstimer"
    And Angivne projektet "projekt" eksisterer
    Then Saa bliver der bestilt at den nye aktvivitet bliver lavet
#Fail scenario 1
  Scenario: Brugeren ikke er udviklingsleder
    Given Brugeren er logget ind med gyldige initialer "ADM"
    When Bruger bestiller ny aktivitet, men er ikke udviklingsleder
    And Bruger tilfoejer tidsramme
    And Bruger tilfoejer arbejdstimer
    And Angivet projektet eksisterer
    Then Print fejl besked Du er ikke udviklingsleder
#Fail scenario 2
  Scenario: Angivet en ugyldig tidsramme
    Given Brugeren er logget ind med gyldige initialer "ADM"
    When Brugeren er udviklingsleder og tilfoejer en ugyldig tidsramme
    And Bruger tilfoejer tidsramme
    And Bruger tilfoejer arbejdstimer
    And Angivet projektet eksisterer
    Then Print fejl besked Du er ikke udviklingsleder