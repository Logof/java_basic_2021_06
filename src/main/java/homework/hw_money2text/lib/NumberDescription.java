package homework.hw_money2text.lib;

import homework.hw_money2text.lib.helpers.NumberChecker;

public class NumberDescription implements INumberDescription {
    @Override
    public String getNumberDescription(int number) {
        try {
            NumberChecker.checkMaximumValue(number);
        } catch (Exception ex) {
            return null;
        }

        char[] charArray = String.format("%03d", number).toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        switch (charArray[0]) {
            case '1': stringBuilder.append("Сто"); break;
            case '2': stringBuilder.append("Двести"); break;
            case '3': stringBuilder.append("Триста"); break;
            case '4': stringBuilder.append("Четыреста"); break;
            case '5': stringBuilder.append("Пятьсот"); break;
            case '6': stringBuilder.append("Шестьсот"); break;
            case '7': stringBuilder.append("Семьсот"); break;
            case '8': stringBuilder.append("Восемьсот"); break;
            case '9': stringBuilder.append("Девятьсот"); break;
        }

        stringBuilder.append(" ");
        if (charArray[1] == '1') {
            String tmpString = String.valueOf(charArray[1])+String.valueOf(charArray[2]);
            switch (tmpString) {
                case "10" : stringBuilder.append("Десять"); break;
                case "11" : stringBuilder.append("Одиннадцать"); break;
                case "12" : stringBuilder.append("Двенадцать"); break;
                case "13" : stringBuilder.append("Тринадцать"); break;
                case "14" : stringBuilder.append("Четырнадцать"); break;
                case "15" : stringBuilder.append("Пятнадцать"); break;
                case "16" : stringBuilder.append("Шестнадцать"); break;
                case "17" : stringBuilder.append("Семнадцать"); break;
                case "18" : stringBuilder.append("Восемнадцать"); break;
                case "19" : stringBuilder.append("Девятнадцать"); break;
            }
        } else {
            switch (charArray[1]) {
                case '2': stringBuilder.append("Двадцать"); break;
                case '3': stringBuilder.append("Тридцать"); break;
                case '4': stringBuilder.append("Сорок"); break;
                case '5': stringBuilder.append("Пятьдесят"); break;
                case '6': stringBuilder.append( "Шестьдесят"); break;
                case '7': stringBuilder.append("Семьдесят"); break;
                case '8': stringBuilder.append("Восемьдесят"); break;
                case '9': stringBuilder.append("Девяносто"); break;
            }
        }

        stringBuilder.append(" ");
        if (charArray[1] != '1') {
            switch (charArray[2]) {
                case '1': stringBuilder.append("Один"); break;
                case '2': stringBuilder.append("Два"); break;
                case '3': stringBuilder.append("Три"); break;
                case '4': stringBuilder.append("Четыре"); break;
                case '5': stringBuilder.append("Пять"); break;
                case '6': stringBuilder.append("Шесть"); break;
                case '7': stringBuilder.append("Семь"); break;
                case '8': stringBuilder.append("Восемь"); break;
                case '9': stringBuilder.append("Девять"); break;
            }
        }
        return stringBuilder.toString().trim();
    }
}
