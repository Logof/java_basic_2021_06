package homework.hw_money2text.lib.helpers;

import static homework.hw_money2text.lib.ErrorsMessages.MSG_NUMBER_VERY_BIG;
import static homework.hw_money2text.lib.ErrorsMessages.MSG_NUMBER_IS_POSITIVE;

public class NumberChecker {
    private final NumberChecker numberChecker = new NumberChecker();

    private NumberChecker() {

    }

    public static void checkPositive(long number) throws Exception {
        if (number < 0) {
            throw new Exception(MSG_NUMBER_IS_POSITIVE);
        }
    }

    public static void checkNonExceedingValue(int number, int maxValue) throws Exception {
        if (number > maxValue) {
            throw new Exception(MSG_NUMBER_VERY_BIG);
        }
    }

    public static void checkMaximumValue(long number) throws Exception {
        if (number >= 1_000_000_000_000L) {
            throw new Exception(MSG_NUMBER_VERY_BIG);
        }
    }

    public static int[] getIntArray(long number) {
        int[] result = new int[5];
        int i = 0;
        long tmpnumber = number;

        do {
            result[i] = (int) (tmpnumber % 1000);
            tmpnumber = tmpnumber / 1000;
            i += 1;
        }
        while (tmpnumber > 0);

        return result;
    }
}
