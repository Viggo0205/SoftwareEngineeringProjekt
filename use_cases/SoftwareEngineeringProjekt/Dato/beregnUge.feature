#Skrevet af Clara M. Lorenzen - s180350
@tag
Feature: Beregner hvilken uge den angivne dato er i

	@tag1
  Scenario: ugenummeret for den givne uge bliver beregnet
    Given en dato eksisterer, f.eks. dag 24 maaned 1 aar 2020
    And datoen har et ugenummer
    When dag 24 maaned 1 aar 2020 bliver angivet
    Then ugenummeret 4 bliver fundet
