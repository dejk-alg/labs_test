package task2;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Task2 {

    private static Random random = new Random();

    public static void run() {
        int alphaSize = 150;
        int minValue = 1;
        int maxValue = 200;
        int betaSize = 15;

        ArrayList<Integer> alpha = new ArrayList<>();
        // fill list with random integer values
        for (int i = 0; i < alphaSize; i++) alpha.add(minValue + random.nextInt(maxValue + 1 - minValue));

        // create sorted copy of list alpha
        ArrayList<Integer> alphaCopy = new ArrayList<>(alpha);
        alphaCopy.sort(Collections.reverseOrder());

        // take only max elements from sorted list
        List<Integer> beta = alphaCopy.subList(0, betaSize);

        //output to console
        System.out.println("\nMax values: ");
        beta.forEach(System.out::println);

        //output to file
        try {
            PrintWriter writer = new PrintWriter("task2_output.txt", "UTF-8");
            beta.forEach(writer::println);
            writer.close();
        }
        catch (Exception e) {}
    }
}
