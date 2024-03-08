package school;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPExam {
	public static void main(String[] args) {
		// tao doi tuong student
		Student student = new Student("Chu Hoang A", 20);
		ByteArrayOutputStream BOS = new ByteArrayOutputStream();
		try {
			ObjectOutputStream OOS = new ObjectOutputStream(BOS);
			OOS.writeObject(student);
			byte[] data = BOS.toByteArray();
			InetAddress address = InetAddress.getByName("localhost");
			int port = 12345;
			DatagramSocket datagramSocket = new DatagramSocket();
			DatagramPacket datagramPacket = new DatagramPacket(data,data.length,address, port);
			datagramSocket.send(datagramPacket);
			System.err.println("du lieu da duoc gui");
			////////////////////////////////////////////////////
			/*
			 * byte[] receiveData = new byte[1024]; DatagramPacket receivePacket = new
			 * DatagramPacket(receiveData,receiveData.length, port);
			 * datagramSocket.receive(receivePacket); ByteArrayInputStream bis = new
			 * ByteArrayInputStream(receivePacket.getData()); ObjectInputStream ois = new
			 * ObjectInputStream(bis); try { Student student2 = (Student)ois.readObject();
			 * System.out.println("da nhan duoc doi tuong "+student2.getName()+"tuoi"+
			 * student2.getAge()); } catch (ClassNotFoundException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
