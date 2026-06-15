package multithread.threadCommunication;

public class NumPrinter {
    /**
     * 实现交替输出奇偶数功能
     */

    private static int number = 1;
    private static final int maxNum = 10;
    // 创建Object实例锁
    private static final Object lock = new Object();

    static class OddPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= maxNum) {
                synchronized (lock) {    // 确保同一时间只有一个线程调用lock
                    while (number % 2 == 0) {
                        try {
                            lock.wait();    // 如果不是奇数，当前线程等待并释放锁
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (number <= maxNum) {
                        System.out.println("Odd: " + number);
                        number++;
                        lock.notify();    // 唤醒一个正在等待该对象锁的线程
                    }
                }
            }
        }
    }

    static class EvenPrinter implements Runnable {
        @Override
        public void run() {
            while (number <= maxNum) {
                synchronized (lock) {    // 确保同一时间只有一个线程调用lock
                    while (number % 2 != 0) {
                        try {
                            lock.wait();    // 如果不是偶数，当前线程等待并释放锁
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (number <= maxNum) {
                        System.out.println("Even: " + number);
                        number++;
                        lock.notify();    // 唤醒一个正在等待该对象锁的线程
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new NumPrinter.OddPrinter()).start();
        new Thread(new NumPrinter.EvenPrinter()).start();
    }
}

