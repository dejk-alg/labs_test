package task6;

import java.util.Scanner;

public class Task6 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter word: \n");
        String input = scanner.next();
        StringBuilder builder = new StringBuilder(input.length());

        for (int i = input.length() - 1; i >= 0; i--)
            builder.append(input.charAt(i));
        String reversed = builder.toString();

        System.out.println("\nReversed word: \n");
        System.out.println(reversed);
    }
}