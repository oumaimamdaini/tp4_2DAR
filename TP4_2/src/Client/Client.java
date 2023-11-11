package Client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int port = 1234;
	private static byte[] buffer = new byte[1024];
	
	public static void main(String[] args) throws Exception {
		
	DatagramSocket socket = new DatagramSocket();
	System.out.println("Demarrage du client");
	
	DatagramPacket userNamePacket = new DatagramPacket(buffer,buffer.length,InetAddress.getByName("localhost"),port);//aandy twa mon packet fyh userName
	socket.send(userNamePacket);
	
	DatagramPacket packetToreceive =new DatagramPacket(buffer,buffer.length);
	socket.receive(packetToreceive);
	System.out.println("Server : "+new String(packetToreceive.getData(),0,packetToreceive.getLength()));//n7awl les octects en String
				}
			

		

	}


