package com.gmail.alexander.vladimirov1902.fixedsizelist.fixedsizelist;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         Custom exception when the list is full.
 */

public class ListFullException extends RuntimeException {

    public ListFullException(String message) {
        super(message);
    }
}