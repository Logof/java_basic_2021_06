package homework.hw05.utils;

public class AccountGenerator {
    private static int id;
    private static final AccountGenerator accountGenerator = new AccountGenerator();

    private AccountGenerator() {
        id = 1;
    }

    public static String generateNewAccountNumber() {
        if (accountGenerator == null) {
            new AccountGenerator();
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("40817810").append(String.format("%012d", id++)).toString();
    }

    public static AccountGenerator getInstance(){
        return accountGenerator;
    }
}
