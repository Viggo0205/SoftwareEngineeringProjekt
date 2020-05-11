#Skrevet af Clara M. Lorenzen - s180350
@tag
Feature: Man kan finde en forskel på to datoer

#1. Scenarie
	@tag1
  Scenario: Finde foskel paa to datoer
    Given dag 4 maaned 5 aar 2019 er en dato der eksisterer
    When dag 10 maaned 5 aar 2021 bliver efterspurgt
    Then forskellen paa de to dage bliver fundet til at vaere 737

    