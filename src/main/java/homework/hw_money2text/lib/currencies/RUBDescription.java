package homework.hw_money2text.lib.currencies;

public class RUBDescription implements ICurrenciesDescription{
    private final String[] description = { "рублей", "рубль", "рубля", "рубля", "рубля", "рублей", "рублей", "рублей", "рублей", "рублей" };

    @Override
    public String getDescriptions(int number) {
        return description[number%10];
    }
}
