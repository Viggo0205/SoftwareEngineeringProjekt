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

		newProjekt("Fravear", "ADMN", new Dato(1, 1, 2020), new Dato(31, 12, 2050));
		newAktivitet("" + currentDate.getYear() + "000000", "Ferie", new Dato(1, 1, 2020), new Dato(31, 12, 2050), 0);
		newAktivitet("" + currentDate.getYear() + "000000", "Sygdom", new Dato(1, 1, 2020), new Dato(31, 12, 2050), 0);



		newProjekt("test0", "ADMN", new Dato(4, 2020), new Dato(9, 2020));
		newProjekt("test1", "ADMN", new Dato(1, 2020), new Dato(34, 2020));
		newProjekt("test2", "ADMN", new Dato(29, 2020), new Dato(52, 2020));

		System.out.println("Projekter: ");
		for (Project p : projekter.getProjects())
		{
			p.addMedarbejder(medarbejdere.getMedarbejdere().get(0));
			System.out.println(p.getNavn() + " " + p.getProjektNummer() + " med startuge: " + p.getStartUge() + " og slutuge: " + p.getSlutUge());
			System.out.println(new Dato(9,2020).getFormatedDate());
		}
		System.out.println("Medarbejdere: ");
		for (Medarbejder m : medarbejdere.getMedarbejdere())
			System.out.println(m.getInitialer());
		System.out.println("Dags dato: " + currentDate.getFormatedDate());

		newAktivitet("" + currentDate.getYear() + "000001", "aktivitets test", new Dato(1, 2020), new Dato(3, 2020), 7);
		addMedarbToAkt("ADMN", "test0", "aktivitets test");
		System.out.println("Aktivitetsdata for projekt " + projekter.getProjects().get(0).getNavn() + ": " + projekter.getProjects().get(0).getAktiviteter().get(0).getAllData() + projekter.getProjects().get(0).getAktiviteter().get(1).getAllData());

		/*
		registrerTimer("2020000000", "Ferie", 5, "ADMN", new Dato(20, 6, 2020));
		System.out.println(medarbejdere.getMedarbejdere().get(0).getKalender().getCertainArbejdsdag(0).getTid());
		System.out.println(projekter.getCertainProject(0).getPackagedRapport());
		 */
		for (int i = 1; i < 80; i++)
		{
			System.out.println(new Dato(i, 2020, "s").getFormatedDate());
		}

		registrerFerie("ADMN", "10-3-2020", "20-3-2020");
		System.out.println(projekter.getCertainProject(0).getPackagedRapport());
		for ( int i = 0; i < 10; i++)
			System.out.println(medarbejdere.getMedarbejdere().get(0).getKalender().getCertainArbejdsdag(i).getTid());

		//		connectionManager = new ConnectionManager();
		//connectionManager.openCon();
		Thread t = new Thread(new ConnectionManager());
		t.start();

		//msgHandling();
		/*
		while (true)
		{
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("yayy");
		}
		*/
	}

	public static ArrayList<Project> getProjekter() {
		return ServControll.projekter.getProjects();
	}

	public static Dato getDato() {
		return ServControll.currentDate;
	}



	// RELEVANS TIL AKTIVITETER
	public static String newAktivitet(String projekt, String navn, Dato startUge, Dato slutUge, int budgetTid) {
		if ( projekter.getCertainProject(findProjektVedId(projekt)).findAktVedNavn(navn) == -1 )
		{
			ServControll.projekter.getCertainProject(findProjektVedId(projekt)).addAktivitet(navn, startUge, slutUge, budgetTid);
			return "ok";
		}
		else
			return "no";
	}

	public static String addMedarbToAkt (String initialer, String projekt, String aktivitet) {
		if (findProjektVedId(projekt) >= 0)
		{
			if ( ServControll.projekter.getCertainProject(findProjektVedId(projekt)).getAktiviteter()
					.get(ServControll.projekter.getCertainProject(findProjektVedId(projekt)).findAktVedNavn(aktivitet)).findMedarbVedInit(initialer) == -1 )
			{
				ServControll.projekter.getCertainProject(findProjektVedId(projekt)).getAktiviteter()
				.get(ServControll.projekter.getCertainProject(findProjektVedId(projekt)).findAktVedNavn(aktivitet))
				.addMedarbejder(ServControll.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer, ServControll.medarbejdere.getMedarbejdere())));
				return "ok";
			}
			else
				return "no";
		}
		else
			return "no";
	}

	/*
	private static int findAktVedNavn(String navn) {

	}
	 */

	public static int findMedarbVedInit (String init, ArrayList<Medarbejder> mL) {
		for (Medarbejder m : mL /* ServControll.medarbejdere.getMedarbejdere() */)
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return mL.indexOf(m);
		}
		ServControll.medarbejdere.getMedarbejdere();
		return -1;
	}

	public static int findMedarbVedInit (String init) {
		for (Medarbejder m : ServControll.medarbejdere.getMedarbejdere())
		{
			if (m.getInitialer().equalsIgnoreCase(init))
				return ServControll.medarbejdere.getMedarbejdere().indexOf(m);
		}
		return -1;
	}

	// RELEVANS TIL PROJEKTER

	public static String newProjekt(String navn, String projektlederInit, Dato startUge, Dato slutUge) {
		int projektlederInd = findMedarbVedInit(projektlederInit);
		if (projektlederInd == -1)
			return "no";

		else
		{
			System.out.println(projektlederInit + " tries to create project " + navn);
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
			ServControll.projekter.addProject(new Project(navn, medarbejdere.getMedarbejdere().get(projektlederInd), startUge, slutUge, projektNummer));
			return "ok";
		}
	}

	private static String nulStuff(String s) {
		for ( int i = 6 - s.length(); i > 0; i--)
		{
			s = "0" + s;
		}
		return s;
	}

	public int addMedarbToProj (String initialer, String projekt) {
		ServControll.projekter.getCertainProject(findProjektVedId(projekt))
		.addMedarbejder(ServControll.medarbejdere.getMedarbejdere().get(findMedarbVedInit(initialer)));
		return 0;
	}

	private static int findProjektVedId(String id) {
		for (Project p : ServControll.projekter.getProjects())
		{
			if (p.getProjektNummer().equalsIgnoreCase(id))
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

	public static String packagedProjTake2(String init) {
		return projekter.pakStringTake2(init);
	}

	public static String packagedProjMedAktTake2(String init) {
		return projekter.pakStringMedAktTake2(init);
	}

	public static String packagedMedarb() {
		String s = "";
		for (Medarbejder m : medarbejdere.getMedarbejdere())
			s += ";" + m.getInitialer();
		return s;
	}

	// Til protokol 4
	public static String packagedAkt() {
		String s = "";

		return s;
	}

	public static String packagedRap(String proj) {
		return projekter.getCertainProject(projekter.findProjVedId(proj)).getPackagedRapport();
	}

	public static String registrerFerie(String init, String startDatoString, String slutDatoString) {
		String s = "";
		Dato startDato = new Dato(Integer.parseInt(startDatoString.split("-")[0]), Integer.parseInt(startDatoString.split("-")[1]), Integer.parseInt(startDatoString.split("-")[2]));
		Dato slutDato = new Dato(Integer.parseInt(slutDatoString.split("-")[0]), Integer.parseInt(slutDatoString.split("-")[1]), Integer.parseInt(slutDatoString.split("-")[2]));
		for (int i = new Dato(1,1,startDato.getYear()).getDeltaDag(startDato); i < new Dato(1,1,slutDato.getYear()).getDeltaDag(slutDato) + 1; i++)
			registrerTimer(projekter.getProjects().get(0).getProjektNummer(), "Ferie", 16, init, new Dato(i, startDato.getYear(), "s"));
		s = "ok";
		return s;
	}

	public static String registrerTimer(String proj, String akt, int tid, String init, Dato dag) {
		int medarbInd = findMedarbVedInit(init);
		int arbejdsInd, projInd, aktInd, deltaAktTid;
		if ( medarbInd >= 0 )
		{
			arbejdsInd = medarbejdere.getMedarbejdere().get(medarbInd).getKalender().findArbejdsagIndVedDato(dag);
			if ( arbejdsInd == -1 )
				arbejdsInd = medarbejdere.getMedarbejdere().get(medarbInd).getKalender().newDag(dag);
			deltaAktTid = medarbejdere.getMedarbejdere().get(medarbInd).getKalender().getCertainArbejdsdag(arbejdsInd).addTid(proj, akt, tid);
			projInd = projekter.findProjVedId(proj);
			aktInd = projekter.getCertainProject(projInd).findAktVedNavn(akt);
			projekter.getCertainProject(projInd).getAktiviteter().get(aktInd).addTid(deltaAktTid);
			return "ok";
		}
		else
			return "no";
	}

	public static String packagedAktivitetTid(String projId, String akt) {
		int projInd = projekter.findProjVedId(projId);
		if ( projInd == -1)
			return "no";
		else
		{
			int aktInd = projekter.getCertainProject(projInd).findAktVedNavn(akt);
			if (aktInd == -1)
				return "no";
			else
				return "" + projekter.getCertainProject(projInd).getAktiviteter().get(aktInd).getTime();
		}
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
