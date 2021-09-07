package homework.hw07.test.unit;

import homework.hw07.game.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InGameWinnerPrinterTest {
    private final PrintStream consoleStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream stream = new PrintStream(outputStream);

    public void testGameWinnerPrinter() {
        String scenario = "Тест игры. Вывод имени победителя";
        String actual = "";
        try {
            Dice dice = new DiceImpl();
            GameWinnerPrinter gameWinnerPrinter = new GameWinnerPrinter() {
                @Override
                public void printWinner(Player winner) {
                    System.out.print(winner.getName());
                }
            };
            System.setOut(stream);

            Game game = new Game(dice, gameWinnerPrinter);
            game.playGame(new Player("Вася"), new Player("Петя"));

            String result = outputStream.toString();
            System.setOut(consoleStream);

            if (result.equals("Вася") || result.equals("Петя")) {
                System.out.printf("\"%s\" passed %n", scenario);
            } else {
                throw new Throwable("Не верно определен победитель");
            }

        } catch (Throwable e) {
            System.setOut(consoleStream);
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
