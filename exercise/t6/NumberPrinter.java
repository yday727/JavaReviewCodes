package exercise.t6;

public class NumberPrinter {
    private static int num = 0;
    private static final int max = 10;
    static final Object lock = new Object();

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (num < max) {
                synchronized (lock) {
                    while (num % 2 == 0) {    // 这里必须使用while重新判断，不能直接用if
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }

                    System.out.println(num);
                    num += 1;
                    lock.notify();
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (num < max) {
                synchronized (lock) {
                    while (num % 2 != 0) {    // 这里必须使用while重新判断，不能直接用if
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }

                    System.out.println(num);
                    num += 1;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new OddPrinter());
        Thread t2 = new Thread(new EvenPrinter());

        t1.start();
        t2.start();
    }
}
