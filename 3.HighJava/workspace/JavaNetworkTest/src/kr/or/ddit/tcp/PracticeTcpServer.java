package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PracticeTcpServer {
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		
		Socket socket=server.accept();
		
		System.out.println("접속한 클라이언트 주소");
		System.out.println("클라이언트 ip:"+socket.getInetAddress());
		
		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF("어서오세요");
		System.out.println("메시지를 보냈습니다.");
		
		dos.close();
		server.close();
	}
	
}
