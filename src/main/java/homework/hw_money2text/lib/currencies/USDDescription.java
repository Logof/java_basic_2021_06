package homework.hw_money2text.lib.currencies;

public class USDDescription implements ICurrenciesDescription{
    private final String[] description = { "долларов", "доллар", "доллара", "доллара", "доллара", "долларов", "долларов", "долларов", "долларов", "долларов" };

    @Override
    public String getDescriptions(int number) {
        return description[number%10];
    }
}
