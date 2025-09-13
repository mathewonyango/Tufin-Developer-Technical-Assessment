import java.util.*;

public class Question4_TopThreeWords {

    /**
     * Returns the three most common words in a sentence, sorted alphabetically if tied.
     */
    public static List<String> topThreeWords(String sentence) {
        String[] words = sentence.split("\\s+");
        Map<String, Integer> countMap = new HashMap<>();

        for (String w : words) countMap.put(w, countMap.getOrDefault(w, 0) + 1);

        List<String> sorted = new ArrayList<>(countMap.keySet());
        sorted.sort((a, b) -> {
            int cmp = countMap.get(b).compareTo(countMap.get(a));
            if (cmp == 0) return a.compareTo(b);
            return cmp;
        });

        return sorted.subList(0, Math.min(3, sorted.size()));
    }

    public static void main(String[] args) {
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        System.out.println(topThreeWords(sentence)); // Expected: [algorithm, or, to]
    }
}
