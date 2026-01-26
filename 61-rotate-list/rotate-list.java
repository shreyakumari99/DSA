/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Calculate the length of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Connect the tail to the head to form a cycle
        tail.next = head;

        // Find the new tail
        k = k % length;
        int steps = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < steps; i++) {
            newTail = newTail.next;
        }

        // Break the cycle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}    