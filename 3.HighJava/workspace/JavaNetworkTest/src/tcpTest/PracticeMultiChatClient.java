package tcpTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PracticeMultiChatClient {
	private String name;
	Scanner s = new Scanner(System.in);
	
	public void start() {
		
		System.out.println("대화명:");
		name=s.nextLine();
		
		try {
			Socket socket = new Socket("192.168.43.56", 7777);
			
			System.out.println("서버에 연결되었습니다.");
			
			//송신용 스레드 
			ClientSender sender = new ClientSender(socket, name);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
class ClientSender extends Thread{
	private Socket socket;
	private String nickname;
	private DataOutputStream dos;
	
	public ClientSender(Socket socket, String name) {
		this.socket=socket;
		this.nickname=name;
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		
	}
}
	
	
}
