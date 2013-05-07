package com.triton;

/**
 * The Class FibonacciRecurcive.
 * 
 * Class to computes the Fibonacci value with recursive algorithm.
 * 
 * @author Stephane
 * @since 2013
 */
public class FibonacciRecurcive extends AbstractFibonacci {

    /*
     * (non-Javadoc)
     * 
     * @see com.triton.AbstractFibonacci#getFibonacci(int)
     */
    @Override
    public long getFibonacci(final int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return getFibonacci(number - 1) + getFibonacci(number - 2);
        }
    }

}
