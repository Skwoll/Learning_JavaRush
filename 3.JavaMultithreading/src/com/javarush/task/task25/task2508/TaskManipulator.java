package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread innerThread;

    @Override
    public void start(String threadName) {
        innerThread = new Thread(this,threadName);
        innerThread.start();

    }

    @Override
    public void stop() {
        innerThread.interrupt();
    }

    @Override
    public void run() {
        try {
            while (!innerThread.isInterrupted()) {
                System.out.println(innerThread.getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {

        }
    }
}
