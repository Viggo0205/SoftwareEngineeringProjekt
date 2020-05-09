#Skrevet af Victor Tadeusz Ulsturp Olszowski s194281

@tag
Feature: Timer kan registres til en arbejdsdag
  Description: timer kan registreres paa hvad end du har lavet den dag f.eks. paa en aktivitet

  @tag1
#Main scenario
  Scenario: Bruger tilfoejer tid til en given arbejdsdag
    Given Brugeren er tilknyttet det givende aktivitet "aktivitet"
    When bruger tilfoejer halvetimer 4 til given arbejdsdag, projekt "projekt" og aktivitet "aktivitet"
    Then timer er registreret paa given arbejdsdag og der bliver noteret projekt, aktivtet og tiden der er registrert til dagen printes
    """
    Arbejdstider for: 1-2-2020
    projekt
    aktivitet: 4
    Totaltid: 4
    """