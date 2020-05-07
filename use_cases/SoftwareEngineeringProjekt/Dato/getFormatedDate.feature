@tag
Feature: datoen bliver printet ud på en streng

  @tag1
  Scenario: Den oenskede dato bliver printet ud på en streng
    Given der eksisterer en dato, f.eks. dag 24 maaned 1 aar 2020
    When datoen bliver skrevet på en streng 
    Then bliver der printet "24-1-2020"
    