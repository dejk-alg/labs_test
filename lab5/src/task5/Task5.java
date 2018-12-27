package task5;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
    public static void run() {
        ArrayList<String> words = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter text, press ctrl + D to finish: \n");
        while (scanner.hasNext())
            words.add(scanner.next());

        words.sort(new AlphabeticalComparator());
        System.out.println("\nSorted words: \n");
        for (String word: words)
            System.out.println(word);
    }
}
