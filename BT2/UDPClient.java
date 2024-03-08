package school;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class UDPClient {
	public static void main(String[] args) {
		try {
			byte[] receiveData = new byte[8192];
			int port = 12345;
			DatagramSocket datagramSocket = new DatagramSocket();
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length, port );
			datagramSocket.receive(receivePacket);
			ByteArrayInputStream bis = new ByteArrayInputStream(receivePacket.getData());
			ObjectInputStream ois = new ObjectInputStream(bis);
			Student student2 = (Student)ois.readObject();
			System.out.println("da nhan duoc doi tuong "+student2.getName()+"tuoi"+student2.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
