import java.util.*;

public class TestQuestion5 {

    public static void main(String[] args) {
        System.out.println("Running tests for Question5_RotateLinkedList...\n");
        
        testBasicFunctionality();
        testRotateByZero();
        testRotateByOne();
        testRotateByLength();
        testRotateMoreThanLength();
        testSingleNode();
        testTwoNodes();
        testNullHead();
        testRotateFullCircle();
        testLargeRotation();
        
        System.out.println("\nAll tests passed! ✓");
    }

    public static void testBasicFunctionality() {
        System.out.println("Testing basic functionality...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 2);
        String[] expected = {"ID_A05", "ID_A06", "ID_A01", "ID_A02", "ID_A03", "ID_A04"};
        assertListEqual(expected, result, "Basic functionality test");
    }

    public static void testRotateByZero() {
        System.out.println("Testing rotate by zero...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B", "C"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 0);
        String[] expected = {"A", "B", "C"};
        assertListEqual(expected, result, "Rotate by zero test");
    }

    public static void testRotateByOne() {
        System.out.println("Testing rotate by one...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B", "C", "D"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 1);
        String[] expected = {"D", "A", "B", "C"};
        assertListEqual(expected, result, "Rotate by one test");
    }

    public static void testRotateByLength() {
        System.out.println("Testing rotate by length...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B", "C"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 3);
        String[] expected = {"A", "B", "C"};
        assertListEqual(expected, result, "Rotate by length test - should be unchanged");
    }

    public static void testRotateMoreThanLength() {
        System.out.println("Testing rotate more than length...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B", "C"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 4); // 4 % 3 = 1
        String[] expected = {"C", "A", "B"};
        assertListEqual(expected, result, "Rotate more than length test");
    }

    public static void testSingleNode() {
        System.out.println("Testing single node...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 5);
        String[] expected = {"A"};
        assertListEqual(expected, result, "Single node test");
    }

    public static void testTwoNodes() {
        System.out.println("Testing two nodes...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 1);
        String[] expected = {"B", "A"};
        assertListEqual(expected, result, "Two nodes test");
    }

    public static void testNullHead() {
        System.out.println("Testing null head...");
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(null, 3);
        assertNull(result, "Null head test");
    }

    public static void testRotateFullCircle() {
        System.out.println("Testing rotate full circle...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"A", "B", "C", "D"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 8); // 8 % 4 = 0
        String[] expected = {"A", "B", "C", "D"};
        assertListEqual(expected, result, "Rotate full circle test");
    }

    public static void testLargeRotation() {
        System.out.println("Testing large rotation...");
        Question5_RotateLinkedList.ListNode head = createList(new String[]{"X", "Y", "Z"});
        Question5_RotateLinkedList.ListNode result = Question5_RotateLinkedList.rotateRight(head, 100); // 100 % 3 = 1
        String[] expected = {"Z", "X", "Y"};
        assertListEqual(expected, result, "Large rotation test");
    }

    // Helper method to create a linked list from array
    private static Question5_RotateLinkedList.ListNode createList(String[] values) {
        if (values.length == 0) return null;
        Question5_RotateLinkedList.ListNode head = new Question5_RotateLinkedList.ListNode(values[0]);
        Question5_RotateLinkedList.ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Question5_RotateLinkedList.ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to convert linked list to array for comparison
    private static String[] listToArray(Question5_RotateLinkedList.ListNode head) {
        List<String> result = new ArrayList<>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result.toArray(new String[0]);
    }

    // Assertion methods
    private static void assertListEqual(String[] expected, Question5_RotateLinkedList.ListNode actual, String testName) {
        String[] actualArray = listToArray(actual);
        if (!Arrays.equals(expected, actualArray)) {
            throw new AssertionError(String.format(
                "%s failed: Expected %s but got %s", 
                testName, Arrays.toString(expected), Arrays.toString(actualArray)
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }

    private static void assertNull(Question5_RotateLinkedList.ListNode actual, String testName) {
        if (actual != null) {
            throw new AssertionError(String.format(
                "%s failed: Expected null but got a node with value '%s'", 
                testName, actual.val
            ));
        }
        System.out.println("  ✓ " + testName + " passed");
    }
}