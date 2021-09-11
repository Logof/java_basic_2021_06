package homework.hw06;

import homework.hw06.exceptionClass.ExceptionDefaultValueClass;
import homework.hw06.exceptionClass.OutputExceptionMessageClass;

import java.io.FileWriter;
import java.io.IOException;


public class ExceptionApp {
    private static final String TMP_FOLDER = System.getProperty("java.io.tmpdir");
    private static final String TMP_FILE = "/file.tmp";

    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter(TMP_FOLDER+TMP_FILE, false)) {

            ExceptionDefaultValueClass exceptionDefaultValueClass = new ExceptionDefaultValueClass();
            exceptionDefaultValueClass.workWithException();

            OutputExceptionMessageClass outExceptionMessage = new OutputExceptionMessageClass(exceptionDefaultValueClass, fileWriter);
        }
    }
}