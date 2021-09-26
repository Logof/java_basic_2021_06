package homework.hw_money2text.lib;

import homework.hw_money2text.lib.helpers.Delimeters;
import homework.hw_money2text.lib.helpers.NumberChecker;

public class Money2DescriptionImpl implements IMoney2Description{
    @Override
    public String getDescription(long number, Currencies currencie) {
        int[] array = new int[5];

        try {
            NumberChecker.checkMaximumValue(number);
            NumberChecker.checkPositive(number);
        } catch (Exception ex) {
            return ex.getMessage();
        }

        StringBuilder result = new StringBuilder();
        IDelimitersDescription delimeterDescription = new DelimitersDescription();

        if (number == 0) {
            array[0] = 0;
            result.append("ноль").append(delimeterDescription.getDelimetersDescription(array[0], Delimeters.getById((long)0)));
        }

        /// 999_999_999_999L

        INumberDescription numberDescription = new NumberDescription();
        array = NumberChecker.getIntArray(number);
        //1 234 567 890L


        for (int i = array.length-1; i >= 0; i--){
            if (array[i] != 0 ) {
                result.append(numberDescription.getNumberDescription(array[i]));
                result.append(delimeterDescription.getDelimetersDescription(array[i], Delimeters.getById((long) i)));
            }
        }

        result.append(" ").append(CurrenciesDescription.getCurrenciesDescription(array[0], currencie));
        return result.toString().toLowerCase();
    }

    @Override
    public String getDescription(int number, Currencies currencie) {
        return getDescription((long)number, currencie);
    }
}
