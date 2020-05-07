package stepDefinitions;

import static org.junit.Assert.assertEquals;

import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;
import SoftwareEngineringProjekt.src.Project;
import SoftwareEngineringProjekt.src.ProjectManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectManagerSteps {

	private ProjectManager projektManager;

	@Given("Projektmanageren eksisterer")
	public void projektmanagerenEksisterer() throws Exception {
	   projektManager = new ProjectManager();
	}

	@When("Projektet {string} tilfoejes til projektmanageren")
	public void projektetTilfJesTilProjektmanageren(String string) throws Exception {
	    projektManager.addProject(new Project(string, new Medarbejder("TEST", 0), new Dato(2,2020), new Dato(5,2020), "2020000000"));
	}

	@Then("Projektmanageren indeholder projektet {string}")
	public void projektmanagerenIndeholderProjektet(String string) throws Exception {
	    assertEquals(string, projektManager.getCertainProject(0).getNavn());
	}



}
