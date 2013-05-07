package com.triton;

import org.junit.Test;

/**
 * The Class ExerciceStwAndo.
 * 
 * TestCase for Str/Ando replacements
 * 
 * @author Stephane
 * @since 2013
 */
public class ExerciceStwAndo extends AbstractExercice {

    /**
     * The Constant ITERATION.
     * Number of iterations the test will perform
     * */
    private static final int ITERATION = 100;

    /**
     * The Constant STW_VALUE.
     * Numeric value for Stw
     * */
    private static final int STW_VALUE = 3;

    /**
     * The Constant STW_STR.
     * String replacement for Stw
     * */
    private static final String STW_STR = "Stw";

    /**
     * The Constant ANDO_VALUE.
     * Numeric value for Ando
     * */
    private static final int ANDO_VALUE = 5;

    /**
     * The Constant ANDO_STR.
     * String replacement for Ando
     * */
    private static final String ANDO_STR = "Ando";

    /**
     * Test iterator.
     * 
     * Iterates number between 1 to N and writes it or replaces it with Stw/Ando
     */
    @Test
    public final void testIterator() {
        StringBuilder sb = new StringBuilder();

        for (int n = 1; n <= ITERATION; n++) {
            sb.append(writeOrReplaceStwAndo(n));

            sb.append(NEW_LINE);
        }

        LOG.info(sb.toString());
    }

    /**
     * Test a number (with modulo) if it is multiple of 3 or 5.
     * multiple of 3 : writes "Stw"
     * multiple of 5 : writes or appends "Ando"
     * else : writes usual figures
     * 
     * @param n
     *            the number to write or replace
     * @return the string builder that contains this number or its replacement
     */
    private StringBuilder writeOrReplaceStwAndo(final int n) {
        StringBuilder sb = new StringBuilder();

        boolean isStwAndo = false;
        if (n % STW_VALUE == 0) {
            sb.append(STW_STR);

            isStwAndo = true;
        }

        if (n % ANDO_VALUE == 0) {
            sb.append(ANDO_STR);

            isStwAndo = true;
        }

        if (!isStwAndo) {
            sb.append(n);
        }

        return sb;
    }
}
