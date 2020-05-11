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
	
//	Dato.featur
//	1. scenarie 
//	Der bliver her testet for dato angivet ved dag, måned og år
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
	
//	2. scenarie
//	Der bliver her testet for dato angivet ved dag, år og en string
	@Given("der er oprettet en dato ud fra dag {int}, aar {int} {string}")
	public void derErOprettetEnDatoUdFraDagAar(Integer int1, Integer int2, String string) {
		this.dato = new Dato(365, 2020, "s");
	}

	@Then("outputtet {string} gives")
	public void outputtetGives(String string) {
		assertEquals("31-12-2020", this.dato.getFormatedDate());
	}

//	3. Scenarie
//	Der bliver her testet for dato angivet ved uge og år
	@Given("der oprettes en dato ud fra uge {int} aar {int}")
	public void derOprettesEnDatoUdFraUgeAar(Integer int1, Integer int2) {
		this.dato = new Dato((int)int1,(int) int2);
	}

	@When("datoen oenskes")
	public void datoenOenskes() {
		 this.dato.getFormatedDate();
	}

	@Then("vi faar outputtet {string}")
	public void viFROutputtet(String string) {
		assertEquals( "23-12-2020", this.dato.getFormatedDate());
	}	
	
//	beregnUge.featur
//	der bliver her testet for at få et ugenummer
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
	
//	getdeltaDag.feature
//	Koden bliver her testet for forkel på to dage
	@Given("dag {int} maaned {int} aar {int} er en dato der eksisterer")
	public void dagMaanedAarErEnDatoDerEksisterer(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}

	@When("dag {int} maaned {int} aar {int} bliver efterspurgt")
	public void dagMaanedAarBliverEfterspurgt(Integer int1, Integer int2, Integer int3) {
		d = this.dato.getDeltaDag(new Dato(int1, int2, int3));
	}

	@Then("forskellen paa de to dage bliver fundet til at vaere {int}")
	public void forskellenPaaDeToDageBliverFundetTilAtVaere(Integer int1) {
		assertEquals((int) int1, d);
	}
	
//	getFormatedDate.featur
//	Koden skal returnere en string, hvilket der bliver testet for her 
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
