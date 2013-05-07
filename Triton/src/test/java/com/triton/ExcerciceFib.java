package com.triton;

import org.junit.Test;

public class ExcerciceFib extends AbstractExcercice {
    private static final int ITERATION = 10;

    @Test
    public final void testIterator() {
        for (int n = 0; n <= ITERATION; n++) {
            test(n, true);
        }
    }

    private void test(final int n, final boolean verbose) {
        StringBuilder sb = new StringBuilder();
        double debut, fin;
        double dureeFibonacciRecursive, dureeFibonacciNonRecursive;

        sb.append("Test for n = " + n).append(CommonConstants.NEW_LINE);

        debut = System.nanoTime();
        int fibonacciRecursive = getFibonacciRecursive(n);
        fin = System.nanoTime();
        dureeFibonacciRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciRecursive = ").append(fibonacciRecursive).append(NEW_LINE);
            sb.append("duree(ms) = ").append(dureeFibonacciRecursive).append(NEW_LINE);
        }

        debut = System.nanoTime();
        int fibonacciNonRecursive = getFibonacciNonRecursive(n);
        fin = System.nanoTime();
        dureeFibonacciNonRecursive = fin - debut;
        if (verbose) {
            sb.append("fibonacciNonRecursive = ").append(fibonacciNonRecursive).append(NEW_LINE);
            sb.append("duree(ms) = ").append(dureeFibonacciNonRecursive).append(NEW_LINE);
        }

        double delta = dureeFibonacciRecursive - dureeFibonacciNonRecursive;
        sb.append("delta(ms) [fibonacciRecursive - fibonacciNonRecursive] = ").append(delta).append(NEW_LINE);
        double percent = dureeFibonacciRecursive / dureeFibonacciNonRecursive * CommonConstants.PERCENT;
        sb.append("delta(%) [fibonacciNonRecursive] = ").append(percent).append(NEW_LINE);

        LOG.info(sb.toString());
    }

    private int getFibonacciRecursive(final int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
        }
    }

    private int getFibonacciNonRecursive(final int n) {
        int prev = -1;
        int result = 1;
        int sum;
        int i;

        for (i = 0; i <= n; ++i) {
            sum = result + prev;
            prev = result;
            result = sum;
        }

        return result;
    }
}
