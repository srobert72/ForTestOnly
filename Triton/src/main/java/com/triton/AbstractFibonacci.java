package com.triton;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class AbstractFibonacci.
 * 
 * Abstract super class to computes the Fibonacci value
 * 
 * @author Stephane
 * @since 2013
 */
public abstract class AbstractFibonacci {

    /**
     * Computes the fibonacci value.
     * 
     * @param number
     *            the argument to calculate Fibonacci with
     * @return the fibonacci result
     */
    public abstract long getFibonacci(final int number);

    /**
     * Gets the Fibonacci suite.
     * 
     * @param number
     *            the number to get suite up to
     * @return the fibonacci suite for this number
     */
    public final List<Long> getFibonacciSuite(final int number) {
        ArrayList<Long> result = new ArrayList<Long>();

        for (int i = 0; i < number; i++) {
            result.add(getFibonacci(i));
        }

        return result;
    }
}
