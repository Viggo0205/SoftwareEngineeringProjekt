// Skrevet af Eigil Sejer Larsen - s194282

import java.io.*;
import java.net.*;

public class UserConnection extends Thread {

	private Socket socket;

	public UserConnection ( Socket clientSocket )
	{
		this.socket = clientSocket;
	}

	public void run() {
		System.out.println("Starting UserConnection thread " + Thread.currentThread().getId());
		InputStream inps = null;
		DataInputStream dinp = null;
		DataOutputStream doutp = null;

		
		
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
				} catch (IOException e) { e.printStackTrace(); }
			}
		}
	}
}
