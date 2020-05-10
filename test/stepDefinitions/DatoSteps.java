package stepDefinitions;

import static org.junit.Assert.assertEquals;
import SoftwareEngineringProjekt.src.Dato;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatoSteps {


	private Dato dato;
	private String s;
	private int d;
	private int week;
	private int year;
	
	@Given("at der bliver oprettet en dato, f.eks. dag {int} maaned {int} aar {int}")
	public void atDerBliverOprettetEnDatoFEksDagMaanedAar(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}
	@When("datoen oenskes oplyst")
	public void datoenOenskesOplyst() {
		s = this.dato.getFormatedDate();
	}

	@Then("datoen bliver printet ud, paa formen {string}")
	public void datoenBliverPrintetUdPFormen(String string) {
		assertEquals((String) string, s);
	}

	@Given("en dato eksisterer i uge {int}")
	public void enDatoEksistererIUge(Integer int1) {
		int week = 4;
		int year = 2020;
		this.dato = new Dato(week, year);	}

	@When("datoens ugenummer bliver eftersourgt")
	public void datoensUgenummerBliverEftersourgt() {
	   this.dato.beregnUge();
	}

	@Then("ugenummeret {int} bliver returneret")
	public void ugenummeretBliverReturneret(Integer int1) {
		assertEquals((int) int1, this.dato.beregnUge());
    }

	@Given("dag {int} maaned {int} aar {int} er en dato der eksisterer")
	public void dagMaanedAarErEnDatoDerEksisterer(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}

	@When("dato {int} maaned {int} aar {int} bliver angivet")
	public void datoMaanedAarBliverAngivet(Integer int1, Integer int2, Integer int3) {
//		d = this.dato.getDeltaDag();
		this.dato.getDeltaDag(this.dato);
	}

	@Then("forskellen paa de to dage bliver fundet til at vaere {int}")
	public void forskellenPDeToDageBliverFundetTilAtVaere(Integer int1) {
		assertEquals((int) int1, this.dato.getDeltaDag(this.dato));
		System.out.println(d);
	}

	@Given("der eksisterer en dato, f.eks. dag {int} maaned {int} aar {int}")
	public void derEksistererEnDatoFEksDagMaanedAar(Integer int1, Integer int2, Integer int3) {
	   this.dato = new Dato(int1, int2, int3);
	}

	@When("datoen bliver skrevet paa en streng")
	public void datoenBliverSkrevetPEnStreng() {
		this.dato.getFormatedDate();
	}

	@Then("bliver der printet {string}")
	public void bliverDerPrintet(String string) {
		assertEquals((String) string, this.dato.getFormatedDate());
	}

}
