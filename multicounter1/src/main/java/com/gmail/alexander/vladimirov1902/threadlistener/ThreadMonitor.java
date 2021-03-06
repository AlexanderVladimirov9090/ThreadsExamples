package com.gmail.alexander.vladimirov1902.threadlistener;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This class monitors and interrupts Thread when delaying more than given time limit set by user.
 */

class ThreadMonitor {

    /**
     * Kills thread.
     *
     * @param thread targeted thread.
     */
    void kill(Thread thread) {
        while (thread.isAlive()) {
            if (thread.isAlive() && Thread.activeCount() < 4) {
                thread.interrupt();

                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}