#Skrefvet af Clara M. Lorenzen - s180350
@tag
Feature: Oprette en dato

#1. Scenarie
  @tag1
  Scenario: Dato bliver oprettet
    Given at der bliver oprettet en dato, f.eks. dag 10 maaned 10 aar 2020
    When datoen oenskes oplyst
    Then datoen bliver printet ud, paa formen "10-10-2020"

#2. Scenarie
	@tag2
	Scenario: Dato oprettes ud fra dag i aaret
		Given der er oprettet en dato ud fra dag 366, aar 2020 "s"
		When datoen oenskes
		Then outputtet "31-12-2020" gives
		
				
#3. Scenarie
	@tag3
	Scenario: Dato oprettes ud fra uge og aar
		Given der oprettes en dato ud fra uge 52 aar 2020
		When datoen oenskes
		Then vi faar outputtet "22-12-2020"
		
		
		
		
		
		
		