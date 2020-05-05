// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;

public class ServControll {
	private static ProjectManager projekter;
	private static MedarbejderManager medarbejdere;
	private static Dato currentDate;

	
	public static void ServerStart() {
		projekter = new ProjectManager();
		medarbejdere = new MedarbejderManager();
		currentDate = new Dato(8, 4, 2020);
		
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
		addMedarbToAkt("ADM", "test0", "aktivitets test");
		System.out.println("Aktivitetsdata for projekt test0: " + projekter.getProjects().get(0).getAktiviteter().get(0).getAllData());
		
		ConnectionManager.openCon();
	}
	
	public static ProjectManager getProjekter() {
		return ServControll.projekter;
	}
	
	public static Dato getDato() {
		return ServControll.currentDate;
	}
	
	
	
	// RELEVANS TIL AKTIVITETER
	public static int newAktivitet(String projekt, String navn, Dato startUge, Dato slutUge, int budgetTid) {
		ServControll.projekter.getCertainProject(findProjektVedNavn(projekt)).addAktivitet(navn, startUge, slutUge, budgetTid);
		return 0;
	}
	
	public static int addMedarbToAkt (String initialer, String projekt, String aktivitet) {
		ServControll.projekter.getCertainProject(findProjektVedNavn(projekt)).getAktiviteter()
		.get(ServControll.projekter.getCertainProject(findProjektVedNavn(projekt)).getCertainAkt(aktivitet))
		.addMedarbejder(ServControll.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}
	
	/*
	private static int findAktVedNavn(String navn) {
		
	}
	*/
	
	private static int findMedarbVedInit (String init) {
		for (Medarbejder m : medarbejdere.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return ServControll.medarbejdere.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	
	// RELEVANS TIL PROJEKTER
	
	public static int newProjekt(String navn, Medarbejder projektLeder, Dato startUge, Dato slutUge) {
		System.out.println(projektLeder.getInitialer() + " tries to create project " + navn);
		try {
			projekter.addProject(navn, projektLeder, startUge, slutUge);
			}
			catch ( NullPointerException e)
			{
				System.out.println(e);
				return 1;
			}
		return 0;
	}
	
	public static int addMedarbToProj (String initialer, String projekt) {
		ServControll.projekter.getCertainProject(findProjektVedNavn(projekt))
		.addMedarbejder(ServControll.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}
	
	private static int findProjektVedNavn(String navn) {
		for (Project p : projekter.getProjects())
		{
			if (p.getNavn().equalsIgnoreCase(navn))
				return ServControll.projekter.getProjects().indexOf(p);
		}
		return -1;
	}
	
	
}