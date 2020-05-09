// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.InitialsWrongLengthException;

public class ServControll {
	private ProjectManager projekter;
	private MedarbejderManager medarbejdere;
	private Dato currentDate;
	private ConnectionManager connectionManager;
	
	public void ServerStart(int day, int month, int year) {
		projekter = new ProjectManager();
		medarbejdere = new MedarbejderManager();
		currentDate = new Dato(day, month, year);
/*
		newProjekt("test0", medarbejdere.getMedarbejdere().get(0), new Dato(4, 2020), new Dato(9, 2020));
		newProjekt("test1", medarbejdere.getMedarbejdere().get(0), new Dato(1, 2020), new Dato(34, 2020));
		newProjekt("test2", medarbejdere.getMedarbejdere().get(0), new Dato(29, 2020), new Dato(52, 2020));
		
		System.out.println("Projekter: ");
		for (Project p : projekter.getProjects())
		{
			System.out.println(p.getNavn() + " " + p.getProjektNummer() + " med startuge: " + p.getStartUge() + " og slutuge: " + p.getSlutUge());
			System.out.println(new Dato(9,2020).getFormatedDate());
		}
		System.out.println("Medarbejdere: ");
		for (Medarbejder m : medarbejdere.getMedarbejdere())
			System.out.println(m.getInitialer());
		System.out.println("Dags dato: " + currentDate.getFormatedDate());
		
		newAktivitet("test0", "aktivitets test", new Dato(1, 2020), new Dato(3, 2020), 7);
		addMedarbToAkt("ADMN", "test0", "aktivitets test");
		System.out.println("Aktivitetsdata for projekt test0: " + projekter.getProjects().get(0).getAktiviteter().get(0).getAllData());
*/
		connectionManager = new ConnectionManager();
		//connectionManager.openCon();

	}
	
	public ArrayList<Project> getProjekter() {
		return this.projekter.getProjects();
	}
	
	public Dato getDato() {
		return this.currentDate;
	}
	
	
	
	// RELEVANS TIL AKTIVITETER
	public int newAktivitet(String projekt, String navn, Dato startUge, Dato slutUge, int budgetTid) {
		this.projekter.getCertainProject(findProjektVedNavn(projekt)).addAktivitet(navn, startUge, slutUge, budgetTid);
		return 0;
	}
	
	public int addMedarbToAkt (String initialer, String projekt, String aktivitet) {
		this.projekter.getCertainProject(findProjektVedNavn(projekt)).getAktiviteter()
		.get(this.projekter.getCertainProject(findProjektVedNavn(projekt)).getCertainAkt(aktivitet))
		.addMedarbejder(this.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}
	
	/*
	private static int findAktVedNavn(String navn) {
		
	}
	*/
	
	private int findMedarbVedInit (String init) {
		for (Medarbejder m : this.medarbejdere.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return this.medarbejdere.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	
	// RELEVANS TIL PROJEKTER
	
	public int newProjekt(String navn, Medarbejder projektLeder, Dato startUge, Dato slutUge) {
		System.out.println(projektLeder.getInitialer() + " tries to create project " + navn);
		String projektNummer;
		if (this.projekter.getProjektListLength() > 0)
		{
			// Sidste oprettede projekts fulde nummer
			String s = this.projekter.getProjects().get(this.projekter.getProjektListLength() - 1).getProjektNummer();
			if ( s.substring(0, 4).equals(Integer.toString(this.currentDate.getYear())))
			{
				if ( s.substring(4, 10).equals("999999") )
				{
					throw new NullPointerException("No more room for projects this year");
				}
				else
					projektNummer = Integer.toString(this.currentDate.getYear()) + nulStuff(Integer.toString(Integer.parseInt(s.substring(4, 10)) + 1));
			}
			else 
			{
				projektNummer = "" + this.currentDate.getYear() + "000000";
			}
		}
		else projektNummer = "" + this.currentDate.getYear() + "000000";
		this.projekter.addProject(new Project(navn, projektLeder, startUge, slutUge, projektNummer));
		return 0;
	}
	
	private static String nulStuff(String s) {
		for ( int i = 6 - s.length(); i > 0; i--)
		{
			s = "0" + s;
		}
		return s;
	}
	
	public int addMedarbToProj (String initialer, String projekt) {
		this.projekter.getCertainProject(findProjektVedNavn(projekt))
		.addMedarbejder(this.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}
	
	private int findProjektVedNavn(String navn) {
		for (Project p : this.projekter.getProjects())
		{
			if (p.getNavn().equalsIgnoreCase(navn))
				return this.projekter.getProjects().indexOf(p);
		}
		return -1;
	}
	
	public void newMedarbejder(String initialer) {
		try {
			medarbejdere.newMedarbejder(initialer);
		} catch (InitialsWrongLengthException e) {
			System.out.println("whatWeDo?");
			e.printStackTrace();
		} catch (EmployeeAlreadyExistsException e) {
			System.out.println("whatWeDo?");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Medarbejder> getMedarbejdere() {
		return this.medarbejdere.getMedarbejdere();
	}
	
	public void nyDato(int day, int month, int year) {
		this.currentDate = new Dato(day, month, year);
	}
}
