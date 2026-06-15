package stream.systemStream;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            System.out.print("输入一个字符：");    // 输出不换行
            int byteValue = System.in.read();    // 读取单个字符（返回ASCLL码）
            char ch =  (char)byteValue;
            System.out.println("输入的字符为：" + ch);    // 输出并换行
        } catch (IOException e) {
            System.err.println(e);    // 从错误流输出异常
        }
    }
}
