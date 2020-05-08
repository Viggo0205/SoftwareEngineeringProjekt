#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: At aendre aktiviteters parametre

  @tag1
  Scenario: Et projekts slutuge aendres
    Given Aktiviteten "aktivitet" eksisterer
    When Slutugen tilhoerende Aktiviteten "aktivitet" aendres til en anden uge med ugenummer 8 og aarstal 2020
    Then Aktivitetens slutuge er nu en uge med ugenummer 8 og aarstal 2020
    
    @tag2
  Scenario: Et projekts startuge aendres
    Given Aktiviteten "aktivitet" eksisterer
    When Startugen tilhoerende Aktiviteten "aktivitet" aendres til en anden uge med ugenummer 10 og aarstal 2020
    Then Aktivitetens startuge er nu en uge med ugenummer 10 og aarstal 2020