package stepDefinitions;

import static org.junit.Assert.assertEquals;
import SoftwareEngineringProjekt.src.Dato;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatoSteps {
	
	private Dato dato;
	
	@Given("at der bliver oprettet en dato, f.eks. dag {int} maaned {int} aar {int}")
	public void atDerBliverOprettetEnDatoFEksDagMaanedAar(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}

//	@When("datoen oenskes oplyst")
//	public void datoenOenskesOplyst() {
//		this.dato.Dato();
//	}

	@Then("datoen bliver printet ud, paa formen {string}")
	public void datoenBliverPrintetUdPFormen(String string) {
		assertEquals(string, this.dato);
	}

	@Given("en dato eksisterer, f.eks. dag {int} maaned {int} aar {int}")
	public void enDatoEksistererFEksDagMaanedAar(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}

	@Given("datoen har et ugenummer")
	public void datoenHarEtUgenummer() {
		this.dato = new Dato(0, 0);
	}
//
//	@When("dag {int} maaned {int} aar {int} bliver angivet")
//	public void dagMaanedAarBliverAngivet(Integer int1, Integer int2, Integer int3) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("ugenummeret {int} bliver fundet")
//	public void ugenummeretBliverFundet(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("dag {int} maaned {int} aar {int} er en dato der eksisterer")
//	public void dagMaanedAarErEnDatoDerEksisterer(Integer int1, Integer int2, Integer int3) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("dato {int} maaned {int} aar {int} bliver angivet")
//	public void datoMaanedAarBliverAngivet(Integer int1, Integer int2, Integer int3) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("forskellen p? de to dage bliver fundet til at vaere {int}")
//	public void forskellenPDeToDageBliverFundetTilAtVaere(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("der eksisterer en dato, f.eks. dag {int} maaned {int} aar {int}")
//	public void derEksistererEnDatoFEksDagMaanedAar(Integer int1, Integer int2, Integer int3) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("datoen bliver skrevet p? en streng")
//	public void datoenBliverSkrevetPEnStreng() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("bliver der printet {string}")
//	public void bliverDerPrintet(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}



	
}
