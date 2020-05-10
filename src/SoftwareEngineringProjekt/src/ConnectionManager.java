// Skrevet af Eigil Sejer Larsen - s194282
//
// Åbner for forbindelse til serveren
package SoftwareEngineringProjekt.src;

import java.io.IOException;
import java.net.*;

public class ConnectionManager implements Runnable{

	static int port = 8085;

	@SuppressWarnings("resource")
	public void run()
	{	
		ServerSocket serverSocket  = null;
		Socket socket = null;

		try { 
			serverSocket = new ServerSocket(port); 
		} catch (IOException e) { 
			e.printStackTrace(); 
		}

		while (true) {
			try {
				socket = serverSocket.accept();
			}
			catch (IOException e)
			{
				System.out.println( "I/O error " + e);
			}
			new UserConnection(socket).start();
		}
	}

}
