package com.triton;

import org.junit.Test;

public class ExcerciceNumberToWords extends AbstractExcercice {
    private static final String IS = " is ";

    private enum NumberWords {
        test1(0, "zero"), test2(1, "one"), test3(16, "sixteen"), test4(100, "one hundred"), test5(118, "one hundred eighteen"), test6(200, "two hundred"),

        test7(219, "two hundred nineteen"), test8(800, "eight hundred"), test9(801, "eight hundred one"), test10(1316, "one thousand, three hundred sixteen"),

        test11(1000000, "one million"), test12(2000000, "two million"), test13(3000200, "three million, two hundred"),

        test14(700000, "seven hundred thousand"), test15(9000000, "nine million"), test16(9001000, "nine million, one thousand"),

        test17(123456789, "one hundred twenty three million, four hundred fifty six thousand, seven hundred eighty nine"),

        test18(2147483647, "two billion, one hundred forty seven million, four hundred eighty three thousand, six hundred forty seven"),

        test19(3000000010L, "three billion, ten"),

        test20(100282, "one hundred thousand, two hundred eighty two");

        private long number;
        private String words;

        private NumberWords(final long numberValue, final String wordsText) {
            this.number = numberValue;
            this.words = wordsText;
        }

        public long getNumber() {
            return number;
        }

        public String getWords() {
            return words;
        }

    };

    @Test
    public final void testFreeDiskSpace() {
        StringBuilder sb = new StringBuilder();

        EnglishNumberToWords numberToWords = new EnglishNumberToWords();

        String words;
        for (NumberWords numberWords : NumberWords.values()) {
            words = numberToWords.convert(numberWords.getNumber());
            sb.append(numberWords.getNumber()).append(IS).append(words);

            assertEquals("Number in words failed : ", numberWords.getWords(), words);
        }

        LOG.info(sb.toString());
    }
}
