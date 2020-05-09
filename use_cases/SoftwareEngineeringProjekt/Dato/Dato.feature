#Skrefvet af Clara M. Lorenzen - s180350
@tag
Feature: Oprette en dato

  @tag1
  Scenario: Dato bliver oprettet
    Given at der bliver oprettet en dato, f.eks. dag 10 maaned 10 aar 2020
    When datoen oenskes oplyst
    Then datoen bliver printet ud, paa formen "10-10-2020"
        