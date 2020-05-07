#Author: Christian s194307
Feature: Soege hjaelp fra andre
      Description: Brugeren soeger hjaelp fra andre brugere
      Actor: Udviklere og Udviklingsleder
#main
      Scenario: Brugeren soeger hjaelp fra andre brugere
      Given Brugeren er logget ind med gyldige "initialer"
      When Brugeren beder en anden bruger om hjaelp
      And Den hjaelpende bruger er ledig
      And Angivet projektet eksisterer
      Then Saa bliver det skrevet ind at den givende bruger hjaelper til paa det projekt
#fail
      Scenario: <Der er ingen bruger til at overtage eller hjaelpe paa projektet
      When Der er ikke nogen der kan hjaelpe
      And Brugeren forsoeger at faa hjaelp
      And Angivet projektet eksisterer
      Then Print fejl besked Der er ingen hjaelp at faa lige nu
