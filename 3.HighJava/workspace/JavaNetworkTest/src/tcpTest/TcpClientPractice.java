package tcpTest;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientPractice {
	
	public static void main(String[] args) throws Exception {
		String serverIp="192.168.43.56";
		
		Socket socket = new Socket(serverIp, 7777); 
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		
		System.out.println("받은메시지: "+ dis.readUTF());
		
		dis.close();
		socket.close();
		
	
	}
}
