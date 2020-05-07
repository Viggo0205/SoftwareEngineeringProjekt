//Skrevet ak

package stepDefinitions;

import static org.junit.Assert.assertEquals;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AktivitetSteps {

	private Aktivitet aktivitet;

	@Given("Aktiviteten {string} eksisterer")
	public void aktivitetenEksisterer(String string) throws Exception {
		this.aktivitet = new Aktivitet(string, new Dato(2,2020), new Dato(5,2020), 50);
	}
	
	@When("Brugeren tilfoejer en tidsmaengde {int}")
	public void brugerenTilfoejerEnTidsmaengde(Integer int1) throws Exception {
	    this.aktivitet.addTid(int1);
	}

	@Then("Aktiviteten staar registreret for den korrekte tidsmaengde {int}")
	public void aktivitetenStaarRegistreretForDenKorrekteTidsmaengde(Integer int1) throws Exception {
	    assertEquals((int) int1, this.aktivitet.getTime());
	}

	@When("Medarbejderen {string} tilfoejes til aktiviteten {string}")
	public void medarbejderenTilfoejesTilAktiviteten(String string, String string2) throws Exception {
		this.aktivitet.addMedarbejder(new Medarbejder(string, 0));
	}

	@Then("Aktiviteten {string} har medarbejderen {string} registreret")
	public void aktivitetenHarMedarbejderenRegistreret(String string, String string2) throws Exception {
	    assertEquals("Medarbejdere:\n" + string2, this.aktivitet.getMedarbejdere());
	}

}