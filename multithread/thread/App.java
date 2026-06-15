package multithread.thread;

public class App {
    public static void main(String[] args) {
        // 继承Thread类启动
        MyThread thread1 = new MyThread();
        thread1.start();    // 启动线程（自动调用run()方法）

        // 实现Runnable接口启动，需通过Thread包装
        Thread thread2 = new Thread(new MyTask());
        thread2.start();
    }
}
