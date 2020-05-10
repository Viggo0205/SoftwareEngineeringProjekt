#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Server opstart

  @tag1
  Scenario: Serveren startes fra bunden
    Given Serveren startes d. 9 . 5 . 2020 test
    When Der bedes om startdata fra serveren
    Then Dataen indebaerer en nuvaerende dato 9-5-2020
    And Dataen indebaerer en projektManager med 1 projekt i til registrering af fravaer
    And Dataen indebaerer en medarbejderManager med en medarbejder: "ADMN"

