#clara
Feature: <Se udvikling af timer for en aktivitet >
Description: Udviklingsleder kan se hvor mange timer er brugt paa aktiviteter eller projekter 
Actor: Udviklingsleder

#main scenario
  Scenario:  <Udviklingsleder undersoeger hvor mange timer er brugt paa en aktivitet>
    Given <Brugeren er logget ind> 
    When <Bruger soeger efter timer er brugt paa en aktivitet , og bruger er udviklingsleder> 
    Then <Der svares hvor mange timer er brugt i alt og pr. uge, samt hvor mange timer er tilbage>

#alternstive scenario 1
  Scenario:  <Udviklingsleder undersoeger hvor mange timer er brugt paa et projekt> 
    Given <Brugeren er logget ind>
    When <Bruger soeger efter timer er brugt paa et projekt, og bruger er udviklingsleder>
    Then <Der svares hvor mange timer er brugt i alt og pr. uge>

#fail scenario 1
  Scenario:  <Udviklingsleder undersoeger hvor mange timer er brugt paa et projekt eller en aktivitet, der ikke eksisterer> 
    Given <Brugeren er logget ind>
    When <Bruger soeger efter timer er brugt paa et projekt, og bruger er udviklingsleder>
    Then <Der svares hvor mange timer er brugt i alt og pr. uge>


