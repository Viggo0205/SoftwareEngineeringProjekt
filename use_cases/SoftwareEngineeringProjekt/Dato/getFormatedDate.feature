#Skrevet af Clara M. Lorenzen - s180350
@tag
Feature: datoen bliver printet ud p� en streng

  @tag1
  Scenario: Den oenskede dato bliver printet ud p� en streng
    Given der eksisterer en dato, f.eks. dag 24 maaned 1 aar 2020
    When datoen bliver skrevet paa en streng 
    Then bliver der printet "24-1-2020"
    