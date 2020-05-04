Feature: Indmeld tid brugt
  Description: En bruger indmelder et tidsforbrug
  Actors: Udvikler

#Main scenario
  Scenario: <Brugeren forsoeger at indmelde tid>
    Given <Brugeren er logget ind>
    When <Brugeren angiver en aktivitet vedkommende er tilknyttet til>
    And <Brugeren Angiver en acceptabel tidsmaengde>
    Then <Systemet tilfoejer den angivne tid til brugerens samlede tid anvendt på aktiviteten og informerer brugeren herom>

#Fail Scenario 1
  Scenario: <Brugeren forsoeger at indmelde tid>
    Given <Brugeren er logget ind>
    When <Brugeren angiver en aktivitet vedkommende er tilknyttet til>
    And <Brugeren Angiver en uacceptabel tidsmaengde>
    Then <Systemet informere brugeren om at den givende maengde af tid er uacceptabel>

#Fail Scenario 2
  Scenario: <Brugeren forsoeger at indmelde tid>
    Given <Brugeren er logget ind>
    When <Brugeren angiver en aktivitet vedkommende ikke er tilknyttet til>
    And <Brugeren Angiver en uacceptabel tidsmaengde>
    Then <Systemet informere brugeren om at vedkommende ikke er tilknyttet aktiviteten>