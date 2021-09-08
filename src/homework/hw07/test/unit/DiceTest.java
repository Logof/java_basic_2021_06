package homework.hw07.test.unit;

import homework.hw07.game.DiceImpl;

public class DiceTest {

    private final DiceImpl dice = new DiceImpl();

    public void testDice() {
        String scenario = "Тест игрового кубика";
        try {
            int actual = dice.roll();

            if (actual > 0 && actual < 7) {
                System.out.printf("\"%s\" passed %n", scenario);
            }
            else {
                throw new RuntimeException("Выпало не допустимое значение = " + actual);
            }
        } catch (RuntimeException e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
