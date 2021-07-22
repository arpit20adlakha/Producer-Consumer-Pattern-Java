package com.company;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> queue) {
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String element = blockingQueue.take();
                String text = Thread.currentThread().getName() + " consumed " + element;
                System.out.println(text);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
