#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Saetter den uge projektet afsluttes i

  @tag1
  Scenario: Projektets "projekt" start uge indskrives
    Given At projektet "projekt" eksisterer
    #And At projektet "projekt" ikke allerede har en slut uge
    When Projektet "projekt" faar en slut uge
    Then Projektet "projekt" har en slut uge

