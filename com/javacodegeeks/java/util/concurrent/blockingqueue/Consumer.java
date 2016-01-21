package com.javacodegeeks.java.util.concurrent.blockingqueue;

import com.javacodegeeks.java.util.concurrent.blockingqueue.*;
import java.util.concurrent.BlockingQueue;
@SuppressWarnings("unused")
public class Consumer implements Runnable {

    protected BlockingQueue<?> queue = null;

    public Consumer(BlockingQueue<?> queue) {

        this.queue = queue;

    }
  public void run() {

        try {

            System.out.println("Consumed: " + queue.take());
        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

}
