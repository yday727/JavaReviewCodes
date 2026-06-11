package com.yday72__7.reviewCodes.stream.serialization;

import java.io.*;

public class UserSerialization {
    public static void serialize(User user, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(user);
        }
    }

    public static User deserialize(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (User) ois.readObject();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/resources/user.dat";
        User user = new User("张三", "123456");

        try {
            serialize(user, filePath);
            System.out.println("User serialized successfully");

            User restoredUser = deserialize(filePath);
            System.out.println("User restored successfully");
            System.out.println(restoredUser);
        }  catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
