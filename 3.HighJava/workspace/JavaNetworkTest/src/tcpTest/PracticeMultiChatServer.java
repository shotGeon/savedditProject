package tcpTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PracticeMultiChatServer {
	Map<String, Socket> clients =  
			        Collections.synchronizedMap(new HashMap<String, Socket>());
	
	
	private void start() {
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버 대기중...");
			while(true) {
				Socket socket=server.accept();
				System.out.println(socket.getInetAddress()+"에서 접속!");
				
				ServerReceiver receiver = new ServerReceiver(socket);
				
				receiver.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
class ServerReceiver extends Thread{
	private Socket socket;
	private DataInputStream dis;
	private String name;
	private Scanner s;
	
	public ServerReceiver(Socket socket) {
		this.socket = socket;
		
		try {
			dis= new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			name=dis.readUTF();
			
			clients.put(name, socket);
			
			sendMessage(name+"님이 입장하셨습니다.");
			
			System.out.println("현재 서버 접속자 수는"+clients.size()+"명입니다.");
			
			while(dis !=null) {
				sendMessage(dis.readUTF(), name);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 것을 의미
			
			sendMessage(name+"님이 나가셨습니다.");
			
			System.out.println(socket.getInetAddress()+"에서 접속종료");
			System.out.println("현재 접속자 수는"+clients.size()+"명 입니다.");
		}
	}
	

	private void sendMessage(String message) {
		Set<String> keySet=clients.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream dos = new DataOutputStream
						(clients.get(it.next()).getOutputStream());
				dos.writeUTF(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//오버로딩
	private void sendMessage(String msg, String from) {
		sendMessage("["+from+"]"+msg);
		
	}


}
	
	public static void main(String[] args) {
		new PracticeMultiChatServer().start();
	}
	
}
