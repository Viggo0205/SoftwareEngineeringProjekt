#Author: Christian s194307
#Commit 
Feature: Tildel Aktivitet til udviklere
      Description: Udviklingsleder kan tildele aktivitet til udviklere
      Actor: Udviklingsleder
#Main
      Scenario: Udviklingsleder tildeler aktivitet til udvikler
      Given Brugeren er logget ind med gyldige "initialer"
      When Brugeren tildeler en opgave og er udviklingsleder
      And Brugeren giver aktiviteten en besrkivelse
      And Brugeren har angivet en udvikler
      And Angivet projektet eksisterer
      Then Saa bliver der tildelt en opgave
#fail
      Scenario: Brugeren ikke er udviklingsleder
      When Bruger bestiller ny aktivitet og ikke er udviklingsleder
      And Bruger giver en aktivitets beskrivelser
      And Bruger har angivet en udvikler
      And Angivet projektet eksisterer
      Then Print fejl besked Du er ikke udviklingsleder
