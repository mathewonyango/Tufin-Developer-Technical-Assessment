public class Question5_RotateLinkedList {

    static class ListNode {
        String val;
        ListNode next;
        ListNode(String val) { this.val = val; }
    }

    /**
     * Rotates a linked list to the right by n positions.
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;

        // Compute length
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // Connect tail to head to make it circular
        oldTail.next = head;

        // Find new tail: (length - n % length - 1)
        int stepsToNewTail = length - n % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) newTail = newTail.next;

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        ListNode rotated = rotateRight(head, 2);
        printList(rotated); // Expected: ID_A05->ID_A06->ID_A01->ID_A02->ID_A03->ID_A04->null
    }
}
