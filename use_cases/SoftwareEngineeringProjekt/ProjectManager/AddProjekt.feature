# Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Tilfoej et projekt til en projektmanager

  @tag1
  Scenario: Et projekt tilfoejes til projektmanageren
    Given Projektmanageren eksisterer
    When Projektet "projekt" tilfoejes til projektmanageren
    Then Projektmanageren indeholder projektet "projekt" 