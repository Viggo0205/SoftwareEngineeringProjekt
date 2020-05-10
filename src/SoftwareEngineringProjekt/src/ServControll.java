// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Exceptions.EmployeeAlreadyExistsException;
import Exceptions.InitialsWrongLengthException;

public class ServControll {
	
	static Boolean running;
	// private static List<String[]> msgQueue = new ArrayList<String[]>();
	static String[] request;
	
	private static ProjectManager projekter;
	private static MedarbejderManager medarbejdere;
	private static Dato currentDate;
	private ConnectionManager connectionManager;
	public static List<String[]> msgQueue = new ArrayList<String[]>();
	public static List<Long> queue = new ArrayList<Long>();
	
	public static void ServerStart(int day, int month, int year) {
		projekter = new ProjectManager();
		medarbejdere = new MedarbejderManager();
		currentDate = new Dato(day, month, year);

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

//		connectionManager = new ConnectionManager();
		//connectionManager.openCon();
		Thread t = new Thread(new ConnectionManager());
		t.start();

		//msgHandling();
		while (true)
		{
			try {
				 TimeUnit.MILLISECONDS.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			System.out.println("yayy");
		}
	}
	
	public static ArrayList<Project> getProjekter() {
		return ServControll.projekter.getProjects();
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
	
	public static int findMedarbVedInit (String init) {
		for (Medarbejder m : ServControll.medarbejdere.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return ServControll.medarbejdere.getMedarbejdere().indexOf(m);
		}
		return -1;
	}
	
	// RELEVANS TIL PROJEKTER
	
	public static int newProjekt(String navn, Medarbejder projektLeder, Dato startUge, Dato slutUge) {
		System.out.println(projektLeder.getInitialer() + " tries to create project " + navn);
		String projektNummer;
		if (ServControll.projekter.getProjektListLength() > 0)
		{
			// Sidste oprettede projekts fulde nummer
			String s = ServControll.projekter.getProjects().get(ServControll.projekter.getProjektListLength() - 1).getProjektNummer();
			if ( s.substring(0, 4).equals(Integer.toString(ServControll.currentDate.getYear())))
			{
				if ( s.substring(4, 10).equals("999999") )
				{
					throw new NullPointerException("No more room for projects this year");
				}
				else
					projektNummer = Integer.toString(ServControll.currentDate.getYear()) + nulStuff(Integer.toString(Integer.parseInt(s.substring(4, 10)) + 1));
			}
			else 
			{
				projektNummer = "" + ServControll.currentDate.getYear() + "000000";
			}
		}
		else projektNummer = "" + ServControll.currentDate.getYear() + "000000";
		ServControll.projekter.addProject(new Project(navn, projektLeder, startUge, slutUge, projektNummer));
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
		ServControll.projekter.getCertainProject(findProjektVedNavn(projekt))
		.addMedarbejder(ServControll.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}
	
	private static int findProjektVedNavn(String navn) {
		for (Project p : ServControll.projekter.getProjects())
		{
			if (p.getNavn().equalsIgnoreCase(navn))
				return ServControll.projekter.getProjects().indexOf(p);
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
		return ServControll.medarbejdere.getMedarbejdere();
	}
	
	public static void nyDato(int day, int month, int year) {
		ServControll.currentDate = new Dato(day, month, year);
	}
	
	public static void queueMsg (String[] s) {
		msgQueue.add(s);
	}

	public static void queue(long id) {
		queue.add(id);
		
	}

	public static String packagedProj() {
		return projekter.pakString();
	}
	
	public static String packagedProjMedAkt() {
		return projekter.pakStringMedAkt();
	}
	
//public static void msgHandling() {
//		
//		System.out.println("Starter");
//		running = true;
//		while (running)
//		{
//			if (ServControll.msgQueue.size() > 0)
//			{
//				request = ServControll.msgQueue.get(0);
//				ServControll.msgQueue.remove(0);
//				if (request[0].equals("0"))
//				{
//					System.out.println("yay");
//				}
//				else if (request[0].equals("0"))
//				{
//					
//				}
//				else if (request[0].equals("1"))
//				{
//					
//				}
//				else if (request[0].equals("2"))
//				{
//					
//				}
//				else if (request[0].equals("3"))
//				{
//					
//				}
//				else if (request[0].equals("4"))
//				{
//					
//				}
//				else if (request[0].equals("a"))
//				{
//					
//				}
//				else if (request[0].equals("b"))
//				{
//					
//				}
//				else if (request[0].equals("c"))
//				{
//					
//				}
//				else if (request[0].equals("d"))
//				{
//					
//				}
//				else if (request[0].equals("e"))
//				{
//					
//				}
//				else if (request[0].equals("f"))
//				{
//					
//				}
//				else if (request[0].equals("g"))
//				{
//					
//				}
//				else if (request[0].equals("h"))
//				{
//					
//				}
//				else if (request[0].equals("i"))
//				{
//					
//				}
//				else if (request[0].equals("j"))
//				{
//					
//				}
//				else if (request[0].equals("k"))
//				{
//					
//				}
//				else
//				{
//					
//				}
//			}
//			try {
//				 TimeUnit.MILLISECONDS.sleep(50);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		}
//	}
}
