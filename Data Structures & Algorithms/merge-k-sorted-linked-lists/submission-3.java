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

// Brute force solution
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
         // Edge case
        if (lists.length == 0 || lists == null) {
            return null;

            
        }
        
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }

        if (l == r) {
            return lists[l];
        }

        int mid = l + (r - l) / 2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid + 1, r);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next; 
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}
