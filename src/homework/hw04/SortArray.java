package homework.hw04;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SortArray {
    private static List<Integer> intArray = new ArrayList<>();

    private static List<Integer> intUserSortArray = new ArrayList<>();
    private static List<Integer> intJavaSortArray = new ArrayList<>();
    private static int COUNT_ELEMENT = 100000;

    private static void fillArray() {
        for (int i = 0; i< COUNT_ELEMENT; i++) {
            intArray.add((int) (Math.random() * (i)) + i);
        }
    }

    private static void slowSorning(){
        int step = 0;
        do {
            for (int i = step+1; i < intUserSortArray.size(); i++) {
                if (intUserSortArray.get(step) > intUserSortArray.get(i)) {
                    int tmp = intUserSortArray.get(i);
                    intUserSortArray.set(i, intUserSortArray.get(step));
                    intUserSortArray.set(step, tmp);
                }
            }
            step += 1;
        } while (step != intUserSortArray.size());
    }

    private static void sortUserMethod() {
        Date begin = new Date(System.currentTimeMillis());
        slowSorning();
        Date end = new Date(System.currentTimeMillis());
        System.out.println("Сортировка реализованная пользователем:");
        printReportTime(begin, end);
    }

    public static String getDateDiff(Date begin, Date end) {
        long diffInMillies = end.getTime() - begin.getTime();
        long millis = diffInMillies % 1000;
        long second = (diffInMillies / 1000) % 60;
        long minute = (diffInMillies / (1000 * 60)) % 60;
        long hour = (diffInMillies / (1000 * 60 * 60)) % 24;
        return String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
    }

    private static void sortJavaMethod() {
        Date begin = new Date(System.currentTimeMillis());

        Collections.sort(intJavaSortArray);

        Date end = new Date(System.currentTimeMillis());

        System.out.println("Сортировка реализованная Java:");
        printReportTime(begin, end);
    }

    private static void printReportTime(Date begin, Date end) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");

        System.out.println(String.format("Начало работы сортировки: %s", formatter.format(begin.getTime())));
        System.out.println(String.format("Окончание работы сортировки: %s", formatter.format(end.getTime())));
        System.out.println(String.format("Заняло: %s", getDateDiff(begin, end)));
    }

    public static void main(String[] args) {
        fillArray();

        intJavaSortArray.addAll(intArray);
        intUserSortArray.addAll(intArray);

        sortUserMethod();
        System.out.println("\n");
        sortJavaMethod();
    }
}
