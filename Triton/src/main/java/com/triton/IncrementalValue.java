package com.triton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Class IncrementalValue.
 * 
 * 3 integer values incremented by 3 thread safe ways
 * 
 * @author Stephane
 * @since 2013
 */
public class IncrementalValue {

    /**
     * The basic value.
     * it will be incremented by synchronized function
     * */
    private int value = 0;

    /** The public volatile integer. */
    public static volatile int publicInt = 0;

    /** The public AtomicInteger. */
    public AtomicInteger publicAmoticInt = new AtomicInteger(0);

    /**
     * Instantiates a new incremental value.
     * 
     * @param initialValue
     *            the initial value set to 3 internal interger values
     */
    public IncrementalValue(int initialValue) {
        super();

        this.value = initialValue;
        IncrementalValue.publicInt = initialValue;
        this.publicAmoticInt = new AtomicInteger(initialValue);
    }

    /**
     * Increment basic integer.
     * 
     * @return the int
     */
    public synchronized int increment() {
        return value++;
    }

    /**
     * Gets the basic integer value.
     * 
     * @return the value
     */
    public int getValue() {
        return value;
    }
}
