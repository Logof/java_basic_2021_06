package homework.hw06.exceptionClass;

public class ExceptionDefaultValueClass {
    private String newLine = "";

    public void workWithException() {
        try {
            ReturnThrowClass throwClass = new ReturnThrowClass();
            newLine = throwClass.getStringLine();
            System.out.println(newLine);
        } catch (IllegalAccessException ex) {
            newLine = ex.getMessage();
        }
    }

    public String getNewLine() {
        return newLine;
    }
}
