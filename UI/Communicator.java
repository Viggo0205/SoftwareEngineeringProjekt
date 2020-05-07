/*
 * Klasse til at oprette forbindelse til server,
 * sende og modtage beskeder til/fra serveren 
 * og sende beskeder med rigtig protokol/formatering,
 * så serveren kan læse det.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Communicator implements Runnable {

	static Socket s = null;
	static PrintWriter pw = null;
	static Scanner netin = null;
	public boolean comModRun = false;
	private boolean listening = true;
	private String[] ca = new String[2];
	private static String sendMsg;

	@Override
	public void run() {
		comModRun = true;
		
		// der forsøges at oprette kontakt til serveren
		try {
			s = new Socket("localhost", 8080);
		} catch (IOException ioe) {
			System.err.println("Socket not opened");
		}
		
		// in- og output initieres
		try {
			netin = new Scanner(s.getInputStream());
		} catch (IOException ioe) {
			System.err.println("does socket s not exist?");
		} catch (Exception e) {
			System.err.println("netin not initiated");
		}
		try {
			pw = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("pw not initiated");
		}
		
		// loop, der løbende læser nye beskeder sendt fra serveren
		while(comModRun) {
			if (Controll.ready) {
				if (netin.hasNext()) {	
					ca = netin.nextLine().split(":",2);
					Controll.msgQueue(ca);
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
		pw.print("0;" + initialer);
		pw.flush();
	}
	// sender besked om, klienten vil kende sine projekter
	public static void sendProjAccess() {
		pw.print("1");
		pw.flush();
	}
	// sender besked om, klienten vil kende sine projekter og aktiviteter
	public static void sendAktivAccess() {
		pw.print("2");
		pw.flush();
	}
	// sender forespørgsel om medarbejderliste
	public static void sendMedarbAccess() {
		pw.print("3");
		pw.flush();
	}
	public static void sendMedAktAccess() {
		pw.print("4");
		pw.flush();
	}
	
	// metoder for at sende beskeder til serveren afhængig af hvilket event.
	public static void sendOpretAktiv(String projekt, String startUge, String slutUge, String timer) {
		sendMsg = "a;" + projekt + ";" + startUge  + ";" + slutUge + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendTildelAkt(String projekt, String aktivitet, String udvikler) {
		sendMsg = "b;" + projekt + ";" + aktivitet + ";" + udvikler;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendSkafRapport(String projekt) {
		sendMsg = "c;" + projekt;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendRegistrerFerie(String startDato, String slutDato) {
		sendMsg = "d;" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendSoegHjaelp(String projekt, String aktivitet, String udvikler) {
		sendMsg = "e;" + projekt + ";" + aktivitet + ";" + udvikler;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendRetterTimer(String dato, String timer) {
		sendMsg = "f;" + dato + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendOpretPro(String leder, String beskrivelse, String startDato, String slutDato) {
		sendMsg = "g;" + leder + ";" + beskrivelse + ";" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendIndmeldTid(String projekt, String aktivitet, String dag, String timer) {
		sendMsg = "h;" + projekt + ";" + aktivitet + ";" + dag + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendErLedig(String uge) {
		sendMsg = "i;" + uge;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendTidsbrug(String projekt, String aktivitet) {
		sendMsg = "j;" + projekt + ";" + aktivitet;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public static void sendSeArbejde(String startDato, String slutDato) {
		sendMsg = "k;" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}


}
