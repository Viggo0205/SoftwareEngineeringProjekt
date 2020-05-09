#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Projektets navn kan aendres

  @tag1
  Scenario: Navnet paa et projekt "projekt" aendres til "projekt2"
    Given At projektet "projekt" eksisterer
    And Projektet "projekt" allerede har et navn
    When Projektets "projekt" navn aendres til "projekt2"
    Then Projektets "projekt" navn opdateres til "projekt2"


