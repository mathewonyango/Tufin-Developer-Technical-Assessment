import java.util.*;

public class TestQuestion4 {

    public static void main(String[] args) {
        System.out.println("Running tests for Question4_TopThreeWords...\n");
        
        testBasicFunctionality();
        testFewerThanThreeWords();
        testAllWordsUnique();
        testTiedFrequencies();
        testSingleWord();
        testEmptyString();
        testOnlySpaces();
        testCaseSensitive();
        testExtraSpaces();
        testExactlyThreeWords();
        
        System.out.println("\nAll tests passed! ✓");
    }

    public static void testBasicFunctionality() {
        System.out.println("Testing basic functionality...");
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("algorithm", "or", "to");
        assertEqual(expected, result, "Basic functionality test");
    }

    public static void testFewerThanThreeWords() {
        System.out.println("Testing fewer than three unique words...");
        String sentence = "hello hello world";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("hello", "world");
        assertEqual(expected, result, "Fewer than three words test");
    }

    public static void testAllWordsUnique() {
        System.out.println("Testing all words unique...");
        String sentence = "apple banana cherry date elephant";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("apple", "banana", "cherry");
        assertEqual(expected, result, "All words unique test - should return first 3 alphabetically");
    }

    public static void testTiedFrequencies() {
        System.out.println("Testing tied frequencies...");
        String sentence = "cat dog cat dog bird fish bird fish";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("bird", "cat", "dog");
        assertEqual(expected, result, "Tied frequencies test - should sort alphabetically");
    }

    public static void testSingleWord() {
        System.out.println("Testing single word...");
        String sentence = "hello";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("hello");
        assertEqual(expected, result, "Single word test");
    }

    public static void testEmptyString() {
        System.out.println("Testing empty string...");
        String sentence = "";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList();
        assertEqual(expected, result, "Empty string test");
    }

    public static void testOnlySpaces() {
        System.out.println("Testing only spaces...");
        String sentence = "   ";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList();
        assertEqual(expected, result, "Only spaces test");
    }

    public static void testCaseSensitive() {
        System.out.println("Testing case sensitivity...");
        String sentence = "Hello hello HELLO world World";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("HELLO", "Hello", "World");
        assertEqual(expected, result, "Case sensitive test");
    }

    public static void testExtraSpaces() {
        System.out.println("Testing extra spaces...");
        String sentence = "  hello   world  hello   ";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("hello", "world");
        assertEqual(expected, result, "Extra spaces test");
    }

    public static void testExactlyThreeWords() {
        System.out.println("Testing exactly three unique words...");
        String sentence = "red blue green red blue";
        List<String> result = Question4_TopThreeWords.topThreeWords(sentence);
        List<String> expected = Arrays.asList("blue", "red", "green");
        assertEqual(expected, result, "Exactly three words test");
    }

    // Simple assertion method for lists
    private static void assertEqual(List<String> expected, List<String> actual, String testName) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format(
                "%s failed: Expected %s but got %s", 
                testName, expected, actual
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }
}
