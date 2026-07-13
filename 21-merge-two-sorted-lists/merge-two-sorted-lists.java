/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. Initialize a dummy node and a current pointer
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // 2. Traverse both lists until one becomes null
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next; // Move list1 pointer
            } else {
                current.next = list2;
                list2 = list2.next; // Move list2 pointer
            }
            current = current.next; // Move current pointer forward
        }
        
        // 3. Append the remaining nodes of the non-empty list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // 4. Return the actual head of the merged list (skipping the dummy)
        return dummy.next;
    }
}