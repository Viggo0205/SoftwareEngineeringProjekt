/*
 * Klasse til hovedsageligt at håndtere forskellige beskeder sendt fra serveren,
 * men generelt også til nogle af de mere grundlæggende funktioner i klienten.
 */

import java.util.ArrayList;
//import SoftwareEngineringProjekt.src.Dato;

public class Controll {

	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"}; // test array
	public static boolean ready;
	private static String[] sQueue;
//	public static String[] projektListe = new String[] {"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	public static ArrayList<String> projektListe = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> aktivListe = new ArrayList<ArrayList<String>>();
	public static ArrayList<String> choiseAktivListe = new ArrayList<String>();
	private static String[] loginModt;
	public static Dato currentDag;
	private static String[] datoArray = new String[3];
	private static String[] ledigMedarbListe;


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
//					projektListe = sQueue[1].split(";");
					proListModt();
				} else if(sQueue[0].equals("placeholder2")) {	// modtagelse af aktiviteter
					lavAktListe(sQueue[1]);
					aktListModt();
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


	private static void lavAktListe(String s) {
		String[] ssPro = s.split(";");
		for(int i = 0; i < ssPro.length; i++)
			lavAktListe2(i,ssPro);
	}


	private static void lavAktListe2(int i, String[] ssPro) {
		String[] ssAkt = ssPro[i].split(":");
		projektListe.add(ssAkt[0]);
		ArrayList<String> tempAktList = new ArrayList<String>();
		for(int j = 0; j < ssAkt.length; j++)
			tempAktList.add(ssAkt[j]);
		aktivListe.add(tempAktList);
	}

	private static void chooseAktiv(int i) {
		for(int j = 1; j<aktivListe.get(i).size(); j++)
			choiseAktivListe.add(aktivListe.get(i).get(j));
	}
	
	private static void lavProListe(String s) {
		String[] ss = s.split(";");
		for(int i = 0; i < ss.length; i++)
			projektListe.add(ss[1]);
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
}