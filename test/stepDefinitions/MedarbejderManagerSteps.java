package stepDefinitions;


import static org.junit.Assert.assertEquals;

import java.util.List;

import SoftwareEngineringProjekt.src.MedarbejderManager;
import SoftwareEngineringProjekt.src.Medarbejder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MedarbejderManagerSteps {

	private MedarbejderManager medarbejdere;
	private Medarbejder nyMedarbejder1 = new Medarbejder("TEST", 1);
	private Medarbejder nyMedarbejder2 = new Medarbejder("TESTER", 1);
	private Medarbejder nyMedarbejder3 = new Medarbejder("glMA", 1);
	private boolean acceptinit = true;
	
	// scenarie 1
	@Given("Der eksistrere en medarbejderManager")
	public void derEksistrereEnMedarbejderManager() {
		medarbejdere = new MedarbejderManager();
		
	    throw new io.cucumber.java.PendingException();
	}

	@Given("der er en medarbejder i medarbejderManager")
	public void derErNMedarbejderIMedarbejderManager() {
		if(medarbejdere.getMedarbejdere().get(0) == null)
			medarbejdere.newMedarbejder("ADMI");
		
	    throw new io.cucumber.java.PendingException();
	}

	@When("der tilfoejes en medarbejder med gyldige initialer {string}")
	public void derTilfoejesEnMedarbejderMedGyldigeInitialer(String string) { 
		this.medarbejdere.newMedarbejder(string);
		
	    throw new io.cucumber.java.PendingException();
	}

	@Then("ArrayListen med medarbejdere indeholder nu medarbejder med initialer {string} og id {int}")
	public void arraylistenMedMedarbejdereIndeholderNuMedarbejderMedInitialerOgId(String string, Integer int1) {
		assertEquals(((List<Medarbejder>) medarbejdere).get(((List<Medarbejder>) medarbejdere).size() - 1).getInitialer(),string);
		
	    throw new io.cucumber.java.PendingException();
	}

	
	// fail scenarie 1
	@Given("Der eksistrere en medarbejderManager")
	public void derEksistrereEnMedarbejderManager1() {
		medarbejdere = new MedarbejderManager();
		
	    throw new io.cucumber.java.PendingException();
	}

	@Given("der er en medarbejder i medarbejderManager")
	public void derErNMedarbejderIMedarbejderManager1() {
		if(medarbejdere.getMedarbejdere().get(0) == null)
			medarbejdere.newMedarbejder("ADMI");
		
	    throw new io.cucumber.java.PendingException();
	}

	@When("der tilfoejes en medarbejder med initialer {String}, der bruges and anden medarbejder i medarbejderManager")
	public void derTilfoejesEnMedarbejderMedInitialerDerBrugesAndAndenMedarbejderIMedarbejderManager(String string) {
		this.medarbejdere.newMedarbejder(string); // hvordan skriver jeg ind, stringen er forkert??
		
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Der er sendt fejlbesked")
	public void derErSendtFejlbesked() {
		System.out.println("fejl"); // ? kast exception ?
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	// fail scenarie 2
	@Given("Der eksistrere en medarbejderManager")
	public void derEksistrereEnMedarbejderManager2() {
		medarbejdere = new MedarbejderManager(); // hvordan skriver jeg ind, stringen er forkert??
		
	    throw new io.cucumber.java.PendingException();
	}

	@Given("der er en medarbejder i medarbejderManager")
	public void derErNMedarbejderIMedarbejderManager2() {
		if(medarbejdere.getMedarbejdere().get(0) == null)
			medarbejdere.newMedarbejder("ADMI");
		
	    throw new io.cucumber.java.PendingException();
	}

	@When("der tilfoejes en medarbejder med for lange initialer {String}")
	public void derTilfoejesEnMedarbejderMedForLangeInitialerTESTER(String string) {
		this.medarbejdere.newMedarbejder(string);
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Der er sendt fejlbesked")
	public void derErSendtFejlbesked1() {
		System.out.println("fejl"); // ? kast exception ?
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
