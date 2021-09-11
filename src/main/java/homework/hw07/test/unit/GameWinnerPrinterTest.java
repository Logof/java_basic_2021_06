package homework.hw07.test.unit;


import homework.hw07.game.GameWinnerConsolePrinter;
import homework.hw07.game.Player;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GameWinnerPrinterTest {
    private final GameWinnerConsolePrinter gameWinnerConsolePrinter = new GameWinnerConsolePrinter();

    private final PrintStream consoleStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream stream = new PrintStream(outputStream);

    public void testGameWinnerPrinter() {
        String scenario = "Тест вывода имени победителя";
        try {
            System.setOut(stream);
            String expected = "Вася";
            gameWinnerConsolePrinter.printWinner(new Player(expected));
            String actual = outputStream.toString();
            System.setOut(consoleStream);

            if (actual.equals("Победитель: Вася")) {
                System.out.printf("\"%s\" passed %n", scenario);

            } else {
                throw new RuntimeException("Не верный вывод имени победителя. Ожидалось '" + expected + "'; Получено: '" + actual + "'");
            }
        } catch (RuntimeException  e) {
            System.setOut(consoleStream);
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
