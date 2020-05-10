package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;
import SoftwareEngineringProjekt.src.Project;
import SoftwareEngineringProjekt.src.ServControll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServControllSteps {

	private ServControll servControll = new ServControll();
	private ArrayList<Project> projekter;
	private Dato dato;
	private List<Medarbejder> medarbejdere;
	private String errorMessage;
	private String actualProjektNummer;
	private String actualInitialer;
	
	@Given("Serveren startes d. {int} . {int} . {int} test")
	public void serverenStartesDTest(Integer int1, Integer int2, Integer int3) {
		System.out.println("Server starter");
		//this.servControll = new ServControll();
		this.servControll.ServerStart(9, 5, 2020);
	}

	@When("Der bedes om startdata fra serveren")
	public void derBedesOmStartdataFraServeren() {
		System.out.println("Testskridt");
	    this.projekter = this.servControll.getProjekter();
	    System.out.println("Længde: " + this.projekter.size());
	    this.dato = this.servControll.getDato();
	    System.out.println(this.dato.getFormatedDate());
	    this.medarbejdere = this.servControll.getMedarbejdere();
	    System.out.println("Længde: " + this.medarbejdere.size());
	    System.out.println("Initialer: " + this.medarbejdere.get(0).getInitialer());
	}

	@Then("Dataen indebaerer en nuvaerende dato {int}-{int}-{int}")
	public void dataenIndebaererEnNuvaerendeDato(Integer int1, Integer int2, Integer int3) {
	    assertEquals(new Dato(int1, int2, int3).getFormatedDate(), this.dato.getFormatedDate());
	}

	@Then("Dataen indebaerer en tom projektManager")
	public void dataenIndebaererEnTomProjektManager() {
	    assertEquals(0, this.projekter.size());
	}

	@Then("Dataen indebaerer en medarbejderManager med en medarbejder: {string}")
	public void dataenIndebaererEnMedarbejderManagerMedEnMedarbejder(String string) {
		assertEquals(string, this.medarbejdere.get(0).getInitialer());
	}
	
	@Given("Serveren koerer")
	public void serverenKoerer() {
		this.servControll.ServerStart(9, 5, 2020);
	}

	@Given("Der er allerede oprettet {int} projekter dette aar")
	public void derErAlleredeOprettetProjekterDetteAar(Integer int1) {
	    for (int i = 0; i < int1; i++)
	    	this.servControll.newProjekt("test", new Medarbejder("ADMN", 0), new Dato(2,2020), new Dato(3,2020));
	}

	@Then("En error {string} modtages")
	public void enErrorModtages(String string) {
		assertEquals(string, this.errorMessage);
	}
	
	@When("Et nyt projekt {string} forsoeges tilfoejet")
	public void etNytProjektForsoegesTilfoejet(String string) {
		try {
			this.servControll.newProjekt(string, new Medarbejder("ADMN", 0), new Dato(2,2020), new Dato(3,2020));
		}
		catch (NullPointerException e) {
			this.errorMessage = e.toString();
		}
	}

	@Then("Projektet {string} findes i serverens projektManager")
	public void projektetFindesIServerensProjektManager(String string) {
		assertEquals(string, this.servControll.getProjekter().get(0).getNavn());
	}
	
	@Given("Det nuvaerende aar overgaar til et nyt")
	public void detNuvaerendeAarOvergaarTilEtNyt() {
		this.dato = this.servControll.getDato();
	    this.servControll.nyDato(this.dato.getDay(), this.dato.getMonth(), this.dato.getYear() + 1);
	}

	@Then("Projektet har ID'et ved aarstallet og det foerste nummer for det paagaeldende aar")
	public void projektetHarIDEtVedAarstalletOgDetFoersteNummerForDetPaagaeldendeAar() {
		actualProjektNummer = this.servControll.getProjekter().get(this.servControll.getProjekter().size() - 1).getProjektNummer();
		assertEquals("2021000000", actualProjektNummer);
	}
	
	@Given("Der eksisterer et projekt {string}")
	public void derEksistererEtProjekt(String string) {
	    servControll.newProjekt(string, new Medarbejder("TEST", 0), new Dato(2, 2020), new Dato(3, 2020));
	}

	@Given("Der eksisterer en aktivitet {string} i projektet {string}")
	public void derEksistererEnAktivitetIProjektet(String string, String string2) {
	    servControll.newAktivitet(string2, string, new Dato(2, 2020), new Dato(3, 2020), 5);
	}

	@Given("En medarbejder med initialerne {string} eksisterer")
	public void enMedarbejderMedInitialerneEksisterer(String string) {
	    servControll.newMedarbejder(string);
	}

	@When("Medarbejderen med initialerne {string} tilfoejes til aktiviteten {string} i projektet {string}")
	public void medarbejderenMedInitialerneTilfoejesTilAktivitetenIProjektet(String string, String string2, String string3) {
	    servControll.addMedarbToAkt(string, string3, string2);
	}

	@Then("Medarbejderen med initialerne {string} er en del af aktiviteten {string} i projektet {string}")
	public void medarbejderenMedInitialerneErEnDelAfAktivitetenIProjektet(String string, String string2, String string3) {
		actualInitialer = servControll.getProjekter().get(0).getAktiviteter().get(0).getMedarbejdere().get(0).getInitialer();
	    assertEquals(string, actualInitialer);
	}
	
	
}
