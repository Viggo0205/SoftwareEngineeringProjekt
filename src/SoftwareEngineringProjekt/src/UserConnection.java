// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class UserConnection extends Thread {

	private Socket socket;
	private static DataOutputStream doutp;
	private static Boolean running;
	private static String[] request;
	private static String[] pend;
	private static String initials;

	public UserConnection ( Socket clientSocket )
	{
		this.socket = clientSocket;
	}

	public void run() {
		System.out.println("Starting UserConnection thread " + Thread.currentThread().getId());
		InputStream inps = null;
		DataInputStream dinp = null;
		doutp = null;



		try {
			inps = socket.getInputStream();
			dinp = new DataInputStream(inps);
			//new BufferedReader( new InputStreamReader( inps ) );
			doutp = new DataOutputStream ( socket.getOutputStream() );
		}
		catch (IOException e) {
			System.out.println("I/O error " + e);
			return;
		}

		String inputData;
		Boolean moreData = false;
		while (true)
		{
			try {
				if (dinp.available() > 0)
					moreData = true;
				else
					moreData = false;
			} catch (IOException e) { e.printStackTrace(); }

			if ( moreData )
			{
				try {
					inputData = dinp.readUTF();
					System.out.print("From thread " + Thread.currentThread().getId() + ": " + inputData);
					System.out.println("" + ServControll.getDato().getFormatedDate());
					ServControll.queueMsg(inputData.split(";", 2));
					ServControll.queue(Thread.currentThread().getId());
				} catch (IOException e) { e.printStackTrace(); }
			}

			//Ny
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			msgHandling();

		}
	}

	public static void sendBesked(String sendMessage) {
		try {
			doutp.writeUTF(sendMessage);
			doutp.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void msgHandling() {
		running = true;
		if (ServControll.msgQueue.size() > 0)
		{
			if ( ServControll.queue.get(0) == Thread.currentThread().getId() )
			{
				request = ServControll.msgQueue.get(0);

				if (request[0].equals("0"))
				{
					if (ServControll.findMedarbVedInit(request[1]) > -1)
					{
						initials = request[1];
						sendBesked("0;ok," + ServControll.getDato().getFormatedDate());
					}
					else
						sendBesked("0;no");
				}
				else if (request[0].equals("1"))
				{
					sendBesked("1" + ServControll.packagedProjTake3(initials));
				}
				else if (request[0].equals("2"))
				{
					sendBesked("2" + ServControll.packagedProjMedAktTake2(initials));
				}
				else if (request[0].equals("3"))
				{
					sendBesked("3" + ServControll.packagedMedarb());
				}
				else if (request[0].equals("4"))
				{
					sendBesked("4" + ServControll.packagedProjMedAktTake2(initials) + "|" + ServControll.packagedMedarb());
				}
				else if (request[0].equals("5"))
				{
					sendBesked("5" + ServControll.packagedProjMedAktTake3(initials));
				}
				else if (request[0].equals("6"))
				{
					sendBesked("6" + ServControll.packagedProjMedAktTake3(initials) + "|" + ServControll.packagedMedarb());
				}
				else if (request[0].equals("a"))
				{
					pend = request[1].split(";");
					sendBesked("5;" + ServControll.newAktivitet(pend[0], pend[4], stringTilDato(pend[1]), stringTilDato(pend[2]), Integer.parseInt(pend[3])));
				}
				else if (request[0].equals("b"))
				{
					pend = request[1].split(";");
					sendBesked("6;" + ServControll.addMedarbToAkt(pend[2], pend[0], pend[1]));
				}
				else if (request[0].equals("c"))
				{
					sendBesked("7;" + ServControll.packagedRap(request[1]));
				}
				else if (request[0].equals("d"))
				{
					pend = request[1].split(";");
					sendBesked("8;" + ServControll.registrerFerie(initials, pend[0], pend[1]));
				}
				else if (request[0].equals("e"))
				{
					pend = request[1].split(";");
					sendBesked("9;" + ServControll.addMedarbToAkt(pend[2], pend[0], pend[1]));
				}
				else if (request[0].equals("f"))
				{
					pend = request[1].split(";");
					sendBesked("10;" + ServControll.registrerTimer(pend[2], pend[3], Integer.parseInt(pend[1]), initials, stringTilDato(pend[0])));
				}
				else if (request[0].equals("g"))
				{
					pend = request[1].split(";");
					sendBesked("11;" + ServControll.newProjekt(pend[4], pend[0], stringTilDato(pend[2]), stringTilDato(pend[3])));
				}
				else if (request[0].equals("h"))
				{
					sendBesked("12;" + ServControll.registrerTimer(pend[2], pend[3], Integer.parseInt(pend[1]), initials, stringTilDato(pend[0])));
				}
				else if (request[0].equals("i"))
				{
					
				}
				else if (request[0].equals("j"))
				{
					pend = request[1].split(";");
					sendBesked("14;" + ServControll.packagedAktivitetTid(pend[0], pend[1]));
				}
				else if (request[0].equals("k"))
				{
					sendBesked("15;" + ServControll.packagedArbejdsDag(initials));
				}
				else
				{
					
				}
				ServControll.msgQueue.remove(0);
				ServControll.queue.remove(0);
			}
		}
	}

	private static Dato stringTilDato(String s)
	{
		return new Dato
				(Integer.parseInt(s.split("-")[0]),
						Integer.parseInt(s.split("-")[1]),
						Integer.parseInt(s.split("-")[2]));
	}
}
