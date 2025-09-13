import java.util.*;

public class Question1_GetLongestString {

    /**
     * Returns the longest string that:
     * 1. Contains only valid characters
     * 2. Has no consecutive identical characters
     */

  
    public static String getLongestString(String validChars, List<String> strings) {
        Set<Character> validSet = new HashSet<>();
        for (char c : validChars.toCharArray()) validSet.add(c);

        String longest = "";
        for (String s : strings) {
            if (isValid(s, validSet) && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    private static boolean isValid(String s, Set<Character> validSet) {
        for (int i = 0; i < s.length(); i++) {
            if (!validSet.contains(s.charAt(i))) 
            return false;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1))
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA");
        String result = getLongestString("ABCD", strings);
        System.out.println("Longest valid string: " + result); // Expected: ABCDABDCA
    }
}
