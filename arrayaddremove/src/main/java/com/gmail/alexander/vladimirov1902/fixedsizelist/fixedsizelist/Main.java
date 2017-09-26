package com.gmail.alexander.vladimirov1902.fixedsizelist.fixedsizelist;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class Main {
    public static void main(String[] args) {

        FixedList fixedList = new FixedList(3);

        synchronized (AddingManager.class) {
            AddingManager addingMangerThread = new AddingManager(fixedList);
            RemovingManager removingManagerThread = new RemovingManager(fixedList, addingMangerThread);
            addingMangerThread.start();
            removingManagerThread.start();
        }
    }
}