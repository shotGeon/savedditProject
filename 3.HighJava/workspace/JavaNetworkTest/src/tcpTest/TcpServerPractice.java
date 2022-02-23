package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerPractice {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("접속 대기중.....");
		
		Socket socket= server.accept();
		
		System.out.println("클라이언트가 접속했습니다.");
		
		System.out.println("접속한 클라이언트 주소:"
		                   +socket.getInetAddress());
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		dos.writeUTF("어서오세요....");
		
		dos.close();
		server.close();
	}
}
