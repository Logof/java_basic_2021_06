package homework.hw07.test.unit;


import homework.hw07.game.GameWinnerConsolePrinter;
import homework.hw07.game.Player;

import java.io.ByteArrayOutputStream;

public class GameWinnerPrinterTest {
    private final GameWinnerConsolePrinter gameWinnerConsolePrinter = new GameWinnerConsolePrinter();

    public void testGameWinnerPrinter() {
        String scenario = "Тест вывода имени победителя";
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            String expected = "Вася";
            gameWinnerConsolePrinter.printWinner(new Player(expected));
            String actual = outputStream.toString();

            if (actual.equals("Победитель: Вася")) {
                System.out.printf("\"%s\" passed %n", scenario);
            }
            throw new Throwable("Не верный вывод имени победителя");

        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }


    }

}
