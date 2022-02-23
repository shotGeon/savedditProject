package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PracticeUdpServer {
	private DatagramSocket socket;
	
	public void start() throws IOException {
		
		socket = new DatagramSocket(7777);
		
		DatagramPacket inPacket, outPacket;
		
		byte[] inMsg = new byte[1];
		byte[] outMsg;
		
		while(true) {
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			socket.receive(inPacket);
			
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			String msg = "안녕하세요";
			
			outMsg =msg.getBytes();
			
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			
			socket.send(outPacket);
		}
	}
	public static void main(String[] args) throws IOException {
		new PracticeUdpServer().start();
	}
}
