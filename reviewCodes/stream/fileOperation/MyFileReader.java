package com.yday72__7.reviewCodes.stream.fileOperation;

import java.io.*;

public class MyFileReader {
    public static void readFile(String fileName) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))    // 使用缓冲流减少磁盘读取次数
                ){
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {
        String fileName = "src/resources/input.txt";

        try {
            readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
