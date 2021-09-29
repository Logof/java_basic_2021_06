package homework.hw_money2text;

import homework.hw_money2text.lib.Currencies;
import homework.hw_money2text.lib.IMoney2Description;
import homework.hw_money2text.lib.Money2DescriptionImpl;

public class Application {

    public static void main(String[] args) {

        IMoney2Description money2Description = new Money2DescriptionImpl();
        System.out.print(money2Description.getDescription(1000000000000L, Currencies.USD));
    }

}
