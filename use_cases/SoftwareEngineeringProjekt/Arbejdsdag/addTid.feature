#Skrevet af Victor Tadeusz Ulsturp Olszowski s194281

@tag
Feature: Timer kan registres til en arbejdsdag
  Description: timer kan registreres paa hvad end du har lavet den dag f.eks. paa en aktivitet
#Main scenario
  @tag1
  Scenario: Bruger tilfoejer tid til en given arbejdsdag
    Given en arbejdsdag eksisterer
    When bruger tilfoejer halvetimer 4 til given arbejdsdag, projekt "projekt" og aktivitet "aktivitet"
    Then timer er registreret paa given arbejdsdag og der bliver noteret projekt, aktivtet og tiden der er registrert til dagen printes
    """
    Arbejdstider for: 1-2-2020
    projekt
    aktivitet: 4
    Totaltid: 4
    """
   @tag2
  Scenario:  Bruger retter timer for allerede eksisterende aktivitet på en given arbejdsdag
    Given en arbejdsdag eksisterer
    And arbejdsdag som modtager projekt "projekt" aktivitet "aktivitet" og en maengde af tid i halvetimer 4 allerede har tilfoejet tid
    When bruger tilfoejer halvetimer 8 til given arbejdsdag, projekt "projekt" og aktivitet "aktivitet"
    Then timer er registreret paa given arbejdsdag og der bliver noteret projekt, aktivtet og tiden der er registrert til dagen printes
    """
    Arbejdstider for: 1-2-2020
    projekt
    aktivitet: 8
    Totaltid: 8
    """
  @tag3
  Scenario:  Bruger tilfoejer tid til en given arbejdsdag hvor projekt allerede har tid tilfoejet
    Given en arbejdsdag eksisterer
    And arbejdsdag som modtager projekt "projekt" aktivitet "aktivitet" og en maengde af tid i halvetimer 4 allerede har tilfoejet tid
    When bruger tilfoejer halvetimer 4 til given arbejdsdag, projekt "projekt" og en anden aktivitet "aktivitet2"
    Then timer er registreret paa given arbejdsdag og der bliver noteret projekt, aktivtet og tiden der er registrert til dagen printes
    """
    Arbejdstider for: 1-2-2020
    projekt
    aktivitet: 4
    aktivitet2: 4
    Totaltid: 8
    """