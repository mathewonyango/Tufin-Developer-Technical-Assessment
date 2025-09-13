import java.util.*;

public class TestQuestion3 {

    public static void main(String[] args) {
        System.out.println("Running tests for Question3_MinDistanceBetween...\n");
        
        testBasicFunctionality();
        testConsecutiveMinimums();
        testTwoMinimums();
        testMultipleMinimums();
        testSingleElement();
        testAllSameElements();
        testMinimumAtEnds();
        testNegativeNumbers();
        testLargeDistance();
        
        System.out.println("\nAll tests passed! ✓");
    }

    public static void testBasicFunctionality() {
        System.out.println("Testing basic functionality...");
        int[] arr = {1, 200000, 323442, 1, 4, 5, 2, 1000000000};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(3, result, "Basic functionality test");
    }

    public static void testConsecutiveMinimums() {
        System.out.println("Testing consecutive minimums...");
        int[] arr = {3, 1, 1, 4, 5};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(1, result, "Consecutive minimums test");
    }

    public static void testTwoMinimums() {
        System.out.println("Testing exactly two minimums...");
        int[] arr = {5, 2, 8, 2, 9};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(2, result, "Two minimums test");
    }

    public static void testMultipleMinimums() {
        System.out.println("Testing multiple minimums...");
        int[] arr = {3, 1, 4, 1, 5, 1, 6};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(2, result, "Multiple minimums test - should find closest pair");
    }

    public static void testSingleElement() {
        System.out.println("Testing single element...");
        int[] arr = {42};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(1, result, "Single element test - distance should be array length");
    }

    public static void testAllSameElements() {
        System.out.println("Testing all same elements...");
        int[] arr = {5, 5, 5, 5, 5};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(1, result, "All same elements test");
    }

    public static void testMinimumAtEnds() {
        System.out.println("Testing minimums at ends...");
        int[] arr = {1, 4, 5, 6, 1};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(4, result, "Minimums at ends test");
    }

    public static void testNegativeNumbers() {
        System.out.println("Testing negative numbers...");
        int[] arr = {-2, 5, -2, 8, -2};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(2, result, "Negative numbers test");
    }

    public static void testLargeDistance() {
        System.out.println("Testing large distance...");
        int[] arr = {1, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int result = Question3_MinDistanceBetween.minDistance(arr);
        assertEqual(9, result, "Large distance test");
    }

    // Simple assertion method
    private static void assertEqual(int expected, int actual, String testName) {
        if (expected != actual) {
            throw new AssertionError(String.format(
                "%s failed: Expected %d but got %d", 
                testName, expected, actual
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }
}
