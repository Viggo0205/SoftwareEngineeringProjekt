#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Tilknytter en leder til projekt "projekt"

  @tag1
  Scenario: Der tilknyttes en leder til et projekt "projekt"
    Given At projektet "projekt" eksisterer
    #And At projektet "projekt" ikke allerede har en leder
    When En leder "BigG" tilknyttes projektet "projekt"
    Then En leder "BigG" er nu tilknyttet projektet "projekt"


