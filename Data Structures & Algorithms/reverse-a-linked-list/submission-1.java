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
    public ListNode reverseList(ListNode head) {
        // Edge Cases
        if (head == null) {
            return null;
        } 
        else if (head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode nxt;
        prev.next = null;

        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
