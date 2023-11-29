package edu.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    int threadNumber;
Lock lock = new ReentrantLock();
    public Foo() {
        System.out.println("ctor");
        threadNumber = 1;
    }

    synchronized public void first() {
//        System.out.println("\nentered first");
        while (threadNumber != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("first");
        threadNumber++;
        notifyAll();
    }

    synchronized public void second() {
//        System.out.println("\nentered second");
        while (threadNumber != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("second");
        threadNumber++;
        notifyAll();
    }

    synchronized public void third() {
//        System.out.println("\nentered third");
        while (threadNumber != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.print("third");
        threadNumber++;
        notifyAll();
    }
}
