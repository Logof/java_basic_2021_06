package homework.hw_money;

import homework.hw_money.utils.*;

public class MoneyToText {
    private final INumberDescription trilliardDesc = new TrilliardDescription();
    private final INumberDescription billionDesc = new BillionDescription();
    private final INumberDescription millionDesc = new MillionDescription();
    private final INumberDescription thousandDesc = new ThousandDescription();
    private final INumberDescription hundredDesc= new NumberDescription();

    public void moneyToText(long amount) {
        long abs_amount;

        int b_triliard;
        int b_billion;
        int b_million;
        int b_thousand;
        int b_hundred;

        boolean b_minus = false;

        if (amount >= 1_000_000_000_000_000L) {

            System.out.println("Сильно большое число. Выходим");
            throw new IllegalArgumentException("Сильно большое число. Выходим");
        }

        if (amount <0) {
            b_minus = true;
        }
        abs_amount = Math.abs(amount);

        char[] charArray = String.format("%015d", abs_amount).toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        b_triliard = Integer.parseInt(stringBuilder.append(charArray[0]).append(charArray[1]).append(charArray[2]).toString());
        stringBuilder = new StringBuilder();
        b_billion = Integer.parseInt(stringBuilder.append(charArray[3]).append(charArray[4]).append(charArray[5]).toString());
        stringBuilder = new StringBuilder();
        b_million = Integer.parseInt(stringBuilder.append(charArray[6]).append(charArray[7]).append(charArray[8]).toString());
        stringBuilder = new StringBuilder();
        b_thousand = Integer.parseInt(stringBuilder.append(charArray[9]).append(charArray[10]).append(charArray[11]).toString());
        stringBuilder = new StringBuilder();
        b_hundred = Integer.parseInt(stringBuilder.append(charArray[12]).append(charArray[13]).append(charArray[14]).toString());





        StringBuilder result = new StringBuilder();

        if (b_minus) {
            result.append("минус ");
        }

        if (b_triliard > 0 ) {
            result.append(trilliardDesc.numberDescription(b_triliard).trim());
        }

        if (b_billion > 0 ) {
            result.append(" ").append(billionDesc.numberDescription(b_billion).trim());
        }

        if (b_million > 0 ) {
            result.append(" ").append(millionDesc.numberDescription(b_million).trim());
        }

        if (b_thousand > 0 ) {
            result.append(" ").append(thousandDesc.numberDescription(b_thousand).trim());
        }

        result.append(" ").append(hundredDesc.numberDescription(b_hundred));

        System.out.print(result.toString().toLowerCase().trim());
    }


}
