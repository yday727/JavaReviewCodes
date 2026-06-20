package extraExercise.t6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String fileName = "test.txt";    // 如需实际运行改为根目录路径

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            boolean isNull = true;

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                isNull = false;
            }

            if (isNull) {
                throw new NullDocumentException("文件为空");
            }
        } catch (IOException | NullDocumentException e) {
            System.err.println(e);
        } finally {
            System.out.println("执行完毕");
        }
    }
}
