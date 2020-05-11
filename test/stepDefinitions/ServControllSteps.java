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
		ServControll.ServerStart(9, 5, 2020, false);
	}

	@When("Der bedes om startdata fra serveren")
	public void derBedesOmStartdataFraServeren() {
		System.out.println("Testskridt");
	    this.projekter = ServControll.getProjekter();
	    System.out.println("Længde: " + this.projekter.size());
	    this.dato = ServControll.getDato();
	    System.out.println(this.dato.getFormatedDate());
	    this.medarbejdere = this.servControll.getMedarbejdere();
	    System.out.println("Længde: " + this.medarbejdere.size());
	    System.out.println("Initialer: " + this.medarbejdere.get(0).getInitialer());
	}

	@Then("Dataen indebaerer en nuvaerende dato {int}-{int}-{int}")
	public void dataenIndebaererEnNuvaerendeDato(Integer int1, Integer int2, Integer int3) {
	    assertEquals(new Dato(int1, int2, int3).getFormatedDate(), this.dato.getFormatedDate());
	}

	@Then("Dataen indebaerer en projektManager med {int} projekt i til registrering af fravaer")
	public void dataenIndebaererEnProjektManagerMedProjektITilRegistreringAfFravaer(Integer int1) {
		assertEquals(1, this.projekter.size());
	}
	
	
	@Then("Dataen indebaerer en medarbejderManager med en medarbejder: {string}")
	public void dataenIndebaererEnMedarbejderManagerMedEnMedarbejder(String string) {
		assertEquals(string, this.medarbejdere.get(0).getInitialer());
	}
	
	@Given("Serveren koerer")
	public void serverenKoerer() {
		ServControll.ServerStart(9, 5, 2020, false);
	}

	@Given("Der er allerede oprettet {int} projekter dette aar")
	public void derErAlleredeOprettetProjekterDetteAar(Integer int1) {
	    for (int i = 0; i < int1; i++)
	    	ServControll.newProjekt("test", "ADMN", new Dato(2,2020), new Dato(3,2020));
	}

	@Then("En error {string} modtages")
	public void enErrorModtages(String string) {
		assertEquals(string, this.errorMessage);
	}
	
	@When("Et nyt projekt {string} forsoeges tilfoejet")
	public void etNytProjektForsoegesTilfoejet(String string) {
		try {
			ServControll.newProjekt(string, "ADMN", new Dato(2,2020), new Dato(3,2020));
		}
		catch (NullPointerException e) {
			this.errorMessage = e.toString();
		}
	}

	@Then("Projektet {string} findes i serverens projektManager")
	public void projektetFindesIServerensProjektManager(String string) {
		assertEquals(string, ServControll.getProjekter().get(1).getNavn());
	}
	
	@Given("Det nuvaerende aar overgaar til et nyt")
	public void detNuvaerendeAarOvergaarTilEtNyt() {
		this.dato = ServControll.getDato();
	    ServControll.nyDato(this.dato.getDay(), this.dato.getMonth(), this.dato.getYear() + 1);
	}

	@Then("Projektet har ID'et ved aarstallet og det foerste nummer for det paagaeldende aar")
	public void projektetHarIDEtVedAarstalletOgDetFoersteNummerForDetPaagaeldendeAar() {
		actualProjektNummer = ServControll.getProjekter().get(ServControll.getProjekter().size() - 1).getProjektNummer();
		assertEquals("2021000000", actualProjektNummer);
	}
	
	@Given("Der eksisterer et projekt {string}")
	public void derEksistererEtProjekt(String string) {
	    ServControll.newProjekt(string, "ADMN", new Dato(2, 2020), new Dato(3, 2020));
	}

	@Given("Der eksisterer en aktivitet {string} i projektet med nummeret {string}")
	public void derEksistererEnAktivitetIProjektetMedNummeret(String string, String string2) {
		ServControll.newAktivitet(string2, string, new Dato(2, 2020), new Dato(3, 2020), 5);
	}
	
	@Given("En medarbejder med initialerne {string} eksisterer")
	public void enMedarbejderMedInitialerneEksisterer(String string) {
	    servControll.newMedarbejder(string);
	}

	@When("Medarbejderen med initialerne {string} tilfoejes til aktiviteten {string} i projektet {string}")
	public void medarbejderenMedInitialerneTilfoejesTilAktivitetenIProjektet(String string, String string2, String string3) {
	    ServControll.addMedarbToAkt(string, string3, string2);
	}

	@Then("Medarbejderen med initialerne {string} er en del af aktiviteten {string} i projektet {string}")
	public void medarbejderenMedInitialerneErEnDelAfAktivitetenIProjektet(String string, String string2, String string3) {
		actualInitialer = ServControll
				.getProjekter()
				.get(1)
				.getAktiviteter()
				.get(0)
				.getMedarbejdere()
				.get(0)
				.getInitialer();
	    assertEquals(string, actualInitialer);
	}
	
	@When("Medarbejderen med initialerne {string} tilfoejes til projektet {string}")
	public void medarbejderenMedInitialerneTilfoejesTilProjektet(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		servControll.addMedarbToProj(string, string2);
	}

	@Then("Medarbejderen med initialerne {string} er en del af projektet {string}")
	public void medarbejderenMedInitialerneErEnDelAfProjektet(String string, String string2) {
		actualInitialer = ServControll.getProjekter().get(1).getMedarbejdere().get(1).getInitialer();
		assertEquals(string, actualInitialer);
	}

	@When("Medarbejderen med initialerne {string} registrerer ferie fra dato {string} til {string}")
	public void medarbejderenMedInitialerneRegistrererFerieFraDatoTil(String string, String string2, String string3) {
		ServControll.registrerFerie(string, string2, string3);
	}
	
	@Then("medarbejderen {string} staar registreret for ferie d. {int} , {int}, {int}")
	public void medarbejderenStaarRegistreretForFerieD(String string, Integer int1, Integer int2, Integer int3) {
		int arbejdsdag = ServControll.findArbejdsDagIndvedMedarbIndOgDag(ServControll.findMedarbVedInit(string), new Dato(int1, int2, int3));
		assertEquals("test",ServControll.getProjekter().get(0).getMedarbejdere().get(1).getKalender().getCertainArbejdsdag(arbejdsdag).getTid());
	}
	
	@When("Medarbejderen med initialerne {string} registrerer ferie fra dato {string} til {string} d")
	public void medarbejderenMedInitialerneRegistrererFerieFraDatoTilD(String string, String string2, String string3) {
		ServControll.registrerFerie(string, string2, string3);
	}

	@Then("medarbejderen {string} staar registreret for ferie d. {int} , {int}, {int} d")
	public void medarbejderenStaarRegistreretForFerieDD(String string, Integer int1, Integer int2, Integer int3) {
		int arbejdsdag = ServControll.
				findArbejdsDagIndvedMedarbIndOgDag(
						ServControll
						.findMedarbVedInit(string)
						, new Dato(int1, int2, int3));
		assertEquals("Arbejdstider for: 21-2-2020\n2020000000\nFerie: 16\nTotaltid: 16",ServControll.getMedarbejdere().get(1).getKalender().getCertainArbejdsdag(arbejdsdag).getTid());
	}
	
	@Given("Medarbejderen med initialerne {string} eksisterer")
	public void medarbejderenMedInitialerneEksisterer(String string) {
	    ServControll.newMedarbejder(string);
	    ServControll.findMedarbVedInit(string);
	}
}
