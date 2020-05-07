package stepDefinitions;

import static org.junit.Assert.assertEquals;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Dato;
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

	@Then("Aktiviteten staar registreret for den korrekte tidsmaengde")
	public void aktivitetenStaarRegistreretForDenKorrekteTidsmaengde() throws Exception {
		assertEquals(5, this.aktivitet.getTime());
	}

}