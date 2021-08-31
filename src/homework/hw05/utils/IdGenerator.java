package homework.hw05.utils;

public final class IdGenerator {
    private static int id;
    private static final IdGenerator idGenerator = new IdGenerator();

    private IdGenerator() {
        id = 0;
    }

    public static int getId() {
        if (idGenerator == null) {
            new IdGenerator();
        }
        return id++;
    }


    public static int getCurrId() {
        return id;
    }

    public static IdGenerator getInstance(){
        return idGenerator;
    }
}
