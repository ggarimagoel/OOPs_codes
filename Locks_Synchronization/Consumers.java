package Locks_Synchronization;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumers implements Runnable{
    private Queue<Object> shop;
    private int maxSize;
    private Semaphore producerSemaphore;
    private  Semaphore consumerSemaphore;

    public Consumers(Queue<Object> shop, int maxSize, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.shop = shop;
        this.maxSize = maxSize;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public  void run(){
        while(true){
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            shop.remove();
            producerSemaphore.release();
        }
    }
}
