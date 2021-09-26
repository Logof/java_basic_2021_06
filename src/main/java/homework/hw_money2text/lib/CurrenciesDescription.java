package homework.hw_money2text.lib;

import homework.hw_money2text.lib.currencies.RUBDescription;
import homework.hw_money2text.lib.currencies.USDDescription;
import homework.hw_money2text.lib.currencies.ICurrenciesDescription;

public class CurrenciesDescription {
    private final CurrenciesDescription description = new CurrenciesDescription();

    private CurrenciesDescription(){

    }

    private static ICurrenciesDescription currenciesDescription;

    public static String getCurrenciesDescription(int number, Currencies currencies) {
        if (currencies == Currencies.RUB) {
            currenciesDescription = new RUBDescription();
        }
        if (currencies == Currencies.USD) {
            currenciesDescription = new USDDescription();
        }

        if (currenciesDescription != null) {
            return currenciesDescription.getDescriptions(number);
        }
        else {
            return "";
        }
    }

}
