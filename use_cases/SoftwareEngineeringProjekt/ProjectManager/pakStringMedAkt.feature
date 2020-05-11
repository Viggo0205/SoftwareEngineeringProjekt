# Skrevet af Rasmus Nyhus
@tag
Feature: Pakker alle projekter som string til klienten

  @tag1
  Scenario: Der kaldes efter en string ";2020000000|projekt" dannet af projekter
    Given Projektmanageren eksisterer
    And Der findes mindst et Project "projekt" i ProjectManager med indeks 0 
    When Der efterspoerges en string ";2020000000|projekt" 
    Then der er returnet en string ";2020000000|projekt" 