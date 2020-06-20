package com.javarush.task.task25.task2506;

import java.util.Currency;

public class LoggingStateThread extends Thread {
    Thread targetThread;
    State lastTargetState;

    public LoggingStateThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        if (targetThread != null) {
            lastTargetState = targetThread.getState();
//            System.out.println(String.format("New state of thread %s: %s", targetThread.getName(), lastTargetState));
            System.out.println(lastTargetState);
        }

        while (true) {
            State currentState = targetThread.getState();
            if (lastTargetState != currentState) {
                lastTargetState = currentState;
//                System.out.println(String.format("New state of thread %s: %s",targetThread.getName(),currentState));
                System.out.println(currentState);
            }

            if (currentState == State.TERMINATED) {
                break;
            }
        }
    }
}
