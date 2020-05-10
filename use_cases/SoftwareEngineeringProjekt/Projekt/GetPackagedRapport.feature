#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Faa en samlet rapport af projektet
  
  @tag1
  Scenario: Brugeren oensker en samlet rapport af projektet "projekt"
    Given At projektet "projekt" eksisterer
    When Brugeren efterspoeger en samlet rapport af projekt "projekt" med en tilknyttet aktivitet "aktivitet"
    Then En samlet rapport af projektet "projekt" genereres og retuneres
  


