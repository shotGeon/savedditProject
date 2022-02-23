package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class PracticeUdpClient {

	public void start() throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("192.168.43.56");
		
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = 
				    new DatagramPacket(msg, 1, serverAddress,7777);
		DatagramPacket inPacket =
				    new DatagramPacket(msg, msg.length);
		
		socket.send(outPacket);
		socket.receive(inPacket);
		
		System.out.println("서버에서 받은 메시지=>"+new String(inPacket.getData()));
		
		socket.close();
		
	}
	public static void main(String[] args) throws IOException {
		new PracticeUdpClient().start();
	}
}
