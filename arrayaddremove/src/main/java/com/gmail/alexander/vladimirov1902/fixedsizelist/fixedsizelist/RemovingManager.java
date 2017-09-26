package com.gmail.alexander.vladimirov1902.fixedsizelist.fixedsizelist;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         Manage the removing process from the fixed list.
 */

public class RemovingManager extends Thread {
    private final FixedList fixedList;
    private final AddingManager addingManager;

    public RemovingManager(FixedList fixedList, AddingManager addingManager) {
        this.fixedList = fixedList;
        this.addingManager = addingManager;
    }

    @Override
    public void run() {
        synchronized (addingManager) {
            remove();
        }
    }

    /**
     * Removes item from array. When empty wait for Other thread.
     */
    private void remove() {
        while (true) {

            try {
                System.out.println("\nRemoving item." + Thread.currentThread().getName());
                fixedList.remove();
                addingManager.notifyAll();
            } catch (ArrayIndexOutOfBoundsException ignored) {

                try {
                    System.out.println("Waiting for other thread because array is empty.");
                    addingManager.notifyAll();
                    addingManager.wait();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            System.out.println("Removed item from Array. " + Thread.currentThread().getName());
            fixedList.printAllElements();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
