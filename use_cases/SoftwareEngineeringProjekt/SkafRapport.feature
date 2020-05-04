Feature: <Skaf rapport>
      Description: <Udviklingsleder kan anmode om at skaffe rapporter>
      Actor: <Udviklingsleder>

      Scenario: <Brugeren efterspoerger en rapport>
      Given <Brugeren er logget ind>
      When <Brugeren er udviklingsleder>
      And <Brugeren tilfoejere tidsrammer>
      And <Brugeren tilfoejere arbejdstimer>
      And <Angivet projektet eksisterer>
      Then <Den efterspurgte rapport er oensket>

      Scenario: <Brugeren efterspoeger en rapport>
      When <Brugeren er ikke udviklingsleder>
      And <Brugeren tilfoejere tidsrammer>
      And <Brugeren tilfoejere arbejdstimer>
      And <Angivet projektet eksistere>
      Then <Print fejl besked "Du er ikke udviklingsleder">
      
     	Scenario: <Anmodet om ikke eksisterende rapport>
     	When <Brugeren er udviklingsleder og anmoder om en ikke eksisterende rapport>
     	Then <Print fejlbesked "Du har anmodet om en ikke eksisterende rapport">
