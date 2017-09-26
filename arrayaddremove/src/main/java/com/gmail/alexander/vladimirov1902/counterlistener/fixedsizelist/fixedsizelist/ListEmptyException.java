package com.gmail.alexander.vladimirov1902.counterlistener.fixedsizelist.fixedsizelist;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         Custom exception when list is empty.
 */

public class ListEmptyException extends RuntimeException {

    public ListEmptyException(String message) {
        super(message);
    }
}