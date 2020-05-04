Feature: <Bestil Aktivitet>
      Desctription: Udviklingsleder kan bestille ny aktivitet som er tilsluttet et projekt
      Actor: Udviklingsleder

      Scenario: <Udviklingsleder bestiller ny aktivitet>
      Given <Brugeren er logget ind>
      When <Bruger bestiller aktivitet og er udviklingsleder>
      And <Bruger tilfoejer tidsramme>
      And <Bruger tilfoejer arbejdstimer>
      And <Angivet projektet eksisterer>
      Then <Saa bliver der bestilt at den nye aktviitet bliver lavet>

      Scenario: <Brugeren ikke er udviklingsleder>
      When <Bruger
