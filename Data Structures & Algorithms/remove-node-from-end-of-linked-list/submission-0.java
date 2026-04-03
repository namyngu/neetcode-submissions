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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        // Set pointer2 to be at index n.
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        for (int i = 0; i < n; i++) {
            pointer2 = pointer2.next;
        }

        // Edge case: n = size of linked list, cannot access index n
        if (pointer2 == null) return head.next;


        // Increment each pointer until end of linked list.
        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        // Remove nth node
        ListNode nthNode = pointer1.next;

        // Edge case: n is at the end of the list
        if (nthNode.next == null) {
            pointer1.next = null;
            return head;
        }

        pointer1.next = nthNode.next;
        return head;
    }
}
