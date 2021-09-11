package homework.hw06.exceptionClass;

public class ReturnThrowClass {
    public String getStringLine() throws IllegalAccessException {
        throw new IllegalAccessException("Я упал");
    }
}
