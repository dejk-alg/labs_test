package task4;

import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static int minValue;
    private static int maxValue;
    private static int target;

    private static boolean guess() {
        System.out.println(String.format("Enter number in range between %d and %d", minValue, maxValue));
        Scanner scanner = new Scanner(System.in);
        int guessNumber = scanner.nextInt();
        if (guessNumber < minValue || guessNumber > maxValue) {
            System.out.println("Your guess is out of possible bounds");
            return false;
        }
        else if (guessNumber == target) {
            System.out.println("Your guess is correct");
            return true;
        }
        else if (guessNumber < target) {
            System.out.println("Your guess is lower than target");
            minValue = guessNumber + 1;
            return false;
        }

        else {
            System.out.println("Your guess is higher than target");
            maxValue = guessNumber - 1;
            return false;
        }
    }

    public static void run() {
        minValue = 0;
        maxValue = 100;
        Random random = new Random();
        target = random.nextInt(maxValue + 1);
        while (!guess()) {}
    }
}
