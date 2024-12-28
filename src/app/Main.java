package app;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testReverseList(new int[]{1, 2, 3, 4, 5});
        testReverseList(new int[]{1, 2});
        testReverseList(new int[]{});
    }

    private static void testReverseList(int[] inputArray) {
        ListNode head = createLinkedList(inputArray);
        Solution solution = new Solution();
        ListNode reversedHead = solution.reverseList(head);
        System.out.println(Arrays.toString(toArray(reversedHead)));
    }

    private static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    private static int[] toArray(ListNode head) {
        if (head == null) return new int[]{};

        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        int[] result = new int[length];
        current = head;

        for (int i = 0; i < length; i++) {
            result[i] = current.val;
            current = current.next;
        }

        return result;
    }
}