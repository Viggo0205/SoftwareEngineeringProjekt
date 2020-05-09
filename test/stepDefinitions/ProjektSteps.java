//Skrevet af Christian S. Jakobsen
package stepDefinitions;

import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;
import SoftwareEngineringProjekt.src.Project;
import SoftwareEngineringProjekt.src.ProjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;


public class ProjektSteps {
	
	

    private Dato startUge = new Dato(21,1,2020);
    private Dato slutUge= new Dato(2,2,2020);
    private Medarbejder medarbejder = new Medarbejder("Jumbo", 4);
    private Project projekt;
    private ProjectManager projektmanager;
	
	
	
	
	
	@Given("At projektet {string} eksisterer")
	public void atProjektetEksisterer(String string) {
		 projekt = new Project(string, medarbejder, slutUge, slutUge, "4");	    	
	}

	@When("En aktivitet {string} er tilfoejet til et projekt {string}")
	public void enAktivitetErTilfoejetTilEtProjekt(String string, String string2) {
		projekt.addAktivitet(string, startUge, slutUge, 60);
	}

//	@When("Aktiviteten modtager et navn")
//	public void aktivitetenModtagerEtNavn() {
//	    aktivitet.
//	    throw new io.cucumber.java.PendingException();
//	}
    // Der er kun et projekt så derfor kan .get(0) bruges i dette tilfælde
	@Then("Aktiviteten er tilfoejet til det oenskede projekt")
	public void aktivitetenErTilfoejetTilDetOenskedeProjekt(String string) {
	    System.out.println(projekt.getAktiviteter().get(0).getNavn());
	    assertEquals(string, projekt.getAktiviteter().get(0).getNavn());
	}

//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Medarbejderen {string} ikke allerede er tilknyttet projektet {string}")
//	public void medarbejderenIkkeAlleredeErTilknyttetProjektet(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("En medarbjeder tilfoejes til et projekt {string}")
//	public void enMedarbjederTilfoejesTilEtProjekt(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Medarbejderen er nu tilknyttet projekt {string}")
//	public void medarbejderenErNuTilknyttetProjekt(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("I want to write a step with precondition")
//	public void iWantToWriteAStepWithPrecondition() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("some other precondition")
//	public void someOtherPrecondition() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("I complete action")
//	public void iCompleteAction() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("some other action")
//	public void someOtherAction() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("yet another action")
//	public void yetAnotherAction() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("I validate the outcomes")
//	public void iValidateTheOutcomes() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("check more outcomes")
//	public void checkMoreOutcomes() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("En leder tilknyttes projektet {string}")
//	public void enLederTilknyttesProjektet(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("En leder er nu tilknyttet projektet {string}")
//	public void enLederErNuTilknyttetProjektet(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Projektet {string} allerede har et navn")
//	public void projektetAlleredeHarEtNavn(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Projektets {string} navn aendres")
//	public void projektetsNavnAendres(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Projektets {string} navn opdateres")
//	public void projektetsNavnOpdateres(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Projektet {string} f?r en slut uge")
//	public void projektetFREnSlutUge(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Projektet {string} har en slut uge")
//	public void projektetHarEnSlutUge(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Projektet {string} f?r en start uge")
//	public void projektetFREnStartUge(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Projektet {string} har en start uge")
//	public void projektetHarEnStartUge(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
