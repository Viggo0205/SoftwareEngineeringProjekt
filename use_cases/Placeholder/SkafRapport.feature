#Author: Christian s194307
Feature: Skaf rapport
      Description: Udviklingsleder kan anmode om at skaffe rapporter
      Actor: Udviklingsleder
#main
      Scenario: Brugeren efterspoerger en rapport
      Given Brugeren er logget ind med gyldige "initialer"
      When Brugeren er udviklingsleder
      And Brugeren tilfoejere tidsrammer
      And Brugeren tilfoejere arbejdstimer
      And Angivet projektet eksisterer
      Then Den efterspurgte rapport er oensket
#fail1
      Scenario: Brugeren efterspoeger en rapport
      When Brugeren er ikke udviklingsleder
      And Brugeren tilfoejere tidsrammer
      And Brugeren tilfoejere arbejdstimer
      And Angivet projektet eksisterer
      Then Print fejl besked "Du er ikke udviklingsleder"
#fail2      
     	Scenario: Anmodet om ikke eksisterende rapport
     	When Brugeren er udviklingsleder og anmoder om en ikke eksisterende rapport
     	Then Print fejlbesked "Du har anmodet om en ikke eksisterende rapport"
