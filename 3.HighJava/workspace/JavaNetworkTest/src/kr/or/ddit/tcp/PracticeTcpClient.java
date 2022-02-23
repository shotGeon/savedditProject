package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class PracticeTcpClient {
	
	public static void main(String[] args) throws IOException {
		String serverIp = "127.0.0.1";
		
		System.out.println(serverIp+"서버에 접속 중 입니다...");
		
		Socket socket = new Socket(serverIp, 7777);
		
		System.out.println("연결되었습니다.");
		
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		System.out.println("받은 메시지:"+dis.readUTF());
		System.out.println("연결종료...");
		
		dis.close();
		socket.close();
	}
}
