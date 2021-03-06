package com.gmail.alexander.vladimirov1902.threadlistener;

import org.junit.Test;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class CounterTest {

    @Test(timeout = 10000l)
    public void happyPath() throws InterruptedException {
        Counter counter = new Counter(2);
        Counter counter2 = new Counter(3);
        synchronized (Counter.class) {
            ThreadMonitor threadMonitor = new ThreadMonitor();

            counter.start();
            counter2.start();
            threadMonitor.kill(counter);
            threadMonitor.kill(counter2);
        }
    }
}