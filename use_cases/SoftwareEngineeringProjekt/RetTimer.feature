#clara s180350

Feature: <Rette regristrede timer> 
Description: Brugeren kan se og rette de registrerede timer
Action: Udviklere og udviklingsleder

#main scenarie
  Scenario: <Bruger oensker at rette registrerede timer>
    Given <Brugeren er logget ind og har indregistreret arbejdstimer>
    When <Brugeren er udviklingsleder eller udvikler>
    And <Bruger retter arbejdstimer>
    Then <Saa bliver arbejdstimer(ne) rettet og gemt>

#fail scenirie 1
  Scenario: <Angivet udgyldig registrerede timer>
    When <Bruger er udviklingsleder eller udvikler>
    And <Bruger retter ugyldige registrerede timer> 
    And <Angivet projektet eksisterer>
    Then <Print fejl besked "Du har forsoegt at rette ugyldige registrerede timer">

    