package com.gmail.alexander.vladimirov1902.timeouttable;

import java.util.LinkedHashMap;

/**
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 *         This class is container for object that are goint to be kept alive for a period of life.
 */

class CacheTable<K, V> {
    private final LinkedHashMap container;

    CacheTable(LinkedHashMap container) {
        this.container = container;
    }

    LinkedHashMap getContainer() {
        return container;
    }

    /**
     * Puts element in to the Cache Table.
     *
     * @param element  that is going to be put.
     * @param lifeSpan period of time that will kept in the cache table.
     */
    void put(K element, long lifeSpan) {
        LifeSpan lifeSpan1 = new LifeSpan(System.currentTimeMillis(), lifeSpan);
        container.put(element, lifeSpan1);
    }

    /**
     * Gets the element and renews lifespan.
     *
     * @param element that is needed.
     * @return the element.
     */
    V get(K element) {

        LifeSpan content = (LifeSpan) container.get(element);

        container.put(element, new LifeSpan(System.currentTimeMillis(), content.lifeSpan));

        return (V) container.get(element);
    }

    /**
     * Removes element from the cache table.
     *
     * @param element that is going to removed.
     * @return removed element.
     */
    public K remove(K element) {
        return (K) container.remove(element);
    }

}
