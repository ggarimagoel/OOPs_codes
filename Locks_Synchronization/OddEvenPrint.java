package Locks_Synchronization;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Question:
print sequence from 1 to 100 on two threads,
such that all even numbers on th1, all odd numbers on th2,
output should be in sequence i.e
1(th2)   2(th1)   3(th2)  4(th1)  5(th2)  6(th1)  7(th2) ..........100(th1)
 */
public class OddEvenPrint {
    private static final int max = 100;
    private static Object obj= new Object();
    private static int counter = 1;

    public static void main(String[] args) {



//       ****** if we make both printEven and printOdd classes static , we can directly create obj like this*******

        printEven even = new printEven();
        printOdd odd = new printOdd();
//        printE e = new printE();
//        printO o = new printO();

//        ******preferred way*****



        /* but if we dont make these classes static we need to create obj using parent class i.e. OddEvenPrint


        OddEvenPrint oddEvenPrint = new OddEvenPrint();
        OddEvenPrint.printOdd odd = oddEvenPrint.new printOdd();
        OddEvenPrint.printEven even = oddEvenPrint.new printEven();

         */


        Thread t1 = new Thread(even);
        Thread t2 = new Thread(odd);
//        Thread t3 = new Thread(e);
//        Thread t4 = new Thread(o);

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }

    public static  class printEven implements Runnable {
        public void run() {
            while (counter < max) {
                synchronized (obj) {
                    if (counter % 2 == 0) {
                        System.out.println(counter);
                        counter++;
                        obj.notify(); // Notify the other thread to continue
                    }
                }
            }
        }
    }

    public static  class printOdd implements Runnable {
        public void run() {
            while (counter < max) {
                synchronized(obj) {
                    if (counter % 2 != 0) {
                        System.out.println(counter);
                        counter++;
                        obj.notify();// Notify the other thread to continue
                    }
                }
            }
        }
    }

    /*
    adding these two blocks output will be
    1 2 odd even 5 even odd 8 odd even 11 even odd 14..............


    public static  class printE implements Runnable {
        public void run() {
            while (counter < max) {
                synchronized(obj) {
                    if (counter % 2 == 0) {
                        System.out.println("even");
                        counter++;
                        obj.notify();// Notify the other thread to continue
                    }
                }
            }
        }
    }
    public static  class printO implements Runnable {
        public void run() {
            while (counter < max) {
                synchronized(obj) {
                    if (counter % 2 == 1) {
                        System.out.println("odd");
                        counter++;
                        obj.notify();// Notify the other thread to continue
                    }
                }
            }
        }
    }

     */
}



