#Skrevet af Clara M. Lorenzen - s180350
@tag
Feature: Man kan finde en forskel på to datoer

#1. Scenarie
	@tag1
  Scenario: Finde foskel paa to datoer
    Given dag 4 maaned 5 aar 2020 er en dato der eksisterer
    When dato 10 maaned 5 aar 2020 bliver efterspurgt
    Then forskellen paa de to dage bliver fundet til at vaere 6

#2. Scenarie    
    @tag2
    Scenario: Finde forskel paa to datoer 
    Given der er forskelg paa dag 1 maaned 1 aar 2019 og dag 31 maaned 12 aar 2021
    When dagene bliver efterspurgt
    Then forskellen paa de to dage bliver fundet til at vaere 24 maaneder
    