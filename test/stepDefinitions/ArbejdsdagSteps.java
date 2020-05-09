package stepDefinitions;

import SoftwareEngineringProjekt.src.*;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArbejdsdagSteps {

    public Dato dato = new Dato(1,2,2020);
    public Dato startUge = new Dato(20,2020);
    public Dato slutUge= new Dato(4,2020);
    public Arbejdsdag arbejdsdag = new Arbejdsdag(dato);
    public Medarbejder medarbejder = new Medarbejder("VO",5);
    public Project projekt = new Project("Bente",medarbejder,startUge,slutUge,"2");
    public Aktivitet aktivitet = new Aktivitet("katjakaj",startUge,slutUge,70);



    @Given("Brugeren er tilknyttet det givende aktivitet {string}")
    public void brugeren_er_tilknyttet_det_givende_aktivitet(String string) {
        projekt.addMedarbejder(medarbejder);
        projekt.addAktivitet("katjakaj",startUge,slutUge,70);
        aktivitet.addMedarbejder(medarbejder);
    }




    @When("bruger tilfoejer timer {int} til given arbejdsdag og aktivitet {string}")
    public void bruger_tilfoejer_timer_til_given_arbejdsdag_og_aktivitet(Integer int1, String string) {
        arbejdsdag.addTid("Bente",string,int1);
    }




    @Then("timer er registreret paa given arbejdsdag og der bliver noteret projekt {string} og aktivitet {string}")
    public void timer_er_registreret_paa_given_arbejdsdag_og_der_bliver_noteret_projekt_og_aktivitet(String string, String string2) {
        arbejdsdag.addTid(string,string2,4);
    }

}
