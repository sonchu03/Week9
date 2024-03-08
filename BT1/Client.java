// Client.java
package school;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Student student = (Student) ois.readObject();
            System.out.println("Đã nhận được đối tượng " + student.getName() + " tuổi " + student.getAge());
            ois.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
