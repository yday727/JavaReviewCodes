package multithread.synchronizedAndLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter{
    private int count = 0;

    public Counter() {}

    public int getCount() {
        return count;
    }

    // 创建实例锁
    private final Lock lock = new ReentrantLock();

    public void inc1() {
        synchronized (this) {    // 锁当前对象
            count++;
            System.out.println(Thread.currentThread().getName() + "counter: " + count);
        }
    }

    // 同步方法，与上面等效
    public synchronized void inc2() {
        count++;
        System.out.println(Thread.currentThread().getName() + "counter: " + count);
    }

    // 显示锁，与上面等效
    public void inc3() {
        lock.lock();    // 获取锁
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + "counter: " + count);
        } finally {
            lock.unlock();    // 一定要在finally中手动解锁，避免死锁
        }
    }
}
