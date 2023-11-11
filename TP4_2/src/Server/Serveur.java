package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serveur {

	private static final int port = 1234;
	private static byte[] buffer = new byte[1024];

	private String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date currentTime = new Date();
		return dateFormat.format(currentTime);

	}

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(port);
		System.out.println("Demarrage du serveur");
		while (true) {// pour chaque client
			// n3tyh taille du tableau 1024 ou buffer.length
			// userNamePacket : datagram fer8

			DatagramPacket Packet = new DatagramPacket(buffer, buffer.length);// a partir du usernamepacket je vais
																				// connait l'@ip du client
			socket.receive(Packet);
			String time = new Serveur().getTime();
			DatagramPacket packetTosend = new DatagramPacket(time.getBytes(), time.length(), Packet.getAddress(),
					Packet.getPort());
			socket.receive(packetTosend);
		}
	}

}
