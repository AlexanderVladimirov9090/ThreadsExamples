package com.gmail.alexander.vladimirov1902.fixedsizelist.fixedsizelist;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         class that is managing adding method to the fixed list.
 */

public class AddingManager extends Thread {
    private final FixedList fixedList;

    public AddingManager(FixedList fixedList) {
        this.fixedList = fixedList;
    }

    @Override
    public void run() {
        synchronized (this) {
            add();
        }
    }

    /**
     * Adds new Object to array. Waits when full for other thread.
     */
    private void add() {
        int number = 0;
        while (true) {

            try {
                System.out.println("\nAdded Item to Array. " + Thread.currentThread().getName());
                fixedList.add(number++);
            } catch (ListFullException e) {

                try {
                    System.out.println("Wait removing thread because array is full.");
                    this.notifyAll();
                    wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
            fixedList.printAllElements();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}