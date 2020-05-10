# Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: At tilfoeje nye projekter

  @tag1
  Scenario: Der er plads til flere projekter dette aar, og der eksisterer ikke projekter endnu
    Given Serveren koerer
    When Et nyt projekt "projekt" forsoeges tilfoejet
    Then Projektet "projekt" findes i serverens projektManager


  @tag2
  Scenario: Der er ikke plads til flere projekter dette aar
    Given Serveren koerer
    And Der er allerede oprettet 1000000 projekter dette aar
    When Et nyt projekt "projekt" forsoeges tilfoejet
    Then En error "java.lang.NullPointerException: No more room for projects this year" modtages
    
    @tag3
  Scenario: Der er plads til flere projekter dette aar, og der eksisterer allerede projekter
    Given Serveren koerer
    And Der er allerede oprettet 2 projekter dette aar
    And Det nuvaerende aar overgaar til et nyt
    When Et nyt projekt "projekt" forsoeges tilfoejet
    Then Projektet har ID'et ved aarstallet og det foerste nummer for det paagaeldende aar