package exercise.t5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String src = "xxx.png";
        String des = "xxx.png";

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(des)
             ) {
            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
