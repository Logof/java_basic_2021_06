package homework.hw_money.utils;

public class BillionDescription implements INumberDescription{
    @Override
    public String numberDescription(int number) {
        if (number < 1 || number > 999) {
            throw new IllegalArgumentException("Передано не верное значение. Число должно быть в диапазоне от 1 до 999");
        }
        INumberDescription numberDescription = new NumberDescription();

        StringBuilder result = new StringBuilder();
        result.append(numberDescription.numberDescription(number));

        char[] charArray = String.format("%03d", number).toCharArray();

        if (charArray[1] != '1') {
            switch (charArray[2]) {
                case '0':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    return result.append(" ").append("Миллиардов").toString();
                case '1': return result.append(" ").append("Миллиард").toString();
                case '2':
                case '3':
                case '4':
                    return result.append(" ").append("Миллиарда").toString();
            }
        } else {
            return result.append(" ").append("Миллиардов").toString();
        }
        return "";
    }
}
