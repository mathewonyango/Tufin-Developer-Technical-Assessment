import java.util.*;

public class Question2_FirstUniqueProduct {

    /**
     * Returns the first product that occurs only once in the array.
     * Returns null if none.
     */
    public static String firstUniqueProduct(String[] products) {
        LinkedHashMap<String, Integer> countMap = new LinkedHashMap<>();
        for (String p : products) countMap.put(p, countMap.getOrDefault(p, 0) + 1);

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] products = {"Apple", "Computer", "Apple", "Bag"};
        System.out.println(firstUniqueProduct(products)); // Expected: Computer
    }
}

