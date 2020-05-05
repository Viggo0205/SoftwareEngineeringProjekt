import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
	private String sendMsg;

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
		while(comModRun) {

			if (Controll.ready) {
				System.out.println("123");
				System.out.println(netin.hasNext());
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
	
	public void sendLogin(String initialer) {
		pw.print("0:" + initialer);
		pw.flush();
	}
	
	
	// metoder for at sende beskeder til serveren afhængig af hvilket event.
	public void sendOpretAktiv(String projekt, String uger, String timer) {
		sendMsg = "a:" + projekt + ";" + uger + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendTildelAkt(String projekt, String aktivitet, String udvikler) {
		sendMsg = "b:" + projekt + ";" + aktivitet + ";" + udvikler;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendSkafRapport(String projekt) {
		sendMsg = "c:" + projekt;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendRegistrerFerie(String startDato, String slutDato) {
		sendMsg = "d:" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendSoegHjaelp(String projekt, String aktivitet, String udvikler) {
		sendMsg = "e:" + projekt + ";" + aktivitet + ";" + udvikler;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendRetterTimer(String dato, String timer) {
		sendMsg = "f:" + dato + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendOpretPro(String leder, String beskrivelse, String startDato, String slutDato) {
		sendMsg = "g:" + leder + ";" + beskrivelse + ";" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendIndmeldTid(String projekt, String aktivitet, String dag, String timer) {
		sendMsg = "h:" + projekt + ";" + aktivitet + ";" + dag + ";" + timer;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendErLedig(String uge) {
		sendMsg = "i:" + uge;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendTidsbrug(String projekt, String aktivitet) {
		sendMsg = "j:" + projekt + ";" + aktivitet;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	public void sendSeArbejde(String startDato, String slutDato) {
		sendMsg = "k:" + startDato + ";" + slutDato;
		pw.print(sendMsg);
		pw.flush();
		sendMsg = null;
	}
	
	
	
}
