#Slrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Hent data fra en aktivitet

  @tag1
  Scenario: Aktiviteten har kun noedvendige data
    Given Aktiviteten "aktivitet" har en startuge med ugenr 4 og aarstallet 2020, slutugen med ugenr 8 og aarstallet 2020 og den budgeterede tid 50 halve timer
    When Aktivitetens data efterspoerges
    Then Dataen leveres paa streng-format 
    			"""
    			Aktivitets navn: aktivitet
    			startuge: 4-2020
    			slutuge: 8-2020
    			budgettid: 50
    			realtid: 0
    			medarbejdere:
    			"""
    			
	@tag2
	Scenario: Aktiviteten har noedvendige data og medarbejdere
		Given Aktiviteten "aktivitet" har en startuge med ugenr 4 og aarstallet 2020, slutugen med ugenr 8 og aarstallet 2020 og den budgeterede tid 50 halve timer
		And Aktiviteten har en medarbejder med intialerne "TEST"
		When Aktivitetens data efterspoerges
		Then Dataen leveres paa streng-format 
    			"""
    			Aktivitets navn: aktivitet
    			startuge: 4-2020
    			slutuge: 8-2020
    			budgettid: 50
    			realtid: 0
    			medarbejdere:
    			TEST
    			"""
