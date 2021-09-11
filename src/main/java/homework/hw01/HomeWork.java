package homework.hw01;

import java.util.Base64;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter you full name");
        String fullName = sc.nextLine();

        String encodedFullName = Base64.getEncoder().encodeToString(fullName.getBytes());
        System.out.println("Program result: " + encodedFullName);
        System.out.println("Decode result: " + new String(Base64.getDecoder().decode(encodedFullName.getBytes())));
    }
}
