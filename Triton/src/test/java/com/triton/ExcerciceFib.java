/*
 * 
 */
package com.triton;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * The Class ExcerciceFib.
 * 
 * @author Stephane
 * @since 2013
 */
public class ExcerciceFib extends AbstractExcercice {

    /**
     * The Constant ITERATION.
     * Number of iterations the test will perform
     * */
    private static final int ITERATION = 10;

    /**
     * The Constant LOG_VERBOSE.
     * Displays verbose logs or not
     * */
    private static final boolean LOG_VERBOSE = true;

    /** The Fibonacci recurcive implementation. */
    private FibonacciRecurcive fibonacciRecurcive = new FibonacciRecurcive();

    /** The fibonacci non recurcive implementation. */
    private FibonacciNonRecurcive fibonacciNonRecurcive = new FibonacciNonRecurcive();

    /**
     * Test iterator.
     * 
     * Iterates number between 1 to N and compares 2 Fibonacci implementations
     */
    @Test
    public final void testIterator() {
        for (int n = 0; n <= ITERATION; n++) {
            compareFibonacci(n, LOG_VERBOSE);
        }
    }

    /**
     * Test iterator.
     * 
     * Compares 2 Fibonacci Suite implementations
     */
    @Test
    public final void testSuite() {
        compareFibonacciSuite(ITERATION, LOG_VERBOSE);
    }

    /**
     * CompareFibonacci.
     * 
     * Compares 2 Fibonacci implementations : Recursive & NonRecursive
     * For each display result and duration(ns)
     * Computes delta(ns) and percentage(%) Recursive method takes more compare to NonRecursive
     * 
     * @param n
     *            the argument to calculate Fibonacci with
     * @param verbose
     *            the verbose logs ON/OFF
     */
    private void compareFibonacci(final int n, final boolean verbose) {
        StringBuilder sb = new StringBuilder();
        double debut, fin;
        double dureeFibonacciRecursive, dureeFibonacciNonRecursive;

        sb.append("Test for n = " + n).append(CommonConstants.NEW_LINE);

        debut = System.nanoTime();
        long fibonacciRecursive = fibonacciRecurcive.getFibonacci(n);
        fin = System.nanoTime();
        dureeFibonacciRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciRecursive = ").append(fibonacciRecursive).append(NEW_LINE);
            sb.append("duration(ns) = ").append(dureeFibonacciRecursive).append(NEW_LINE);
        }

        debut = System.nanoTime();
        long fibonacciNonRecursive = fibonacciNonRecurcive.getFibonacci(n);
        fin = System.nanoTime();
        dureeFibonacciNonRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciNonRecursive = ").append(fibonacciNonRecursive).append(NEW_LINE);
            sb.append("duration(ns) = ").append(dureeFibonacciNonRecursive).append(NEW_LINE);
        }

        double delta = dureeFibonacciRecursive - dureeFibonacciNonRecursive;
        sb.append("delta(ns) [fibonacciRecursive - fibonacciNonRecursive] = ").append(delta).append(NEW_LINE);
        double percent = delta / dureeFibonacciNonRecursive * CommonConstants.PERCENT;
        sb.append("delta(%) [fibonacciNonRecursive] = ").append(percent).append(NEW_LINE);

        LOG.info(sb.toString());
    }

    /**
     * compareFibonacciSuite.
     * 
     * Compares 2 Fibonacci Suite implementations : Recursive & NonRecursive
     * For each display result and duration(ns)
     * Computes delta(ns) and percentage(%) Recursive method takes more compare to NonRecursive
     * 
     * @param n
     *            the argument to calculate Fibonacci Suite with
     * @param verbose
     *            the verbose logs ON/OFF
     */
    private void compareFibonacciSuite(final int n, final boolean verbose) {
        StringBuilder sb = new StringBuilder();
        double debut, fin;
        double dureeFibonacciRecursive, dureeFibonacciNonRecursive;

        sb.append("Test for n = " + n).append(CommonConstants.NEW_LINE);

        debut = System.nanoTime();
        List<Long> fibonacciRecursiveSuite = fibonacciRecurcive.getFibonacciSuite(n);
        fin = System.nanoTime();
        dureeFibonacciRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciRecursive = ").append(logList(fibonacciRecursiveSuite)).append(NEW_LINE);
            sb.append("duration(ns) = ").append(dureeFibonacciRecursive).append(NEW_LINE);
        }

        debut = System.nanoTime();
        List<Long> fibonacciNonRecursiveSuite = fibonacciNonRecurcive.getFibonacciSuite(n);
        fin = System.nanoTime();
        dureeFibonacciNonRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciNonRecursive = ").append(logList(fibonacciNonRecursiveSuite)).append(NEW_LINE);
            sb.append("duration(ns) = ").append(dureeFibonacciNonRecursive).append(NEW_LINE);
        }

        double delta = dureeFibonacciRecursive - dureeFibonacciNonRecursive;
        sb.append("delta(ns) [fibonacciRecursive - fibonacciNonRecursive] = ").append(delta).append(NEW_LINE);
        double percent = delta / dureeFibonacciNonRecursive * CommonConstants.PERCENT;
        sb.append("delta(%) [fibonacciNonRecursive] = ").append(percent).append(NEW_LINE);

        LOG.info(sb.toString());
    }

    /**
     * Log all list items.
     * 
     * @param list
     *            the list to log
     * @return the log string
     */
    private String logList(final List<Long> list) {
        StringBuilder sb = new StringBuilder();

        for (Iterator<Long> iterator = list.iterator(); iterator.hasNext();) {
            Long number = iterator.next();

            sb.append(number);

            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
