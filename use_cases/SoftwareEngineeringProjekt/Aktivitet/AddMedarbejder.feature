#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Tilfoej medarbejder til aktivitet

  @tag1
  Scenario: En eksisterende medarbejder tilfoejes til en eksisterende aktivitet
    Given Aktiviteten "aktivitet" eksisterer
    When Medarbejderen "TEST" tilfoejes til aktiviteten "aktivitet"
    Then Aktiviteten "aktivitet" har medarbejderen "TEST" registreret