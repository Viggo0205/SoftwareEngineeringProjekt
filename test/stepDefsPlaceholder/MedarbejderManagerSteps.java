/*package stepDefsPlaceholder;


import static org.junit.Assert.assertEquals;

import java.util.List;

import SoftwareEngineringProjekt.src.MedarbejderManager;
import dtu.library.app.OperationNotAllowedException;
import SoftwareEngineringProjekt.src.Medarbejder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MedarbejderManagerSteps {

	private MedarbejderManager medarbejdere;
	private boolean acceptinit = true;
	private String errorMessage;
	
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
		
		try {
			this.medarbejdere.newMedarbejder(string);
		} catch (EmployeeAlreadyExistsException e) {
			errorMessage = "fejl";
		}
		
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
		try {
			this.medarbejdere.newMedarbejder(string);
		} catch (InitialsTooShortException e) {
			errorMessage = "fejl";
		}
	}

	@Then("Der er sendt fejlbesked {String}")
	public void derErSendtFejlbesked1(String string) {
		System.out.println("fejl"); // ? kast exception ?
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}*/
