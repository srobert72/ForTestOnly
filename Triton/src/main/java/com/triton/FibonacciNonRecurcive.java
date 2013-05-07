package com.triton;

/**
 * The Class FibonacciRecurcive.
 * 
 * Class to computes the Fibonacci value with non recursive algorithm.
 * 
 * @author Stephane
 * @since 2013
 */
public class FibonacciNonRecurcive extends AbstractFibonacci {

    /*
     * (non-Javadoc)
     * 
     * @see com.triton.AbstractFibonacci#getFibonacci(int)
     */
    @Override
    public long getFibonacci(final int number) {
        int prev = -1;
        int result = 1;
        int sum;
        int i;

        for (i = 0; i <= number; ++i) {
            sum = result + prev;
            prev = result;
            result = sum;
        }

        return result;
    }

}
