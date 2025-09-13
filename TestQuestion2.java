import java.util.*;

public class TestQuestion2 {

    public static void main(String[] args) {
        System.out.println("Running tests for Question2_FirstUniqueProduct...\n");
        
        testBasicFunctionality();
        testNoUniqueProduct();
        testSingleProduct();
        testAllUniqueProducts();
        testEmptyArray();
        testFirstUniqueAtEnd();
        testCaseSensitive();
        testMultipleDuplicates();
        testNullElements();
        
        System.out.println("\nAll tests passed! ✓");
    }

    public static void testBasicFunctionality() {
        System.out.println("Testing basic functionality...");
        String[] products = {"Apple", "Computer", "Apple", "Bag"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("Computer", result, "Basic functionality test");
    }

    public static void testNoUniqueProduct() {
        System.out.println("Testing no unique product...");
        String[] products = {"Apple", "Computer", "Apple", "Computer"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertNull(result, "No unique product test");
    }

    public static void testSingleProduct() {
        System.out.println("Testing single product...");
        String[] products = {"Apple"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("Apple", result, "Single product test");
    }

    public static void testAllUniqueProducts() {
        System.out.println("Testing all unique products...");
        String[] products = {"Apple", "Computer", "Bag", "Phone"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("Apple", result, "All unique products test - should return first");
    }

    public static void testEmptyArray() {
        System.out.println("Testing empty array...");
        String[] products = {};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertNull(result, "Empty array test");
    }

    public static void testFirstUniqueAtEnd() {
        System.out.println("Testing first unique at end...");
        String[] products = {"Apple", "Apple", "Computer", "Computer", "Bag"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("Bag", result, "First unique at end test");
    }

    public static void testCaseSensitive() {
        System.out.println("Testing case sensitivity...");
        String[] products = {"apple", "Apple", "APPLE", "Computer"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("apple", result, "Case sensitive test - should return first unique");
    }

    public static void testMultipleDuplicates() {
        System.out.println("Testing multiple duplicates...");
        String[] products = {"A", "B", "A", "C", "B", "D", "C", "E"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("D", result, "Multiple duplicates test");
    }

    public static void testNullElements() {
        System.out.println("Testing with null elements...");
        String[] products = {null, "Apple", null, "Computer"};
        String result = Question2_FirstUniqueProduct.firstUniqueProduct(products);
        assertEqual("Apple", result, "Null elements test");
    }

    // Simple assertion methods
    private static void assertEqual(String expected, String actual, String testName) {
        if (expected == null && actual == null) {
            System.out.println("  ✓ " + testName + " passed");
            return;
        }
        if (expected == null || !expected.equals(actual)) {
            throw new AssertionError(String.format(
                "%s failed: Expected '%s' but got '%s'", 
                testName, expected, actual
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }

    private static void assertNull(String actual, String testName) {
        if (actual != null) {
            throw new AssertionError(String.format(
                "%s failed: Expected null but got '%s'", 
                testName, actual
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }
}