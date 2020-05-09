Feature: Henter tid brugt på en given arbejdsdag
  Description: Finder tiden fra en arbejdsdag

  Scenario: Bruger forsoeger at hente maengden af tid brugt på en given arbejdsdag
    Given Dagen Arbejdsdag har timer tilknyttet
    When getTid bruges på den givene dag
    Then Saa bliver tiden printet Arbejdsdagen har + 4