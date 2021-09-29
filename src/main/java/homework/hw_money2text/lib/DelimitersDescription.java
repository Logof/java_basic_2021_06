package homework.hw_money2text.lib;

import homework.hw_money2text.lib.helpers.Delimeters;

public class DelimitersDescription implements IDelimitersDescription {

    @Override
    public String getDelimetersDescription(int number, Delimeters delimeter) {
        if (delimeter == Delimeters.thousand) {
            return getThousandDescription(number);
        }
        if (delimeter == Delimeters.millions) {
            return getMillionDescription(number);
        }
        if (delimeter == Delimeters.billions) {
            return getBillionsDescription(number);
        }
        return "";
    }

    private String getBillionsDescription(int number) {
        char[] charArray = String.format("%03d", number).toCharArray();
        StringBuilder result = new StringBuilder();
        if (charArray[1] != '1') {
            switch (charArray[2]) {
                case '0':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return result.append(" ").append("Миллиардов").append(" ").toString();
                case '1': return result.append(" ").append("Миллиард").append(" ").toString();
                case '2':
                case '3':
                case '4':
                    return result.append(" ").append("Миллиарда").append(" ").toString();
            }
        } else {
            return result.append(" ").append("Миллиардов").append(" ").toString();
        }
        return "";
    }

    private String getMillionDescription(int number) {
        StringBuilder result = new StringBuilder();

        char[] charArray = String.format("%03d", number).toCharArray();

        if (charArray[1] != '1') {
            switch (charArray[2]) {
                case '0':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return result.append(" ").append("Миллионов").append(" ").toString();
                case '1': return result.append(" ").append("Миллион").append(" ").toString();
                case '2':
                case '3':
                case '4':
                    return result.append(" ").append("Миллиона").append(" ").toString();
            }
        } else {
            return result.append(" ").append("Миллионов").append(" ").toString();
        }
        return "";
    }

    private String getThousandDescription(int number){
        StringBuilder result = new StringBuilder();

        char[] charArray = String.format("%03d", number).toCharArray();

        if (charArray[1] != '1') {
            switch (charArray[2]) {
                case '0':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return result.append(" ").append("Тысяч").append(" ").toString();
                case '1': return result.append(" ").append("Тысяча").append(" ").toString();
                case '2':
                case '3':
                case '4':
                    return result.append(" ").append("Тысячи").append(" ").toString();
            }
        } else {
            return result.append(" ").append("Тысяч").append(" ").toString();
        }
        return "";
    }


}
