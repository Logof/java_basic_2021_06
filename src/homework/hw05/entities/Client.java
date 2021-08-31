package homework.hw05.entities;

import homework.hw05.utils.IdGenerator;

import java.util.List;

public class Client {
    private int clientID;
    private String surname;
    private String name;

    private IdGenerator idGenerator = IdGenerator.getInstance();

    public Client(String surname, String name) {
        this.surname = surname;
        this.name = name;
        this.clientID = IdGenerator.getId();
    }

    public int getClientID() {
        return clientID;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        return  stringBuilder.append("ID = ").append(clientID).append(" (Surname = ").append(surname).append("; Name = ").append(name).append(")").toString();
    }

}
