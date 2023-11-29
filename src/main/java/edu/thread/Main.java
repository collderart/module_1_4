package edu.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Foo foo = new Foo();
        CompletableFuture.runAsync(foo::second);

        CompletableFuture.runAsync(foo::first);

        CompletableFuture.runAsync(foo::third);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nPrint from main");
    }
}
