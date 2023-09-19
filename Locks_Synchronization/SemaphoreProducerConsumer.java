package Locks_Synchronization;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaphoreProducerConsumer {
    public static void main(String[] args) {
    Queue<Object> shop = new LinkedList<>();
        Semaphore producerSemaphore = new Semaphore(6);
        Semaphore consumerSemaphore = new Semaphore(0);

        Producers P1 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);
        Producers P2 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);
        Producers P3 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);
        Producers P4 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);
        Producers P5 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);
        Producers P6 = new Producers(shop, 6,producerSemaphore,consumerSemaphore);

        Consumers C1 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
        Consumers C2 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
        Consumers C3 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
        Consumers C4 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
        Consumers C5 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
        Consumers C6 = new Consumers(shop, 6,producerSemaphore,consumerSemaphore);
    }
}
