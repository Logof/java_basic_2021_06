package homework.hw06.exceptionClass;

import java.io.FileWriter;
import java.io.IOException;

public class OutputExceptionMessageClass {
    private String newLine = "";
    public OutputExceptionMessageClass(ExceptionDefaultValueClass exceptionDefaultValueClass, FileWriter fileWriter) {
        try {
            newLine = exceptionDefaultValueClass.getNewLine();

            if (newLine.equals("Я упал")) {
                throw new IOException("Возникла непредвиденная ошибка");
            }
        } catch (IOException e) {
            try {
                System.out.printf("%s", e.getMessage());
                fileWriter.write(e.getMessage());
            } catch (IOException ex) {
                System.out.printf("Все совсем плохо: %s", ex.getMessage());
            }
        }
    }
}
