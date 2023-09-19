package Locks_Synchronization;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Counter c;
    private Lock lock;

    public Adder(Counter c, Lock lock) {
        this.c = c;
        this.lock = lock;
    }

    public void run() {
        for(int i = 0; i < 100000; i++){
            lock.lock();
             c.count++;
            System.out.println(c.count);
            lock.unlock();
        }
    }
}
