// Skrevet af Eigil Sejer Larsen - s194282

import java.io.*;
import java.net.*;

public class SimulatedUser {
	static Socket socket = null;
	static DataOutputStream dout = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			socket = new Socket("localhost", 8084);
			dout = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte b[] = {(byte) 'a', (byte) 's', (byte) 'd', (byte) 'f'};
		try {
			dout.writeUTF("tete\n");
			dout.writeUTF("toto\n");
			dout.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
