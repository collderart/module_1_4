package edu.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Foo {
    static Semaphore semCon1 = new Semaphore(1);
    private final CountDownLatch latch;

    public Foo(CountDownLatch countDownLatch) {
        System.out.println("ctor");
        latch = countDownLatch;
    }

    public void first() {
//        System.out.println("\nentered first");

        try {
            semCon1.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("first");
        semCon1.release(2);
    }

    public void second() {
//        System.out.println("\nentered second");
        try {
            semCon1.acquire(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.print("second");
        semCon1.release(3);
    }

    public void third() {
//        System.out.println("\nentered third");
        try {
            semCon1.acquire(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.print("third");
        semCon1.release();
        latch.countDown();
    }
}
