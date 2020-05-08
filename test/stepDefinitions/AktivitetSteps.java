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
	private String data;

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

	@When("Slutugen tilhoerende Aktiviteten {string} aendres til en anden uge med ugenummer {int} og aarstal {int}")
	public void slutugenTilhoerendeAktivitetenAendresTilEnAndenUgeMedUgenummerOgAarstal(String string, Integer int1, Integer int2) throws Exception {
	    this.aktivitet.setSlutUge(int1, int2);
	}

	@Then("Aktivitetens slutuge er nu en uge med ugenummer {int} og aarstal {int}")
	public void aktivitetensSlutugeErNuEnUgeMedUgenummerOgAarstal(Integer int1, Integer int2) throws Exception {
		assertEquals((int) int1, this.aktivitet.getSlutUge()[0] & (int) int2, this.aktivitet.getSlutUge()[1]);
	}
	
	@When("Startugen tilhoerende Aktiviteten {string} aendres til en anden uge med ugenummer {int} og aarstal {int}")
	public void startugenTilhoerendeAktivitetenAendresTilEnAndenUgeMedUgenummerOgAarstal(String string, Integer int1, Integer int2) throws Exception {
		this.aktivitet.setStartUge(int1, int2);
	}

	@Then("Aktivitetens startuge er nu en uge med ugenummer {int} og aarstal {int}")
	public void aktivitetensStartugeErNuEnUgeMedUgenummerOgAarstal(Integer int1, Integer int2) throws Exception {
		assertEquals((int) int1, this.aktivitet.getStartUge()[0] & (int) int2, this.aktivitet.getStartUge()[1]);
	}
	
	@Given("Aktiviteten {string} har en startuge med ugenr {int} og aarstallet {int}, slutugen med ugenr {int} og aarstallet {int} og den budgeterede tid {int} halve timer")
	public void aktivitetenHarEnStartugeMedUgenrOgAarstalletSlutugenMedUgenrOgAarstalletOgDenBudgeteredeTidHalveTimer(String string, Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) throws Exception {
		this.aktivitet = new Aktivitet(string, new Dato(int1,int2), new Dato(int3,int4), int5);
	}

	@When("Aktivitetens data efterspoerges")
	public void aktivitetensDataEfterspoerges() throws Exception {
	    this.data = this.aktivitet.getAllData();
	}

	@Then("Dataen leveres paa streng-format")
	public void dataenLeveresPaaStrengFormat(String docString) throws Exception {
	    assertEquals(docString, this.data);
	}
	
	@Given("Aktiviteten har en medarbejder med intialerne {string}")
	public void aktivitetenHarEnMedarbejderMedIntialerne(String string) {
	    this.aktivitet.addMedarbejder(new Medarbejder(string, 0));
	}	
}