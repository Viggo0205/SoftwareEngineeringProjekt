#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Server opstart

  @tag1
  Scenario: Serveren startes fra bunden
    Given Serveren startes d. <9-5-2020>
    When Der bedes om startdata fra serveren
    Then Dataen indebaerer en nuvaerende dato 9-5-2020
    And Dataen indebaerer en tom projektManager
    And Dataen indebaerer en medarbejderManager med en medarbejder: "ADMN"

