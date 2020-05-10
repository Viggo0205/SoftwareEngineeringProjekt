#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Tilfoej medarbejder til aktivitet paa serverniveau

  @tag1
  Scenario: En eksisterende medarbejder tilfoejes til en eksisterende aktivitet
    Given Serveren koerer
    And Der eksisterer et projekt "projekt"
    And Der eksisterer en aktivitet "aktivitet" i projektet "projekt"
    And En medarbejder med initialerne "INIT" eksisterer
    When Medarbejderen med initialerne "INIT" tilfoejes til aktiviteten "aktivitet" i projektet "projekt"
    Then Medarbejderen med initialerne "INIT" er en del af aktiviteten "aktivitet" i projektet "projekt"