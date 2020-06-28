package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue queue;
    @Override
    public void run() {
        try {
            while (true){
                System.out.println((String)queue.take());
                if(Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }

    }

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }
}
