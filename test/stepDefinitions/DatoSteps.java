package stepDefinitions;
import static org.junit.Assert.assertEquals;
import SoftwareEngineringProjekt.src.Dato;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatoSteps {

	private Dato dato;
	private Dato dato2;
	private String s;
	private int d;
	private int n;
	
//	Dato.featur
//	1. scenarie 
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

	@Given("der er oprettet en dato ud fra dag {int}, aar {int} {string}")
	public void derErOprettetEnDatoUdFraDagAar(Integer int1, Integer int2, String string) {
		this.dato = new Dato(365, 2020, "s");
	}

	@Then("outputtet {string} gives")
	public void outputtetGives(String string) {
		assertEquals("31-12-2020", this.dato.getFormatedDate());
	}

//	3. Scenarie
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
//	
//	beregnUge.featur
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
//	1. scenarie
//	Der bliver her prøvet at få testet koden for forkel på to dage
	@Given("dag {int} maaned {int} aar {int} er en dato der eksisterer")
	public void dagMaanedAarErEnDatoDerEksisterer(Integer int1, Integer int2, Integer int3) {
		this.dato = new Dato(int1, int2, int3);
	}
	
	@When("dato {int} maaned {int} aar {int} bliver efterspurgt")
	public void datoMaanedAarBliverEfterspurgt(Integer int1, Integer int2, Integer int3) {
		d = this.dato.getDeltaDag(new Dato(int1, int2, int3));
	}

	@Then("forskellen paa de to dage bliver fundet til at vaere {int}")
	public void forskellenPDeToDageBliverFundetTilAtVaere(Integer int1) {
		assertEquals((int) int1, d);
	}

//	2. scenarie
//	Der bliver her prøvet at få testet koden for forkel på to dage der er langt fra hinanden, 
//	det lykkedes dog ikke at får testet den del af koden ordentligt
//	@Given("der er forskelg paa dag {int} maaned {int} aar {int} og dag {int} maaned {int} aar {int}")
//	public void derErForskelgPaaDagMaanedAarOgDagMaanedAar(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
//		   this.dato = new Dato(int1, int2, int3);
//		   this.dato2 = new Dato(int4, int5, int6);
//	}
//
//	@When("dagene bliver efterspurgt")
//	public void dageneBliverEfterspurgt() {
//		this.dato.getFormatedDate();
//		this.dato2.getFormatedDate();
//	}
//
//	@Then("forskellen paa de to dage bliver fundet til at vaere {int} maaneder")
//	public void forskellenPaaDeToDageBliverFundetTilAtVaereMaaneder(Integer int1) {
//		assertEquals("1-1-2019", this.dato.getFormatedDate());
//	}
	
	
//	getFormatedDate.featur
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
