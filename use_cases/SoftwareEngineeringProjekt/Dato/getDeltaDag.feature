@tag
Feature: Man kan finde en forskel p� to datoer

	@tag1
  Scenario: Finde foskel paa to datoer
    Given dag 4 maaned 5 aar 2020 er en dato der eksisterer
    When dato 10 maaned 5 aar 2020 bliver angivet
    Then forskellen p� de to dage bliver fundet til at vaere 6
    
    