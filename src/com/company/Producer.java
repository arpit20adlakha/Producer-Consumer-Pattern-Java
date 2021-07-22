package com.company;

import java.util.concurrent.BlockingQueue;


public class Producer implements Runnable {
    BlockingQueue<String> blockingQueue = null;

    public Producer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while(true) {
            long timeMilis = System.currentTimeMillis();
            try {
                this.blockingQueue.put("" + timeMilis);
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
            sleep(1000);
        }
    }

    private void sleep(long timeMilis) {
        try {
            Thread.sleep(timeMilis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
