class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            // Find the k-th node
            ListNode kth = groupPrev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            // Reverse k nodes
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            for (int i = 0; i < k; i++) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Reconnect reversed group
            ListNode tmp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = tmp;
        }
    }
}
