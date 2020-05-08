#Skrevet af Rasmus Nyhus - s194285
@tag
Feature: Tilfoej medarbejder til virksomhed/server

  @tag1
  Scenario: En medarbejder tilfoejes systemet med gyldige initialer
    Given Der eksistrere en medarbejderManager
    And der er én medarbejder i medarbejderManager
    When der tilfoejes en medarbejder med gyldige initialer "TEST"
    Then ArrayListen med medarbejdere indeholder nu medarbejder med initialer "TEST" og id 1
    
	@tag2
	Scenario: En medarbejder tilfoejes systemet med initialer, der allerede anvendes i mederbederManager
		Given Der eksistrere en medarbejderManager
		And der er én medarbejder i medarbejderManager
		When der tilfoejes en medarbejder med initialer "TEST", der bruges and anden medarbejder i medarbejderManager 
		Then Der er sendt fejlbesked
		
	@tag3
	Scenario: En medarbejder tilfoejes systemet med initialer, der ikke har stringLaengde 4
		Given Der eksistrere en medarbejderManager
		And der er én medarbejder i medarbejderManager
		When der tilfoejes en medarbejder med for lange initialer "TESTER"
		Then Der er sendt fejlbesked
	
    