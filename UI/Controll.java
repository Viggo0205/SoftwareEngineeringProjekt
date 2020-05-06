
public class Controll {

	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	public static boolean ready;
	private static String[] sQueue;
	public static String[] projektListe;
	private static String[] loginModt;
	public static Dato currentDag;
	private static String[] datoArray = new String[3];
	private static String[] ledigMedarbListe;


	public static void main(String[] args) {		
		Thread t = new Thread(new Communicator());
		t.start();
		Login.menu();

		while(true) {
			if(!ready) {
				if(sQueue[0].equals("0")) {						// login svar
					loginModt = sQueue[1].split(";");
					if(loginModt[0].equals("200")) { 		// godkendt login, indstil dato
						datoArray = sQueue[1].split(",");
						currentDag = new Dato(Integer.parseInt(datoArray[0]),Integer.parseInt(datoArray[1]),Integer.parseInt(datoArray[2]));
					} else {
						Login.failed();
						// fejlet loggin
					}
				} else if(sQueue[0].equals("placeholder")) {	// modtagelse af projekt liste
					projektListe = sQueue[1].split(";");
					proListModt();
				} else if(sQueue[0].equals("placeholder2")) {	// modtagelse af aktiviteter

				} else if(sQueue[0].equals("i")) { 				// svar ledeige medarbejdere
					ledigMedarbListe = sQueue[1].split(";");
					UserInterface.log.append("Ledige medarbejdere i perioden er: " + ledigMedarbListe.toString());
				} else {

				}

			} else { // fejl i protokolkode
				System.out.println("ukendt protokolkode: " + sQueue[0]);
			}
		}
	}



	public static boolean isEmployee(String initialer) {
		for(int i = 0 ; i < employees.length ; i++)
			if(employees[i].equalsIgnoreCase(initialer))
				return true;
		return false;
	}

	public static void loggedIn() {
		Login.bund.setText("logget ind");
		UserInterface.menu();
	}

	public static void msgQueue(String[] sa) {
		ready = false;
		System.out.println(sa[0] + sa[1] + "sat i msgQueue");
		//sQueue = sa;
	}

	public void OpretAktiv(String projekt, String startUge, String slutUge, String timer) {
		Communicator.sendOpretAktiv(projekt, startUge, slutUge, timer);
	}
	/*
	 * Metoder for, hvis der er modtaget en projektliste eller en 
	 * aktivitetsliste fra serveren.
	 * Det sidst efterspurgte popup �bnes.
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
		} else if(UserInterface.windowWait.equals("maAkt4")) {	// S�g hj�lp fra anden udvikler
			soegHjaelp.popup();
		} else if(UserInterface.windowWait.equals("maAkt3")) {	// Ret registrerede timer
			RegistrerTimer.popup();
		} else if(UserInterface.windowWait.equals("leAkt4")) {	// se tidsbrug 
			TidBrugtAktivitet.popup();
		}
	}
	//
}