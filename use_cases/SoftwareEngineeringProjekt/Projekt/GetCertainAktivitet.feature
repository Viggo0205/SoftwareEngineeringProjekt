#Skrevet af Christian S. Jakobsen__S194307
@tag
Feature: Ekstrahere en specifik aktivitet fra et projekt

  @tag1
  Scenario: Ekstrahere en specifik aktivitet "aktivitet" fra et eksisterende projekt "projekt"
    Given At projektet "projekt" eksisterer
    When En aktivitet "aktivitet" ekstraheres fra et projekt "projekt"
    Then Aktiviteten "aktivitet" er extraheret fra projekt "projekt"
