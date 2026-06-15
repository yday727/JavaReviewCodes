package multithreads.synchronizedAndLock;

public class App {
    public static void main(String[] args) {
        Counter counter = new  Counter();
        Thread thread1 = new Thread(new SomeThread.Thread1(counter));
        Thread thread2 = new Thread(new SomeThread.Thread2(counter));
        Thread thread3 = new Thread(new SomeThread.Thread3(counter));

        // 不一定按1、2、3来，没设置顺序
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
