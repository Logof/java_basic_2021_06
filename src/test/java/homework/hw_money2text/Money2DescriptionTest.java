package homework.hw_money2text;

import homework.hw_money2text.lib.Currencies;
import homework.hw_money2text.lib.IMoney2Description;
import homework.hw_money2text.lib.Money2DescriptionImpl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Money2DescriptionTest {
    @Test
    @DisplayName("Проверка на положительность суммы")
    public void checkPositiveNumber(){
        IMoney2Description money2Description = new Money2DescriptionImpl();
        money2Description.getDescription(1, Currencies.RUB);


    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
        "-1, RUB, Введенное значение должно быть больше 0",
        "1000000000000, RUB, Введенное значение должно быть меньше 1 000 000 000 000",
        "0, RUB,    ноль рублей",
        "1, RUB,    один рубль",
        "49,    RUB,    сорок девять рублей",
        "1, USD,    один доллар",
        "100, USD,    сто долларов",
    })
    void getDescription(long first, String second, String expectedResult) {
        IMoney2Description money2Description = new Money2DescriptionImpl();
        assertEquals(expectedResult, money2Description.getDescription(first, Currencies.valueOf(second)),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

}
