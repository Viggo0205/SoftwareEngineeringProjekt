@tag
Feature: Timer kan registres til en arbejdsdag
  Description: timer kan registreres paa hvad end du har lavet den dag f.eks. paa en aktivitet

  @tag1
#Main scenario
  Scenario: Bruger tilfoejer tid til en given arbejdsdag
    Given Bruger er logget ind med gyldige "initialer"
    And Brugeren er tilknyttet det givende aktivitet "aktivitet"
    When bruger tilfoejer timer 4 til given arbejdsdag og aktivitet "aktivitet"
    Then timer er registreret paa given arbejdsdag og der bliver noteret projekt "projekt" og aktivitet "aktivitet"