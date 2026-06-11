package com.yday72__7.reviewCodes.multithread.synchronizedAndLock;

public class SomeThread{
    static class Thread1 implements Runnable{
        private static Counter counter;
        public Thread1(Counter counter) {
            Thread1.counter = counter;
        }

        @Override
        public void run() {
            while (counter.getCount() < 10) {
                counter.inc1();
                try {
                    Thread.sleep(100);    // 休眠100ms
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Thread2 implements Runnable{
        private static Counter counter;

        public Thread2(Counter counter) {
            Thread2.counter = counter;

        }

        @Override
        public void run() {
            while (counter.getCount() < 10) {
                counter.inc2();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Thread3 implements Runnable{
        private static Counter counter;

        public Thread3(Counter counter) {
            Thread3.counter = counter;
        }

        @Override
        public void run() {
            while (counter.getCount() < 10) {
                counter.inc3();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
