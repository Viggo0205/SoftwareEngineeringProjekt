package stepDefinitions;
//Lavet af Victor Tadeusz Ulstrup Olszowski
import SoftwareEngineringProjekt.src.*;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class ArbejdsdagSteps {

    private Dato dato = new Dato(1,2,2020);
    private Dato startUge = new Dato(20,2020);
    private Dato slutUge= new Dato(4,2020);
    private Arbejdsdag arbejdsdag = new Arbejdsdag(dato);
    private Medarbejder medarbejder = new Medarbejder("VO",5);
    private Project projekt = new Project("Bente",medarbejder,startUge,slutUge,"2");
    private Aktivitet aktivitet = new Aktivitet("katjakaj",startUge,slutUge,70);



    //addTid

    //scenarie 1
    @Given("en arbejdsdag eksisterer")
    public void en_arbejdsdag_eksisterer() {
        arbejdsdag = new Arbejdsdag(dato);

    }

    @When("bruger tilfoejer halvetimer {int} til given arbejdsdag, projekt {string} og aktivitet {string}")
    public void bruger_tilfoejer_halvetimer_til_given_arbejdsdag_projekt_og_aktivitet(Integer int1, String string, String string2) {
        arbejdsdag.addTid(string,string2,int1);
        System.out.println("Tid er tilfoejet til arbejdsdag");
    }


    @Then("timer er registreret paa given arbejdsdag og der bliver noteret projekt, aktivtet og tiden der er registrert til dagen printes")
    public void timer_er_registreret_paa_given_arbejdsdag_og_der_bliver_noteret_projekt_aktivtet_og_tiden_der_er_registrert_til_dagen_printes(String docString) {
        String k = arbejdsdag.getTid();

        assertEquals(docString,k);

    }

    //Scenarie 2


    @Given("arbejdsdag som modtager projekt {string} aktivitet {string} og en maengde af tid i halvetimer {int} allerede har tilfoejet tid")
    public void arbejdsdag_som_modtager_projekt_aktivitet_og_en_maengde_af_tid_i_halvetimer_allerede_har_tilfoejet_tid(String string, String string2, Integer int1) {
        arbejdsdag.addTid(string,string2,int1);
    }

    //scenarie 3
    @When("bruger tilfoejer halvetimer {int} til given arbejdsdag, projekt {string} og en anden aktivitet {string}")
    public void bruger_tilfoejer_halvetimer_til_given_arbejdsdag_projekt_og_en_anden_aktivitet(Integer int1, String string, String string2) {
        arbejdsdag.addTid(string,string2,int1);
    }





}
