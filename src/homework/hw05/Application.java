package homework.hw05;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Application {
    private static Bank bank;

    public static void main(String[] args) throws IOException {
        bank = new Bank();

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("==============================================================\n\n");
        System.out.println("Ищем счет(а) по ID клиента");
        String inputString = bufferedReader.readLine();
        bank.printBankAccountByClientId(Integer.parseInt(inputString));

        System.out.println("Ищем клиента по счету");
        inputString = bufferedReader.readLine();
        bank.printClientByBankAccount(inputString);
    }
}
