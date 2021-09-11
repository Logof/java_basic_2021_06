package homework.hw_money.utils;

public class CurrencyRUB implements ICurrencyDescription{
    private final String[] description = { "рублей", "рубль", "рубля", "рубля", "рубля", "рублей", "рублей", "рублей", "рублей", "рублей" };

    @Override
    public String currencyDescription(int number) {
        return description[number];
    }
}
