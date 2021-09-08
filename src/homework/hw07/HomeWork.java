package homework.hw07;


import homework.hw07.test.unit.DiceTest;
import homework.hw07.test.unit.InGameDiceTest;
import homework.hw07.test.unit.InGameWinnerPrinterTest;
import homework.hw07.test.unit.GameWinnerPrinterTest;

import java.io.IOException;

public class HomeWork {
    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        DiceTest diceTest = new DiceTest();
        diceTest.testDice();

        GameWinnerPrinterTest gameWinnerPrinterTest = new GameWinnerPrinterTest();
        gameWinnerPrinterTest.testGameWinnerPrinter();

        InGameDiceTest inGameDiceTest = new InGameDiceTest();
        inGameDiceTest.testDice();

        InGameWinnerPrinterTest inGameWinnerPrinterTest = new InGameWinnerPrinterTest();
        inGameWinnerPrinterTest.testGameWinnerPrinter();
    }

}