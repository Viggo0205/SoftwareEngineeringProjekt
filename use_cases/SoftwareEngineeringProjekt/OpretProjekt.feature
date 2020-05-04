Feature: <Opret projekt>
  Description: En bruger forsoeger at oprette et nyt projekt
  Actors Udvikler

#Main scenario 1
  Scenario: <Bruger forsoeger at oprette et projekt>
    Given <Bruger er logget ind>
    When <Brugeren opretter et nyt projekt>
    When <Brugeren forsoeger at oprette et nyt projekt, paa et tidspunkt, hvor der stadig er ledige numre paa formaten|(y)aarstal, (n)loebenummer|: yynnn>
    Then <Systemet opretter et nyt projekt og tildeler det et projekt nummer. Dette nummer informeres brugeren om>
#Fail Scenario 1
  Scenario: <Bruger forsoeger at oprette et projekt>
    Given <Bruger er logget ind>
    When <Brugeren opretter et nyt projekt>
    When <Brugeren forsoeger at oprette et nyt projekt, paa et tidspunkt, hvor der ikke ledige numre paa formaten|(y)aarstal, (n)loebenummer|: yynnn>
    Then <Systemet opretter ikke et nyt projekt og informere brugeren om, at der ikke er flere ledige Loebenumre for aarstallet>
#Scenario 2
  Scenario: <Bruger forsoeger at oprette et projekt>
    Given <Bruger er logget ind>
    When <Brugeren opretter et nyt projekt>
    When <Brugeren forsoeger at oprette et nyt projekt, paa et tidspunkt, hvor der stadig er ledige numre paa formaten|(y)aarstal, (n)loebenummer|: yynnn>
    When <Brugeren angivet et projektnavn>
    Then <Systemet opretter et nyt projekt og tildeler det et projekt nummer og et navn. Bruger informeres herom>
#Scenario 3
  Scenario: <Bruger forsoeger at oprette et projekt>
    Given <Bruger er logget ind>
    When <Brugeren opretter et nyt projekt>
    When <Brugeren forsoeger at oprette et nyt projekt, paa et tidspunkt, hvor der stadig er ledige numre paa formaten|(y)aarstal, (n)loebenummer|: yynnn>
    When <Brugeren angiver en projektleder>
    Then <Systemet opretter et nyt projekt og tildeler det et projekt nummer og en leder. Dette nummer informeres brugeren om>
