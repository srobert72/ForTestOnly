package com.triton;

public abstract class AbstractNumberToWords {
    protected static final long MAX_ALLOWED = 999999999999L;

    protected static final String SPACE = " ";
    protected static final String PLURAL = ""; // replace with "s" if needed
    protected static final String SEPARATOR = ",";

    protected static final int TEN = 10;
    protected static final int TWENTY = 20;
    protected static final int HUNDRED = 100;

    protected static final int BLOCK_SIZE = 3;

    protected static final int BILLION_START = 0;
    protected static final int MILLION_START = BILLION_START + BLOCK_SIZE;
    protected static final int HUNDRER_THOUSAND_START = MILLION_START + BLOCK_SIZE;
    protected static final int THOUSAND_START = HUNDRER_THOUSAND_START + BLOCK_SIZE;

    public abstract String convert(long number);
}
