package homework.hw07.test.unit;

import homework.hw07.game.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InGameDiceTest {
    private final PrintStream consoleStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream stream = new PrintStream(outputStream);

    public void testDice() {
        String scenario = "Тест игры. Бросок кубика";
        try {
            System.setOut(stream);

            GameWinnerPrinter gameWinnerPrinter = new GameWinnerConsolePrinter();
            Dice dice = new Dice() {
                @Override
                public int roll() {
                    return 4;
                }
            };
            Game game = new Game(dice, gameWinnerPrinter);
            game.playGame(new Player("Вася"), new Player("Петя"));
            String actual = outputStream.toString();
            System.setOut(consoleStream);

            if (actual.equals("Ничья")) {
                System.out.printf("\"%s\" passed %n", scenario);
            } else {
                throw new RuntimeException("Не верно определен победитель. Ожидалось: 'Ничья'; Получено: '" + actual + "'");
            }
        } catch (RuntimeException e) {
            System.setOut(consoleStream);
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
