package exercise.t5;

import java.io.*;

public class UserSerialization {
    public static void main(String[] args) {
        String filePath = "user.bat";
        User user = new User("张三");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(user);
        } catch (IOException e) {
            System.err.println(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            User restoredUser = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
