// Skrevet af Eigil Sejer Larsen - s194282

import java.io.IOException;
import java.net.*;

public class ConnectionManager {
	
	static int port = 8084;
	
	public static void openCon()
	{
		ServerSocket serverSocket  = null;
		Socket socket = null;
		
		try { serverSocket = new ServerSocket(port); }
		catch (IOException e) { e.printStackTrace(); }
		
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
