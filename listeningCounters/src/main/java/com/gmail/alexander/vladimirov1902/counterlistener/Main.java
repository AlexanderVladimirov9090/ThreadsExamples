package com.gmail.alexander.vladimirov1902.counterlistener;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class Main {
    public static void main(String[] args) {
        Thread listener = new Thread();
        Counter counter = new Counter(5, listener);
        Counter counter2 = new Counter(5, listener);

        synchronized (Thread.class) {
            counter.start();
            counter2.start();
        }
    }
}