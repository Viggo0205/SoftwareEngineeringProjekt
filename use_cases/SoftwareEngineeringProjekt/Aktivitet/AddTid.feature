#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Tilfoej tid til en aktivitet

  @tag1
  Scenario: En bruger tilfoejer tid til en eksisterende aktivitet
    Given Aktiviteten "aktivitet" eksisterer
    When Brugeren tilfoejer en tidsmaengde 5
    Then Aktiviteten staar registreret for den korrekte tidsmaengde 5
