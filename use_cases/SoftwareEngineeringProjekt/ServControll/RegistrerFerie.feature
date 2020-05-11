#Skrevet af Eigil Sejer Larsen - s194282
@tag
Feature: Ferieregistrering
  I want to use this template for my feature file

  @tag1
  Scenario: Medarbejder indmelder ferie
    Given Serveren koerer
    And Medarbejderen med initialerne "INIT" eksisterer
		When Medarbejderen med initialerne "INIT" registrerer ferie fra dato "20-2-2020" til "5-3-2020" d
    Then medarbejderen "INIT" staar registreret for ferie d. 21 , 2, 2020 d