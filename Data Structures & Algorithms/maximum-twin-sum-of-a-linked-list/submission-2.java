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

 /* Optimal solution
    Key Insight: Modify the linked list so that we reverse the ptr at the midpoint so that we can travel back.
    We reverse the pointers on the first half of the nodes as it is easier to code up.
    Find midpoint using fast and slow ptrs.
    
    Time: O(n)
    Space: O(1)
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow;
            slow = slow.next;
            tmp.next = prev;
            prev = tmp;
        }

        head.next = null;

        int res = 0;
        while (slow != null) {
            res = Math.max(res, prev.val + slow.val);
            prev = prev.next;
            slow = slow.next;
        }
        return res;
    }
}