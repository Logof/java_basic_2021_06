package homework.hw05;

import homework.hw05.entities.Account;
import homework.hw05.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Bank {
    private List<Client> clients;
    private List<Account> accounts;

    public Bank(){
        clients = new ArrayList<>();
        accounts = new ArrayList<>();
        fillClients();
        printAllClients();
    }

    private void printAllClients() {
        for (int i = 0; i < clients.size(); i++) {
            System.out.println(clients.get(i).toString());
            printBankAccountByClientId(i);
        }
    }

    private void fillClients() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {

            Client client = new Client("Фамилия "+i, "Имя " + i);

            int countAccount = random.nextInt(5)+1;
            for (int j = 0; j < countAccount; j++) {
                Account account = new Account(client.getClientID());
                accounts.add(account);
            }
            clients.add(client);
        }
    }

    public void printBankAccountByClientId(int id) {
        Client client = clients.get(id);
        List<Account> result = getAccounts(client);
        for (Account account : result) {
            System.out.println(account.toString());
        }
    }

    private List<Account> getAccounts(Client client) {
        return accounts.stream().filter(account -> account.getClientID() == client.getClientID()).toList();
    }

    private Client findClient(Account account) {
        return clients.get(account.getClientID());
    }

    public void printClientByBankAccount(String bankNumber) {
        for (Account account : accounts) {
            if (account.equals(bankNumber)) {
                System.out.println(findClient(account).toString());
                break;
            }
        }
    }
}
