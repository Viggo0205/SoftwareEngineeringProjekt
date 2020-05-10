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
							sendBesked("0;ok," + ServControll.getDato().getFormatedDate());
						else
							sendBesked("0;ellers tak");
					}
					else if (request[0].equals("1"))
					{
						sendBesked("1" + ServControll.packagedProj());
					}
					else if (request[0].equals("2"))
					{
						sendBesked("2" + ServControll.packagedProjMedAkt());
					}
					else if (request[0].equals("3"))
					{

					}
					else if (request[0].equals("4"))
					{

					}
					else if (request[0].equals("a"))
					{

					}
					else if (request[0].equals("b"))
					{

					}
					else if (request[0].equals("c"))
					{

					}
					else if (request[0].equals("d"))
					{

					}
					else if (request[0].equals("e"))
					{

					}
					else if (request[0].equals("f"))
					{

					}
					else if (request[0].equals("g"))
					{

					}
					else if (request[0].equals("h"))
					{

					}
					else if (request[0].equals("i"))
					{

					}
					else if (request[0].equals("j"))
					{

					}
					else if (request[0].equals("k"))
					{

					}
					else
					{

					}
					ServControll.msgQueue.remove(0);
					ServControll.queue.remove(0);
				}
			}
	}
}
