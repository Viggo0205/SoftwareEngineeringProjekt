//Skrevet af Christian S. Jakobsen
package stepDefinitions;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;
import SoftwareEngineringProjekt.src.Project;
import SoftwareEngineringProjekt.src.ProjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;


public class ProjektSteps {
	
	
	private String s = new String();
    private Dato startUge = new Dato(21,1,2020);
    private Dato slutUge= new Dato(2,2,2020);
    private Medarbejder medarbejder = new Medarbejder("BigG", 4);
    private Project projekt;
//    private ProjectManager projektmanager;
//    private Aktivitet aktivitet = new Aktivitet("aktivitet", startUge, slutUge, 50);
    //private Udviklingsleder udviklingsleder;
	
	
	
	
	
	@Given("At projektet {string} eksisterer")
	public void atProjektetEksisterer(String string) {
		 projekt = new Project(string, medarbejder, slutUge, slutUge, "4");	    	
	}

	@When("En aktivitet {string} er tilfoejet til et projekt {string}")
	public void enAktivitetErTilfoejetTilEtProjekt(String string, String string2) {
		projekt.addAktivitet(string, startUge, slutUge, 60);
	}
	
    // Der er kun et projekt så derfor kan .get(0) bruges i dette tilfælde
	
	@Then("Aktiviteten {string} er tilfoejet til det oenskede projekt {string}")
	public void aktivitetenErTilfoejetTilDetOenskedeProjekt(String string, String string2) {
		System.out.println(projekt.getAktiviteter().get(0).getNavn() + " er tilføjet til " + projekt.getNavn());
	    assertEquals(string, projekt.getAktiviteter().get(0).getNavn());
	}


//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//		projekt = new Project(string, medarbejder, slutUge, slutUge, "4");
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("En medarbjeder med initialer {string} tilfoejes til et projekt {string}")
	public void enMedarbjederTilfoejesTilEtProjekt(String string, String string2) {
	    projekt.addMedarbejder(medarbejder);
	}

	@Then("Medarbejderen med initialer {string} er nu tilknyttet projekt {string}")
	public void medarbejderenErNuTilknyttetProjekt(String string, String string2) {
	   System.out.println(projekt.getMedarbejdere().get(0).getInitialer() + " er tilføjet til " + projekt.getNavn());
	   assertEquals(string2, projekt.getNavn());
	}

//	@Given("At projektet {string} eksistere")
//	public void atProjektetEksistere(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("En aktivitet {string} paa plads {int} ekstraheres fra et projekt {string}")
	public void enAktivitetEkstraheresFraEtProjekt(String string, Integer int1, String string2) {
		projekt.addAktivitet(string, startUge, slutUge, 30);
		projekt.findAktVedNavn(string);
	}

	@Then("Aktiviteten {string} paa plads {int} er extraheret fra projekt {string}")
	public void aktivitetenErExtraheretFraProjekt(String string, Integer int1, String string2) {
	    System.out.println(projekt.findAktVedNavn(string) + " er den pladsde den tilgået aktivitet har i projektet " + projekt.getNavn());
	    assertEquals((int) int1, projekt.findAktVedNavn(string));
	}
	
	@When("En aktivitet {string} ikke findes")
	public void ForsoegerAtEkstrahereEnAktivitetSomIkkeFindesFraEtProjekt(String string) {
		projekt.findAktVedNavn(string);
	}

	@Then("Saa henvises der til plads {int} i projektet {string}")
	public void SaaHenvisesDerTilPlads(Integer int1, String string) {
		System.out.println("Der findes ikke en aktivitet med det navn i " + projekt.getNavn());
	    assertEquals((int) int1, projekt.findAktVedNavn(string));
	}

//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("En leder {string} tilknyttes projektet {string}")
	public void enLederTilknyttesProjektet(String string, String string2) {
		projekt.setLeder(medarbejder);
	}

	@Then("En leder {string} er nu tilknyttet projektet {string}")
	public void enLederErNuTilknyttetProjektet(String string, String string2) {
		System.out.println(projekt.getLeder().getInitialer() + " er projektleder for " + projekt.getNavn());
		assertEquals(string, projekt.getLeder().getInitialer());
	}

//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("Projektet {string} allerede har et navn")
	public void projektetAlleredeHarEtNavn(String string) {
	    projekt.getNavn();
	}

	@When("Projektets {string} navn aendres til {string}")
	public void projektetsNavnAendres(String string, String string2) {
		projekt.setNavn(string2);
	}

	@Then("Projektets {string} navn opdateres til {string}")
	public void projektetsNavnOpdateres(String string, String string2) {
	    System.out.println(projekt.getNavn() + " er projektets nye navn");
	    assertEquals(string2, projekt.getNavn());
	}

//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("Projektet {string} faar en slut uge {int} {int}")
	public void projektetFaaREnSlutUge(String string, Integer int1, Integer int2) {
	   projekt.setSlutUge(int1, int2);
	}

	@Then("Projektet {string} har en slut uge {int} {int}")
	public void projektetHarEnSlutUge(String string, Integer int1, Integer int2) {
	    System.out.println("" + projekt.getSlutUge()[0] + " " + projekt.getSlutUge()[1] + " er slut ugen for " + projekt.getNavn());
	    assertEquals((int) int1, projekt.getSlutUge()[0] & (int) int2, projekt.getSlutUge()[1]);
	}

//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("Projektet {string} faar en start uge {int} {int}")
	public void projektetFREnStartUge(String string, Integer int1, Integer int2) {
		projekt.setStartUge(int1, int2);
	}

	@Then("Projektet {string} har en start uge {int} {int}")
	public void projektetHarEnStartUge(String string, Integer int1, Integer int2) {
		System.out.println("" + projekt.getStartUge()[0] + " " + projekt.getStartUge()[1] + " er start ugen for " + projekt.getNavn());
	    assertEquals((int) int1, projekt.getStartUge()[0] & (int) int2, projekt.getStartUge()[1]);
	}
	
//	@Given("At projektet {string} eksisterer")
//	public void atProjektetEksisterer(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("Brugeren efterspoeger en samlet rapport af projekt {string} med en tilknyttet aktivitet {string}")
	public void brugerenEfterspoegerEnSamletRapportAfProjektMedEnTilknyttetAktivitet(String string, String string2) {
		projekt = new Project(string, medarbejder, slutUge, slutUge, "7");
		projekt.addAktivitet("dumle", startUge, slutUge, 65);
	    s = projekt.getPackagedRapport();
	}

	@Then("En samlet rapport af projektet {string} genereres og retuneres")
	public void enSamletRapportAfProjektetGenereresOgRetuneres(String string) {
	    System.out.println(projekt.getPackagedRapport());
	    assertEquals(s, projekt.getPackagedRapport());
	}
}

