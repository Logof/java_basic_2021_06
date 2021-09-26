package homework.hw_money2text.lib;

public interface IMoney2Description {
    String getDescription(long number, Currencies currencie);
    String getDescription(int number, Currencies currencie);
}
