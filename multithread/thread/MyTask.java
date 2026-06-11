package com.yday72__7.reviewCodes.multithread.thread;

// 实现Runnable接口
class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("任务执行：" + Thread.currentThread().getName());
    }
}
