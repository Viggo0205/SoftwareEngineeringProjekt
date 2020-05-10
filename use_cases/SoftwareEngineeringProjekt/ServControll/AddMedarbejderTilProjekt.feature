#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Tilfoej medarbejder til projekt paa serverniveau

  @tag1
  Scenario: En eksisterende medarbejder tilfoejes til et eksisterende projekt
    Given Serveren koerer
    And Der eksisterer et projekt "projekt"
    And En medarbejder med initialerne "INIT" eksisterer
    When Medarbejderen med initialerne "INIT" tilfoejes til projektet "2020000001"
    Then Medarbejderen med initialerne "INIT" er en del af projektet "2020000001"