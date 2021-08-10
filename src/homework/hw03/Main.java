package homework.hw03;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static final int Q_COUNT = 5;
    static final int MIN_COUNT_ANSWERS = 2;
    static final int MAX_COUNT_ANSWERS = 5;

    public static void main(String[] args) throws IOException {
        TestSystem testSystem = new TestSystem(Q_COUNT, MIN_COUNT_ANSWERS, MAX_COUNT_ANSWERS);

        testSystem.createTest();

        testSystem.testingUser();
    }
}
