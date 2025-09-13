import java.util.*;

public class TestQuestion1 {

    public static void main(String[] args) {
        System.out.println("Running tests for Question1_GetLongestString...\n");
        
        testBasicFunctionality();
        testEmptyList();
        testSingleValidString();
        testSingleInvalidString();
        testInvalidCharacters();
        testConsecutiveIdenticalCharacters();
        testMultipleSameLengthStrings();
        
        System.out.println("\nAll tests passed! ✓");
    }

    public static void testBasicFunctionality() {
        System.out.println("Testing basic functionality...");
        List<String> strings = Arrays.asList("AABCDA", "ABCDZADC", "ABCDBCA", "ABCDABDCA");
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("ABCDABDCA", result, "Basic functionality test");
    }

    public static void testEmptyList() {
        System.out.println("Testing empty list...");
        List<String> emptyList = new ArrayList<>();
        String result = Question1_GetLongestString.getLongestString("ABCD", emptyList);
        assertEqual("", result, "Empty list test");
    }

    public static void testSingleValidString() {
        System.out.println("Testing single valid string...");
        List<String> strings = Arrays.asList("ABCD");
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("ABCD", result, "Single valid string test");
    }

    public static void testSingleInvalidString() {
        System.out.println("Testing single invalid string...");
        List<String> strings = Arrays.asList("AABBCD"); // has consecutive A's and B's
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("", result, "Single invalid string test");
    }

    public static void testInvalidCharacters() {
        System.out.println("Testing invalid characters...");
        List<String> strings = Arrays.asList("ABCDE", "ABCD"); // E is not valid
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("ABCD", result, "Invalid characters test");
    }

    public static void testConsecutiveIdenticalCharacters() {
        System.out.println("Testing consecutive identical characters...");
        List<String> strings = Arrays.asList("AABCD", "ABCCD", "ABCD");
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("ABCD", result, "Consecutive identical characters test");
    }

    public static void testMultipleSameLengthStrings() {
        System.out.println("Testing multiple same length strings...");
        // When multiple strings have same length, should return the first one found
        List<String> strings = Arrays.asList("ABCD", "DCBA", "CADB");
        String result = Question1_GetLongestString.getLongestString("ABCD", strings);
        assertEqual("ABCD", result, "Multiple same length strings test");
    }

    // Simple assertion method
    private static void assertEqual(String expected, String actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format(
                "%s failed: Expected '%s' but got '%s'", 
                testName, expected, actual
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }
}
