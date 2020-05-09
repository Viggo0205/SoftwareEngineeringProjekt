#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Saetter den uge projektet startes i

  @tag1
  Scenario: Projektets "projekt" start uge indskrives
    Given At projektet "projekt" eksisterer
    #And At projektet "projekt" ikke allerede har en start uge
    When Projektet "projekt" faar en start uge
    Then Projektet "projekt" har en start uge

