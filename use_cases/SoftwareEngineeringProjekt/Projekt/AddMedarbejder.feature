#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Tilfoej en medarbejder til et projekt

  @tag1
  Scenario: Der tilfoejes en medarbejder til et eksisterende projekt "projekt"
    Given At projektet "projekt" eksisterer
    And Medarbejderen "medarbjeder" ikke allerede er tilknyttet projektet "projekt"
    When En medarbjeder tilfoejes til et projekt "projekt"
    Then Medarbejderen er nu tilknyttet projekt "projekt"
