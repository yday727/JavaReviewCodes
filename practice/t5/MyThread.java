package practice.t5;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.println(i);
        }
    }
}
