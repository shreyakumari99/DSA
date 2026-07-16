class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy head simplifies edge cases (e.g., creating the head of the output list)
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Loop until both lists are processed and there is no remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // Create a new node with the single digit value
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Advance pointer in l1 and l2
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}