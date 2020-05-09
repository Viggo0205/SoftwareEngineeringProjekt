#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Ekstrahere en specifik aktivitet fra et projekt

  @tag1
  Scenario: Ekstrahere en specifik aktivitet "aktivitet" fra et eksisterende projekt "projekt"
    Given At projektet "projekt" eksisterer
    When En aktivitet "aktivitet" paa plads 0 ekstraheres fra et projekt "projekt"
    Then Aktiviteten "aktivitet" paa plads 0 er extraheret fra projekt "projekt"
		
	@tag2
	Scenario: Forsoeger at ekstrahere en aktivitet "aktivitet" som ikke findes fra et projekt "projekt"
		Given At projektet "projekt" eksisterer
		When En aktivitet "aktivitet" ikke findes
		Then Saa henvises der til plads -1 i projektet "projekt"