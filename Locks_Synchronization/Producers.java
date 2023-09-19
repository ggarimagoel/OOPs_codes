package Locks_Synchronization;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producers implements Runnable{
    private Queue<Object> shop;
    private int maxSize;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producers(Queue<Object> shop, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.shop = shop;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void run(){

        while(true){
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.add(new Object());
            consumerSemaphore.release();
        }
    }
}
