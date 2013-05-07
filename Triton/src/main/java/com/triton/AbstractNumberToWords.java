package com.triton;

/**
 * The Class AbstractNumberToWords.
 * 
 * Abstract super class used to convert integer numbers into words
 * 
 * @author Stephane
 * @since 2013
 */
public abstract class AbstractNumberToWords {

    /**
     * The Constant MAX_ALLOWED.
     * Number greater than this value are not supported
     * */
    protected static final long MAX_ALLOWED = 999999999999L;

    /**
     * The Constant SPACE.
     * Space character used between words
     * */
    protected static final String SPACE = " ";

    /**
     * The Constant PLURAL.
     * Plural character (s) used if necessary
     * */
    protected static final String PLURAL = ""; // replace with "s" if needed

    /**
     * The Constant SEPARATOR.
     * Comma separator used between blocks
     * */
    protected static final String SEPARATOR = ",";

    /** The Constant TEN. */
    protected static final int TEN = 10;

    /** The Constant TWENTY. */
    protected static final int TWENTY = 20;

    /** The Constant HUNDRED. */
    protected static final int HUNDRED = 100;

    /** The Constant BLOCK_SIZE. */
    protected static final int BLOCK_SIZE = 3;

    /**
     * The Constant BILLION_START.
     * Start digit index from left user by billion figures
     * */
    protected static final int BILLION_START = 0;

    /**
     * The Constant MILLION_START.
     * Start digit index from left user by million figures
     * */
    protected static final int MILLION_START = BILLION_START + BLOCK_SIZE;

    /**
     * The Constant HUNDRER_THOUSAND_START.
     * Start digit index from left user by hundred thousand figures
     * */
    protected static final int HUNDRER_THOUSAND_START = MILLION_START + BLOCK_SIZE;

    /**
     * The Constant THOUSAND_START.
     * Start digit index from left user by thousand figures
     * */
    protected static final int THOUSAND_START = HUNDRER_THOUSAND_START + BLOCK_SIZE;

    /**
     * Converts a number into words.
     * 
     * @param number
     *            the number to convert into words
     * @return the words for this number
     */
    public abstract String convert(long number);
}
