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
	
}
