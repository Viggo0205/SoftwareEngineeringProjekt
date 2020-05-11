/*
 * Klasse til hovedsageligt at håndtere forskellige beskeder sendt fra serveren,
 * men generelt også til nogle af de mere grundlæggende funktioner i klienten.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import SoftwareEngineringProjekt.src.Dato; // skal fjernes senere, når server og klient adskilles
//
public class Controll {


	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"}; // test array
	public static boolean ready;
	private static String[] sQueue = new String[]{"",""};
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
	private static String[] tempSplit1;
	private static String[] tempSplit2;
	private static String[] tempSplit3;


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
		ready = true;
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while(true) {

			if(!ready) {
				//				System.out.println("in loop not rdy");
				if(sQueue[0].equals("0")) {						// login svar
					System.out.println("modtaget svar på login");
					loginModt = sQueue[1].split(",");
					if(loginModt[0].equals("ok")) { 		// godkendt login, indstil dato
						System.out.println("login godkendt");
						datoArray = loginModt[1].split("-");
						currentDag = new Dato(Integer.parseInt(datoArray[0]),Integer.parseInt(datoArray[1]),Integer.parseInt(datoArray[2]));
						loggedIn();
					} else {
						System.out.println("login afvist");
						Login.failed();
						// fejlet loggin
					}
				} else if(sQueue[0].equals("1")) {	// modtagelse af projekt liste
					System.out.println("prjektliste modtaget");
					if(sQueue.length > 1) {
						lavProListe(sQueue[1]);
						proListModt();
					} else {
						proListEmpty();
					}
				} else if(sQueue[0].equals("2")) {	// modtagelse af aktiviteter
					lavAktListe(sQueue[1]);
					aktListModt();
				} else if(sQueue[0].equals("3")) {	// modtagelse af medarbejderliste
					lavMedarbListe(sQueue[1]);
					medarbListModt();
				} else if(sQueue[0].equals("4")) {	// modtagelse af aktiv+medarb lister
					aktMedaLists = sQueue[1].split("\\|;");
					lavAktListe(aktMedaLists[0]);
					lavMedarbListe(aktMedaLists[1]);
					aktMedaListsModt();
				} else if(sQueue[0].equals("5")) {
					lavAktListe(sQueue[1]);
					aktLedModt();
				} else if(sQueue[0].equals("6")) {
					aktMedaLists = sQueue[1].split("-");
					lavAktListe(aktMedaLists[0]);
					lavMedarbListe(aktMedaLists[1]);
					aktLedMedModt();
				} else if(sQueue[0].equals("7")) {
					UserInterface.log.append(sQueue[1] + "\n");
					sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
					ready = true;
				} else if(sQueue[0].equals("8")) {
					if(sQueue[1].equals("ok")) { 		// godkendt login, indstil dato
						UserInterface.log.append("Dit ønske om fravær er blevet registreret\n");
					} else {
						UserInterface.log.append("Dit ønske om fravær er blevet afvist\n");
					}
					sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
					ready = true;
				} else if(sQueue[0].equals("9")) {
					if(sQueue[1].equals("ok")) { 		// godkendt login, indstil dato
						UserInterface.log.append("Den valgte medarbejder kan nu hjælpe på aktiviteten\n");
					} else {
						UserInterface.log.append("Dit ønske om hjælp har givet fejl\n");
						System.out.println("ferie afvist");
					}
					sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
					ready = true;
				}
				
				
				else if(sQueue[0].equals("10")) {
					if(sQueue[1].equals("ok")) { 		// godkendt login, indstil dato
						UserInterface.log.append("Dine timer er blevet rettet\n");
					} else {
						UserInterface.log.append("Der skete en fejl i registrering af dine timer\n");
					}
					sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
					ready = true;
				}
				
				
				else if(sQueue[0].equals("15")) { 
					if(sQueue[1].equals("no")) {
						UserInterface.log.append("Du har ingen arbejdstimer registreret for i dag\n");
					} else {
						tempSplit1 = sQueue[1].split(";");
						UserInterface.log.append("Du har arbejdet " + (Double.parseDouble(tempSplit1[1])/2) + " timer i dag\n");
						tempSplit2 = tempSplit1[0].split(":");
						for(int i = 1; i < tempSplit2.length; i++) {
							tempSplit3 = tempSplit2[i].split("\\|",2);
							UserInterface.log.append((Double.parseDouble(tempSplit3[1])/2) + " timer brugt på " + tempSplit3[0] + "\n");
							tempSplit3 = null;
						}
						tempSplit1 = null;
						tempSplit2 = null;
					}
					sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
					ready = true;
				}

				else if(sQueue[0].equals("i")) { 				// svar ledeige medarbejdere
					ledigMedarbListe = sQueue[1].split(";");
					UserInterface.log.append("Ledige medarbejdere i perioden er: " + ledigMedarbListe.toString());
				} else {					// mange flere...
					System.out.println("ukendt protokolkode: " + sQueue[0]);
					System.out.println("besked: " + sQueue[1]);
				}

			} else { 
				System.out.print("");
			}
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
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
	}	private static void lavAktListe2(int i, String[] ssPro) {
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
		System.out.println(s);
		String[] ss = s.split(";");
		for(int i = 0; i < ss.length; i++) {
			projektListe.add(ss[i]);
			//			System.out.print(ss[i] + "    ");
		}
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
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}

	public static void msgQueue(String[] sa) {
		ready = false;
		System.out.println("sa længde " + sa.length);
		System.out.println(Arrays.toString(sa) + " er sat i msgQueue");
		sQueue[0] = sa[0];
		if(sa.length == 2)
			sQueue[1] = sa[1];
		System.out.println("sQueue er" + Arrays.toString(sQueue));
	}


	/*
	 * Metoder for, hvis der er modtaget en projektliste eller en 
	 * aktivitetsliste fra serveren.
	 * Det sidst efterspurgte popup åbnes.
	 */
	public static void proListModt() { // 1
		System.out.println(UserInterface.windowWait);
		if(UserInterface.windowWait.equals("leAkt1")) {			// Bestil ny aktivitet
			BestilAktvitet.popup();
		} else if(UserInterface.windowWait.equals("leAkt5")) {	// skaf rapport
			SkafRapport.popup();
		} 
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}
	public static void proListEmpty() {
		UserInterface.log.append("Du er ikke leder for nogle projekter");
		System.out.println("Du er ikke leder for nogle projekter");
		
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}
	public static void aktListModt() { // 2
		if(UserInterface.windowWait.equals("leAkt2")) {			// Tildel opgaver til udvikler
			TildelAktivitet.popup();
		} else if(UserInterface.windowWait.equals("maAkt4")) {	// Søg hjælp fra anden udvikler
			soegHjaelp.popup();
		} else if(UserInterface.windowWait.equals("maAkt3")) {	// Ret registrerede timer
			RetTimer.popup();
		} else if(UserInterface.windowWait.equals("maAkt6")) {	// Registrer brugte timer
			RegistrerTimer.popup();
		}	
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}
	
	private static void medarbListModt() { // 3
		if(UserInterface.windowWait.equals("maAkt5"))
			OpretProjekt.popup();
	}
	private static void aktMedaListsModt() { // 4
		if(UserInterface.windowWait.equals("maAkt4")) {
			soegHjaelp.popup();
		}
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}
	private static void aktLedModt() { // 5
		if(UserInterface.windowWait.equals("leAkt4")) {	// se tidsbrug 
			TidBrugtAktivitet.popup();
		}
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
	}
	private static void aktLedMedModt() { // 6
		if(UserInterface.windowWait.equals("leAkt2")) {
			TildelAktivitet.popup();
		}
		sQueue[0] = "";if(sQueue.length > 1) {sQueue[1] = "";}
		ready = true;
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

