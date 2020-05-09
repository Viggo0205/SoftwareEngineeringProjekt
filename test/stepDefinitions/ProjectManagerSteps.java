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


	
	
	@Given("Der findes mindst et Project {string} i ProjectManager med indeks {int}")
	public void derFindesMindstEtProjectIProjectManagerMedIndeks(String string, Integer int1) throws Exception {
		if(this.projektManager.getProjects().size() == 0)
			projektManager.addProject(new Project(string, new Medarbejder("TEST", 0), new Dato(2,2020), new Dato(5,2020), "2020000000"));
	    			
	}

	@When("der kaldes et projekt ud fra et indeks {int} i ProjectManager")
	public void derKaldesEtProjektUdFraEtIndeksIProjectManager(Integer int1) {
	    
		this.projektManager.getCertainProject(int1);
	}

	@Then("projektet med indeks {int} er returnet")
	public void projektetMedIndeksErReturnet(Integer int1) {
	    assertEquals((int)int1, this.projektManager.getProjects().indexOf(this.projektManager.getCertainProject(int1)));
	}

}
