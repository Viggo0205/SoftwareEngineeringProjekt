Feature: Timer kan registres til en arbejdsdag
  Description: timer kan registreres på hvad end du har lavet den dag f.eks. på en aktivitet

#Main scenario
  Scenario: Bruger tilfoejer tid til en given arbejdsdag
    Given Bruger er logget ind med gyldige "initialer"
    And Brugeren er tilknyttet det givende aktivitet "aktivitet"
    When bruger tilfoejer timer "4" til given arbejdsdag og aktivitet "aktivitet"
    Then timer er registreret på given arbejdsdag og der bliver noteret projekt "projekt" og aktivitet "aktivitet"