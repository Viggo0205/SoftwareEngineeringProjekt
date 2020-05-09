#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Tilfoej en aktivitet til et projekt
  
  @tag1
  Scenario: Der tilfoejes en aktivitet til et eksisterende projekt
    Given At projektet "projekt" eksisterer
    When En aktivitet "aktivitet" er tilfoejet til et projekt "projekt"
    #And Aktiviteten modtager et navn
    Then Aktiviteten "aktivitet" er tilfoejet til det oenskede projekt "projekt"
  

