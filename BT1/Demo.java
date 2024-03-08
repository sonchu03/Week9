package school;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo {
	public static void main(String[] args) {
		// tao doi tuong student
		Student student = new Student("chu hoang N", 20);
		//tuan tu hoa doi tuong va ghi vao file
		try {
			FileOutputStream fileOut = new FileOutputStream("student.txt");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
			outputStream.writeObject(student);
			outputStream.close();
			fileOut.close();
			System.out.println("da tuan tu hoa va ghi doi tuong vao file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doc doi tuong tu file tuan tu hoa
		try {
			FileInputStream fileInputStream = new FileInputStream("student.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Student student2 = (Student)inputStream.readObject();
			inputStream.close();
			fileInputStream.close();
			System.out.println("da doc doi tuogn tuan tu");
			System.out.println("ten: "+student2.getName());
			System.out.println("tuoi: "+student2.getAge());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
