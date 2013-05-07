package com.triton;

import org.junit.Test;

public class ExcerciceStwAndo extends AbstractExcercice {
    private static final int ITERATION = 100;
    private static final int STW_VALUE = 3;
    private static final String STW_STR = "Stw";
    private static final int ANDO_VALUE = 5;
    private static final String ANDO_STR = "Ando";

    @Test
    public final void testIterator() {
        StringBuilder sb = new StringBuilder();

        for (int n = 1; n <= ITERATION; n++) {
            sb.append(test(n));

            sb.append(NEW_LINE);
        }

        LOG.info(sb.toString());
    }

    private StringBuilder test(final int n) {
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
