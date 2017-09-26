package com.gmail.alexander.vladimirov1902.timeouttable;

import java.util.ConcurrentModificationException;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This class runs on separate thread to monitor the lifespan of the elements in the cache table.
 *         When life span end then the element is removed from the table.
 */

class Cleaner extends Thread {
    private CacheTable cache;
    private long sleepTime;

    Cleaner(long sleepTime, CacheTable cache) {
        this.sleepTime = sleepTime;
        this.cache = cache;

    }

    public void run() {

        while (cache.getContainer().size() > 0) {

            System.out.println("This is before clean" + cache.getContainer());

            clean();

            System.out.println("This is when cleaned" + cache.getContainer());

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException ignore) {

            }
        }
    }

    /**
     * Iterates through cache table and check if the object exceeds its life span.
     */
    private void clean() {

        try {
            for (Object each : cache.getContainer().keySet()) {
                LifeSpan lifeSpan = (LifeSpan) cache.getContainer().get(each);
                if ((System.currentTimeMillis() - lifeSpan.startTime) >= lifeSpan.lifeSpan) {

                    cache.getContainer().remove(each);

                }
            }
        } catch (ConcurrentModificationException ignore) {

        }
    }
}