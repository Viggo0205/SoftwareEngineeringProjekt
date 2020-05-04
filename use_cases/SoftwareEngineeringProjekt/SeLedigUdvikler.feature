#clara
Feature: <Se ledige udviklere for periode> 
Description: Udviklingsleder kan se hvilke udviklere er ledige for en given tidsperiode 
Actor: Udviklingsleder

#main scenario
  Scenario: <Udviklingsleder undersoeger for ledige udviklere, i en periode med ledige udviklere> 
    Given <Brugeren er logget ind>
    When  <Bruger soeger efter ledige udviklere for en tidsperiode med ledige udviklere , og bruger er udviklingsleder> 
    Then <Der svares hvilke udviklere er ledige i den givne periode>

#Alternativ scenerie 1
  Scenario: <Udviklingsleder undersoeger for ledige udviklere , i en periode uden ledige udviklere> 
    Given <Brugeren er logget ind>
    When <Bruger soeger efter ledige udviklere for en tidsperiode uden ledige udviklere , og bruger er udviklingsleder>
    Then <Der svares , der ikke er ledige udviklere i den givne periode>


#Fail scenerie 1
  Scenario: <Angivet en udgyldig tidsramme> 
    Given <Brugeren er logget ind>
    When <Bruger soeger efter ledige udviklere for en ugyldig tidsperiode , og bruger er udviklingsleder> 
    Then <Der svares med fejlbesked for forkert tidsramme>
    
    
#Fail scenerie 2
  Scenario: <Brugeren er ikke udviklingsleder>
    Given <Brugeren er logget ind>
    When <Bruger soeger efter ledige udviklere , og bruger er ikke udviklingsleder> 
    Then <Der svares med fejlbesked for ugyldig bruger>
    
    
    
    