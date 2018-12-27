package task5;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<String> {
    public int compare(String word1, String word2) {
        return word1.toLowerCase().compareTo(word2.toLowerCase());
    }
}