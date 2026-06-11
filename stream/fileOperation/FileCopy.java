package com.yday72__7.reviewCodes.stream.fileOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void copyFile(String src, String dest) throws IOException {
        try (FileInputStream fr = new FileInputStream(src);
             FileOutputStream fw = new FileOutputStream(dest)
             ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, len);
            }
        }
    }

    public static void main(String[] args) {
        String src = "src/resources/input.png";
        String dest = "src/resources/output.png";

        try {
            copyFile(src, dest);
            System.out.println("File copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
