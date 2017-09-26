package com.gmail.alexander.vladimirov1902.timeouttable;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *          This class is life span of the element in the cache table.
 */

class LifeSpan {
    public final long startTime;
    public final long lifeSpan;

    LifeSpan(long startTime, long lifeSpan) {
        this.startTime = startTime;
        this.lifeSpan = lifeSpan;
    }
}