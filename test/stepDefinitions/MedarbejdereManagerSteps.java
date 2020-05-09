package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import SoftwareEngineringProjekt.src.Medarbejder;
import SoftwareEngineringProjekt.src.MedarbejderManager;
import Exceptions.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MedarbejdereManagerSteps {
	
	private MedarbejderManager medarbejdere;
	private String errorMessage;
	
	@Given("Der eksistrere en medarbejderManager")
	public void derEksistrereEnMedarbejderManager() throws Exception {
		medarbejdere = new MedarbejderManager();
	}

	@Given("der er en medarbejder i medarbejderManager med initialer {string}")
	public void derErEnMedarbejderIMedarbejderManagerMedInitialer(String string) throws Exception {
		if(medarbejdere.getMedarbejdere().get(0) == null)
			medarbejdere.newMedarbejder(string);
	}

	@When("der tilfoejes en medarbejder med gyldige initialer {string}")
	public void derTilfoejesEnMedarbejderMedGyldigeInitialer(String string) throws Exception {
		this.medarbejdere.newMedarbejder(string);
	}

	@SuppressWarnings("unchecked")
	@Then("ArrayListen med medarbejdere indeholder nu medarbejder med initialer {string} og id {int}")
	public void arraylistenMedMedarbejdereIndeholderNuMedarbejderMedInitialerOgId(String string, Integer int1) throws Exception{
		assertEquals(string,this.medarbejdere.getMedarbejdere().get(this.medarbejdere.getMedarbejdere().size() - 1).getInitialer());
	}

	@When("der tilfoejes en medarbejder med initialer {string} , der bruges and anden medarbejder i medarbejderManager")
	public void derTilfoejesEnMedarbejderMedInitialerDerBrugesAndAndenMedarbejderIMedarbejderManager(String string) throws Exception {
		try {
			this.medarbejdere.newMedarbejder(string);
		} catch (EmployeeAlreadyExistsException e) {
			errorMessage = "fejl1";
		}
	}

	@Then("Der er sendt fejlbesked {string}")
	public void derErSendtFejlbesked(String string) throws Exception {
		assertEquals(string, errorMessage);
	}

	@When("der tilfoejes en medarbejder med for lange initialer {string} .")
	public void derTilfoejesEnMedarbejderMedForLangeInitialer(String string) throws Exception {
		try {
			this.medarbejdere.newMedarbejder(string);
		} catch (InitialsWrongLengthException e) {
			errorMessage = "fejl2";
		}
	}

}
