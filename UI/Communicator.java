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
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
//
public class Communicator implements Runnable {

	static Socket s = null;
	static InputStream inps = null;
	static DataInputStream dinp = null;
	static DataOutputStream doutp = null;
//	static PrintWriter pw = null;
//	static Scanner netin = null;
	public boolean comModRun = false;
	private boolean listening = true;
	private String[] ca = new String[2];
	private static String sendMsg;

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

//			netin = new Scanner(s.getInputStream());
		} catch (IOException ioe) {
			System.err.println("does socket s not exist?");
		} catch (Exception e) {
			System.err.println("netin not initiated");
		}
		try {
			doutp = new DataOutputStream ( s.getOutputStream() );
			
//			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("pw not initiated");
		}
		
		boolean moreData = false;
		// loop, der løbende læser nye beskeder sendt fra serveren
		while(comModRun) {
			if (Controll.ready) {
				try {
					if (dinp.available() > 0)
						moreData  = true;
					else
						moreData = false;
				} catch (IOException e) { 
					e.printStackTrace(); 
				}
				
				if (moreData) {
					try {
						ca = dinp.readUTF().split(";",2);
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
	
	// sender ønske om login med brugerens initialer
	public static void sendLogin(String initialer) {	
		sendBesked("0;" + initialer);
	}
	// sender besked om, klienten vil kende sine projekter
	public static void sendProjAccess() {
		sendBesked("1");
	}
	// sender besked om, klienten vil kende sine projekter og aktiviteter
	public static void sendAktivAccess() {
		sendBesked("2");
	}
	// sender forespørgsel om medarbejderliste
	public static void sendMedarbAccess() {
		sendBesked("3");
	}
	public static void sendMedAktAccess() {
		sendBesked("4");
	}
	
	// metoder for at sende beskeder til serveren afhængig af hvilket event.
	public static void sendOpretAktiv(String projekt, String startUge, String slutUge, String timer) {
		sendMsg = "a;" + projekt + ";" + startUge  + ";" + slutUge + ";" + timer;
		sendBesked(sendMsg);
	}
	public static void sendTildelAkt(String projekt, String aktivitet, String udvikler) {
		sendMsg = "b;" + projekt + ";" + aktivitet + ";" + udvikler;
		sendBesked(sendMsg);
	}
	public static void sendSkafRapport(String projekt) {
		sendMsg = "c;" + projekt;
		sendBesked(sendMsg);
	}
	public static void sendRegistrerFerie(String startDato, String slutDato) {
		sendMsg = "d;" + startDato + ";" + slutDato;
		sendBesked(sendMsg);
	}
	public static void sendSoegHjaelp(String projekt, String aktivitet, String udvikler) {
		sendMsg = "e;" + projekt + ";" + aktivitet + ";" + udvikler;
		sendBesked(sendMsg);
	}
	public static void sendRetterTimer(String dato, String timer) {
		sendMsg = "f;" + dato + ";" + timer;
		sendBesked(sendMsg);
	}
	public static void sendOpretPro(String leder, String beskrivelse, String startDato, String slutDato) {
		sendMsg = "g;" + leder + ";" + beskrivelse + ";" + startDato + ";" + slutDato;
		sendBesked(sendMsg);
	}
	public static void sendIndmeldTid(String projekt, String aktivitet, String dag, String timer) {
		sendMsg = "h;" + projekt + ";" + aktivitet + ";" + dag + ";" + timer;
		sendBesked(sendMsg);
	}
	public static void sendErLedig(String uge) {
		sendMsg = "i;" + uge;
		sendBesked(sendMsg);
	}
	public static void sendTidsbrug(String projekt, String aktivitet) {
		sendMsg = "j;" + projekt + ";" + aktivitet;
		sendBesked(sendMsg);
	}
	public static void sendSeArbejde(String startDato, String slutDato) {
		sendMsg = "k;" + startDato + ";" + slutDato;
		sendBesked(sendMsg);
	}
	
	public static void sendBesked(String sendMessage) {
		try {
			doutp.writeUTF(sendMessage);
			doutp.flush();
			sendMsg = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
