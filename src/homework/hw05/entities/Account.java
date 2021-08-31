package homework.hw05.entities;

import homework.hw05.utils.AccountGenerator;

public class Account {
    private String accountNum;
    private int clientID;

    private AccountGenerator accountGenerator = AccountGenerator.getInstance();

    public Account(int clientID) {
        this.clientID = clientID;
        this.accountNum = accountGenerator.generateNewAccountNumber();
    }


    public int getClientID() {
        return clientID;
    }


    public String getAccountNum() {
        return accountNum;
    }

    @Override
    public String toString(){
        return accountNum;
    }

    public boolean equals(String string) {
        if (this.accountNum.equals(string)) {
            return true;
        }
        return false;
    }
}
