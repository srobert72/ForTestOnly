package com.triton;

import java.text.DecimalFormat;

/**
 * The Class EnglishNumberToWords.
 * 
 * Sub class used to convert integer numbers into words in English language
 * 
 * @author Stephane
 * @since 2013
 */
public class EnglishNumberToWords extends AbstractNumberToWords {

    /** The Constant TENS_NAMES. */
    private static final String[] TENS_NAMES = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    /** The Constant NUM_NAMES. */
    private static final String[] NUM_NAMES = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    /** The Constant BLOCK_NAMES. */
    private static final String[] BLOCK_NAMES = { "", "hundred", "thousand", "million", "billion" };

    /**
     * Convert numbers less than one thousand.
     * 
     * @param numberToConvert
     *            the number to convert into words
     * @return the words for this number
     */
    private static String convertLessThanOneThousand(final int numberToConvert) {
        String soFar;

        int number = numberToConvert;

        if (number % HUNDRED < TWENTY) {
            soFar = SPACE + NUM_NAMES[number % HUNDRED];
            number /= HUNDRED;
        } else {
            soFar = SPACE + NUM_NAMES[number % TEN];
            number /= TEN;

            soFar = SPACE + TENS_NAMES[number % TEN] + soFar;
            number /= TEN;
        }

        if (number == 0) {
            return soFar;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(NUM_NAMES[number]).append(SPACE).append(BLOCK_NAMES[1]).append(soFar);

        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.triton.AbstractNumberToWords#convert(long)
     */
    @Override
    public final String convert(final long number) {
        if ((number < 0) || (number > MAX_ALLOWED)) {
            throw new IllegalArgumentException("You must use positive number less than " + MAX_ALLOWED);
        }

        // 0 to 999 999 999 999
        if (number == 0) {
            return "zero";
        }

        StringBuilder sb = new StringBuilder();

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(BILLION_START, BILLION_START + BLOCK_SIZE));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(MILLION_START, MILLION_START + BLOCK_SIZE));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(HUNDRER_THOUSAND_START, HUNDRER_THOUSAND_START + BLOCK_SIZE));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(THOUSAND_START, THOUSAND_START + BLOCK_SIZE));

        boolean needSeparator = false;
        boolean blockFull;

        blockFull = convertBlock(sb, BLOCK_NAMES[4], billions, needSeparator);
        needSeparator = blockFull;

        blockFull = convertBlock(sb, BLOCK_NAMES[3], millions, needSeparator);
        needSeparator = needSeparator || blockFull;

        blockFull = convertBlock(sb, BLOCK_NAMES[2], hundredThousands, needSeparator);
        needSeparator = needSeparator || blockFull;

        if (needSeparator && thousands > 0) {
            sb.append(SEPARATOR);
            sb.append(SPACE);
        }

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        sb.append(tradThousand);

        String result = sb.toString();

        // remove extra spaces!
        result = result.replaceAll("\\s,", ",");
        result = result.replaceAll("\\s{2,}", " ");
        result = result.trim();

        return result;
    }

    /**
     * Convert block.
     * 
     * @param sb
     *            the StringBuilder to append words in
     * @param blockName
     *            the block name
     * @param blockValue
     *            the block number value
     * @param needSeparator
     *            is comma separator needed between 2 blocks
     * @return true, if block was generated
     */
    private boolean convertBlock(final StringBuilder sb, final String blockName, final int blockValue, final boolean needSeparator) {
        boolean blockFull = false;

        if (needSeparator && blockValue > 0) {
            sb.append(SEPARATOR);
            sb.append(SPACE);
        }

        if (blockValue > 0) {
            sb.append(convertLessThanOneThousand(blockValue)).append(SPACE).append(blockName);

            blockFull = true;
        }

        if (blockValue > 1) {
            sb.append(PLURAL);
        }

        if (blockValue > 0) {
            sb.append(SPACE);
        }

        return blockFull;
    }
}
