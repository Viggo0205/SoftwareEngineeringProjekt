#Skrevet af Clara M. Lorenzen - s180350
@tag
Feature: Beregner hvilken uge den angivne dato er i

	@tag1
  Scenario: ugenummeret for den givne uge bliver beregnet
    Given en dato eksisterer i uge 4
    When datoens ugenummer bliver eftersourgt
    Then ugenummeret 4 bliver returneret

    
    