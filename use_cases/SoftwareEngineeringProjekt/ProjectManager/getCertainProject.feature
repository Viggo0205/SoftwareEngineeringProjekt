# skrevet af Rasmus Nyhus - s194285
@tag
Feature: der kaldes et projekt ud fra et indeks i ProjectManager

  @tag1
  Scenario: der kaldes et projekt ud fra et indeks i ProjectManager
    Given Projektmanageren eksisterer
    And Der findes mindst et Project "projekt" i ProjectManager med indeks 0 
    When der kaldes et projekt ud fra et indeks 0 i ProjectManager
    Then projektet med indeks 0 er returnet