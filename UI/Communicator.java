// Skrevet af Rasmus Nyhus - s194285
/*
 * Klasse til at oprette forbindelse til server,
 * sende og modtage beskeder til/fra serveren 
 * og sende beskeder med rigtig protokol/formatering,
 * så serveren kan læse det.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import SoftwareEngineringProjekt.src.Dato;


public class Communicator implements Runnable {

	static Socket s = null;
	static InputStream inps = null;
	static DataInputStream dinp = null;
	static DataOutputStream doutp = null;
	public boolean comModRun = false;
	private String[] ca = new String[2];
	private static String sendMsg;
	private static String projektnr;
	private static Dato datoFormated;
	private static Dato dato1;
	private static Dato dato2;

	@Override
	public void run() {
		comModRun = true;

		// der forsøges at oprette kontakt til serveren
		try {
			s = new Socket("localhost", 8085);
		} catch (IOException ioe) {
			System.err.println("Server can't be reached");
		}

		// in- og output initieres
		try {
			inps = s.getInputStream();
			dinp = new DataInputStream(inps);

		} catch (IOException ioe) {
			System.err.println("does socket s not exist?");
		} catch (Exception e) {
			System.err.println("netin not initiated");
		}
		try {
			doutp = new DataOutputStream ( s.getOutputStream() );

		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("pw not initiated");
		}

		// loop, der løbende læser nye beskeder sendt fra serveren
		boolean moreData = false;
		while(comModRun) {
			if (Controll.ready) {
				try {
					if (dinp.available() > 0) {
						System.out.println("der er kommet data");
						UserInterface.greyIn();
						moreData  = true;
					}
					else
						moreData = false;
				} catch (IOException e) { 
					e.printStackTrace(); 
				}

				if (moreData) {			// hvis der er kommet en besked, sendes til til msgQueue
					try {
						ca = dinp.readUTF().split(";",2);
						System.out.println("ca længde " + ca.length);
						System.out.println(ca[1]);
						Controll.msgQueue(ca);
					} catch (IOException e) { 
						e.printStackTrace(); 
					}
				}
			}
			try {
				TimeUnit.MILLISECONDS.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	// her fra begynder metoderne, der formaterer beskeden korrekt til at serveren kan læse dem
	// *	

	// generelle forespørgsler
	// for login
	public static void sendLogin(String initialer) {	
		System.out.println("sender login som: " + "0;" + initialer);
		sendBesked("0;" + initialer);
	}
	// projekter, brugeren er leder for
	public static void sendProjAccess() {
		System.out.println("sender ønske om en prjektliste med besked 1");
		sendBesked("1");
	}
	// projekter og aktiveteter, brugeren er en del af
	public static void sendAktivAccess() {
		sendBesked("2");
	}
	// medarbejderliste for hele firmaet
	public static void sendMedarbAccess() {
		sendBesked("3");
	}
	// aktiviteter, brugeren er en del af, samt fuld medarbejderliste
	public static void sendMedAktAccess() {
		sendBesked("4");
	}
	// aktiviteter, brugeren er leder for
	public static void sendAktLedAccess() {
		sendBesked("5");
	}
	// projekter, brugeren er leder for, samt fuld medarbejderliste
	public static void sendAktLedMedAccess() {
		sendBesked("6");
	}

	// mere specifikke beskeder til serveren
	//
	public static void sendOpretAktiv(String projekt, String startUge, String slutUge, String timer, String navn) {
		projektnr = projekt.substring(0,10);
		stringUgeToDato(startUge);
		dato1 = datoFormated;
		stringUgeToDato(slutUge);
		dato2 = datoFormated;
		sendMsg = "a;" + projektnr + ";" + dato1.getFormatedDate()  + ";" + dato2.getFormatedDate() + ";" + timer + ";" + navn;
		sendBesked(sendMsg);
	}
	public static void sendTildelAkt(String projekt, String aktivitet, String udvikler) {
		projektnr = projekt.substring(0,10);
		sendMsg = "b;" + projektnr + ";" + aktivitet + ";" + udvikler;
		sendBesked(sendMsg);
	}
	public static void sendSkafRapport(String projekt) {
		projektnr = projekt.substring(0, 10);
		sendMsg = "c;" + projektnr;
		sendBesked(sendMsg);
	}
	public static void sendRegistrerFerie(String startDato, String slutDato) {
		stringDagToDato(startDato);
		dato1 = datoFormated;
		stringDagToDato(slutDato);
		dato2 = datoFormated;
		sendMsg = "d;" + dato1.getFormatedDate() + ";" + dato2.getFormatedDate();
		sendBesked(sendMsg);
	}
	public static void sendSoegHjaelp(String projekt, String aktivitet, String udvikler) {
		projektnr = projekt.substring(0,10);
		sendMsg = "e;" + projektnr + ";" + aktivitet + ";" + udvikler;
		sendBesked(sendMsg);
	}
	public static void sendRetterTimer(String projekt, String aktivitet, String dag, String timer) {
		projektnr = projekt.substring(0,10);
		stringDagToDato(dag);
		dato1 = datoFormated;
		sendMsg = "f;" + dato1.getFormatedDate() + ";" + timer + ";" + projektnr + ";" + aktivitet;
		sendBesked(sendMsg);
	}
	public static void sendOpretPro(String leder, String startDato, String slutDato, String navn) {
		stringDagToDato(startDato);
		dato1 = datoFormated;
		stringDagToDato(slutDato);
		dato2 = datoFormated;
		sendMsg = "g;" + leder + ";" + dato1.getFormatedDate() + ";" + dato2.getFormatedDate() + ";" + navn;
		sendBesked(sendMsg);
	}
	public static void sendIndmeldTid(String projekt, String aktivitet, String dag, String timer) {
		projektnr = projekt.substring(0,10);
		stringDagToDato(dag);
		dato1 = datoFormated;
		sendMsg = "h;" + projektnr + ";" + aktivitet + ";" + dato1.getFormatedDate() + ";" + timer;
		sendBesked(sendMsg);
	}
	public static void sendErLedig(String uge) {
		stringUgeToDato(uge);
		dato1 = datoFormated;
		sendMsg = "i;" + dato1;
		sendBesked(sendMsg);
	}
	public static void sendTidsbrug(String projekt, String aktivitet) {
		projektnr = projekt.substring(0,10);
		sendMsg = "j;" + projektnr + ";" + aktivitet;
		sendBesked(sendMsg);
	}
	public static void sendSeArbejde() {
		sendMsg = "k";
		sendBesked(sendMsg);
	}

	// afsender besked til serveren
	public static void sendBesked(String sendMessage) {
		System.out.println("sender besked til server: " + sendMessage);
		try {
			doutp.writeUTF(sendMessage);
			doutp.flush();
			sendMsg = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(UserInterface.log == null) {}
		else {
			UserInterface.greyOut();
		}
	}

	private static void stringDagToDato(String dagdato) {
		datoFormated = new Dato(Integer.parseInt(dagdato.substring(0,2)),Integer.parseInt(dagdato.substring(2,4)),Integer.parseInt(dagdato.substring(4,8)));
	}
	private static void stringUgeToDato(String ugedato) {
		String[] ss = ugedato.split("\\.");
		datoFormated = new Dato(Integer.parseInt(ss[1]),Integer.parseInt(ss[0]));
	}
}
