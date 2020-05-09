/*
 * Klasse til hovedsageligt at håndtere forskellige beskeder sendt fra serveren,
 * men generelt også til nogle af de mere grundlæggende funktioner i klienten.
 */

import java.util.ArrayList;
import java.util.List;

import SoftwareEngineringProjekt.src.Dato; // skal fjernes senere, når server og klient adskilles
//
public class Controll {

	
	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"}; // test array
	public static boolean ready;
	private static String[] sQueue;
//	public static String[] projektListe = new String[] {"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	public static List<String> projektListe = new ArrayList<String>();
	public static List<ArrayList<String>> aktivListe = new ArrayList<ArrayList<String>>();
	public static List<String> choiseAktivListe = new ArrayList<String>();
	public static List<String> medarbejderListe = new ArrayList<String>();
	private static String[] loginModt;
	public static Dato currentDag;
	private static String[] datoArray = new String[3];
	private static String[] ledigMedarbListe;
	private static String[] aktMedaLists = new String[2];


	public static void main(String[] args) {	
		// opretter thread, så communicator kan køre frit og afvente beskeder
		Thread t = new Thread(new Communicator());
		t.start();
		
		// åbner login menuen
		Login.menu();
		
		/*
		 * store loop, der håndterer indgående beskeder.
		 * Liste over protokolkoder findes i bilag.
		 */
		while(true) {
			if(!ready) {
				if(sQueue[0].equals("0")) {						// login svar
					loginModt = sQueue[1].split(";");
					if(loginModt[0].equals("200")) { 		// godkendt login, indstil dato
						datoArray = sQueue[1].split(",");
						currentDag = new Dato(Integer.parseInt(datoArray[0]),Integer.parseInt(datoArray[1]),Integer.parseInt(datoArray[2]));
						loggedIn();
					} else {
						Login.failed();
						// fejlet loggin
					}
				} else if(sQueue[0].equals("placeholder")) {	// modtagelse af projekt liste
					lavProListe(sQueue[1]);
					proListModt();
				} else if(sQueue[0].equals("placeholder2")) {	// modtagelse af aktiviteter
					lavAktListe(sQueue[1]);
					aktListModt();
				} else if(sQueue[0].equals("placeholder3")) {	// modtagelse af medarbejderliste
					lavMedarbListe(sQueue[1]);
					medarbListModt();
				} else if(sQueue[0].equals("placeholder4")) {	// modtagelse af aktiv+medarb lister
					aktMedaLists = sQueue[1].split("-");
					lavAktListe(aktMedaLists[0]);
					lavMedarbListe(aktMedaLists[1]);
					aktMedaListsModt();
				} else if(sQueue[0].equals("i")) { 				// svar ledeige medarbejdere
					ledigMedarbListe = sQueue[1].split(";");
					UserInterface.log.append("Ledige medarbejdere i perioden er: " + ledigMedarbListe.toString());
				} else {					// mange flere...

				}

			} else { // fejl i protokolkode
				System.out.println("ukendt protokolkode: " + sQueue[0]);
			}
		}
	}

	private static void lavMedarbListe(String s) {
		String[] ss = s.split(";");
		for( int i = 0; i < ss.length; i++)
			medarbejderListe.add(ss[i]);
	}


	private static void lavAktListe(String s) {
		String[] ssPro = s.split(";");
		for(int i = 0; i < ssPro.length; i++)
			lavAktListe2(i,ssPro);
	}


	private static void lavAktListe2(int i, String[] ssPro) {
		String[] ssAkt = ssPro[i].split(":");
		projektListe.add(ssAkt[0]);
		List<String> tempAktList = new ArrayList<String>();
		for(int j = 0; j < ssAkt.length; j++)
			tempAktList.add(ssAkt[j]);
		aktivListe.add((ArrayList<String>) tempAktList);
	}

	public static void chooseAktiv(int i) {
		choiseAktivListe.clear();
		for(int j = 1; j<aktivListe.get(i).size(); j++)
			choiseAktivListe.add(aktivListe.get(i).get(j));
	}
	
	private static void lavProListe(String s) {
		String[] ss = s.split(";");
		for(int i = 0; i < ss.length; i++)
			projektListe.add(ss[i]);
	}


	// testkode ind til communicator og server virker
	public static boolean isEmployee(String initialer) {
		for(int i = 0 ; i < employees.length ; i++)
			if(employees[i].equalsIgnoreCase(initialer))
				return true;
		return false;
	}

	// metode kaldes, hvis login går gennem
	public static void loggedIn() {
		Login.bund.setText("logget ind");
		UserInterface.menu();
	}

	// metode kaldes, når der modtages en nu besked med krav på, klienten var klar til at modtage den
	public static void msgQueue(String[] sa) {
		ready = false;
		System.out.println(sa[0] + sa[1] + "sat i msgQueue");
		sQueue = sa;
	}

	
	public void OpretAktiv(String projekt, String startUge, String slutUge, String timer) {
		Communicator.sendOpretAktiv(projekt, startUge, slutUge, timer);
	}
	
	/*
	 * Metoder for, hvis der er modtaget en projektliste eller en 
	 * aktivitetsliste fra serveren.
	 * Det sidst efterspurgte popup åbnes.
	 */
	public static void proListModt() {
		if(UserInterface.windowWait.equals("leAkt1")) {			// Bestil ny aktivitet
			BestilAktvitet.popup();
		} else if(UserInterface.windowWait.equals("leAkt5")) {	// skaf rapport
			SkafRapport.popup();
		} 
	}
	public static void aktListModt() {
		if(UserInterface.windowWait.equals("leAkt2")) {			// Tildel opgaver til udvikler
			TildelAktivitet.popup();
		} else if(UserInterface.windowWait.equals("maAkt4")) {	// Søg hjælp fra anden udvikler
			soegHjaelp.popup();
		} else if(UserInterface.windowWait.equals("maAkt3")) {	// Ret registrerede timer
			RegistrerTimer.popup();
		} else if(UserInterface.windowWait.equals("leAkt4")) {	// se tidsbrug 
			TidBrugtAktivitet.popup();
		}
	}
	private static void medarbListModt() {
		if(UserInterface.windowWait.equals("maAkt5"))
			OpretProjekt.popup();
	}
	private static void aktMedaListsModt() {
		if(UserInterface.windowWait.equals("leAkt2")) {
			TildelAktivitet.popup();
		} else if(UserInterface.windowWait.equals("maAkt4")) {
			soegHjaelp.popup();
		}
		
	}
	
	public static boolean isValidWeek(String weekString) {
		String[] weekArray = weekString.split("\\.");
		try {
			if(weekArray.length != 2) {
				return false;
			} else if (Integer.parseInt(weekArray[0]) > 2050 || Integer.parseInt(weekArray[0]) < 1990 
					|| Integer.parseInt(weekArray[1]) > 54 || Integer.parseInt(weekArray[1]) < 0) {
				return false;
			}else { 
				return true;
			}
		} catch(NumberFormatException err){
			 UserInterface.log.append("Fejl i input. Format for uge 5 i år 2018: 2018.5\nFormat for tid er tal\n");
			 return false;
		}
		
		 
	}
	public static boolean isWeekOrdered(String weekString1, String weekString2) {
		String[] weekArray1 = weekString1.split("\\.");
		String[] weekArray2 = weekString2.split("\\.");
		try {
			Dato dato1 = new Dato(Integer.parseInt(weekArray1[1]), Integer.parseInt(weekArray1[0]) );
			Dato dato2 = new Dato(Integer.parseInt(weekArray2[1]), Integer.parseInt(weekArray2[0]) );
			if(dato1.getDeltaDag(dato2) < 0) {
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException err){
			 UserInterface.log.append("Fejl i input. Format for uge 5 i år 2018: 2018.5\nFormat for tid er tal\n");
			 return false;
		}
		
	}
	public static boolean isValidDato(String datoString) {
		try {
			if(datoString.length() != 8 || datoString.length() != 8 ) {
				return false;
			} else if(Integer.parseInt(datoString.substring(4, 8)) < 1990 || Integer.parseInt(datoString.substring(5, 8)) > 2050 
					|| Integer.parseInt(datoString.substring(0, 2)) < 1 || Integer.parseInt(datoString.substring(0, 2)) > 31
					|| Integer.parseInt(datoString.substring(2, 4)) < 1 || Integer.parseInt(datoString.substring(2, 4)) > 12) {
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException err) {
			UserInterface.log.append("Fejl i input. Format for dato 5. april 2018: 05042018\n");
			return false;
		}
	}
	public static boolean isDagOrdered(String dag1, String dag2) {
		try {
			Dato dato1 = new Dato(Integer.parseInt(dag1.substring(0,2)), Integer.parseInt(dag1.substring(2,4)), Integer.parseInt(dag1.substring(4,8)));
			Dato dato2 = new Dato(Integer.parseInt(dag2.substring(0,2)), Integer.parseInt(dag2.substring(2,4)), Integer.parseInt(dag2.substring(4,8)));
			if(dato1.getDeltaDag(dato2) < 0) {
				return false;
			} else {
				return true;
			}	
		} catch (NumberFormatException err) {
			UserInterface.log.append("Fejl i input. Format for dato 5. april 2018: 05042018\n");
			return false;
		}
	}
}