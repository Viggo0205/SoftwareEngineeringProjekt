// Skrevet af Eigil Sejer Larsen - s194282
package SoftwareEngineringProjekt.src;

import java.io.*;
import java.net.*;

public class SimulatedUser {
	static Socket socket = null;
	static DataOutputStream dout = null;
	
	static InputStream inps = null;
	static DataInputStream dinp = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			socket = new Socket("localhost", 8085);
			dout = new DataOutputStream(socket.getOutputStream());
			inps = socket.getInputStream();
			dinp = new DataInputStream(inps);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte b[] = {(byte) 'a', (byte) 's', (byte) 'd', (byte) 'f'};
		try {
			dout.writeUTF("2;ADMN");
			dout.writeUTF("2;test2");
			dout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (true)
		{
			boolean moreData = false;
			try {
				if (dinp.available() > 0)
					moreData = true;
				else
					moreData = false;
			} catch (IOException e) { e.printStackTrace(); }
			
			if ( moreData )
			{
				try {
					String inputData = dinp.readUTF();
					System.out.println("From thread " + Thread.currentThread().getId() + ": " + inputData);
				} catch (IOException e) { e.printStackTrace(); }
				
			}
		}
	}

}
