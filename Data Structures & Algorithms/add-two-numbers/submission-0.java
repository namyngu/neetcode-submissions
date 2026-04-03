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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode lsum = head;

        int remainder = 0;

        int sum = l1.val + l2.val + remainder;
        lsum.val = sum % 10;

        remainder = (int)Math.floor(sum / 10.0);
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null && l2 != null) {
            lsum.next = new ListNode(0);
            lsum = lsum.next;

            sum = l1.val + l2.val + remainder;
            lsum.val = sum % 10;

            // new remainder
            remainder = (int) Math.floor(sum / 10.0);

            // Increment
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                lsum.next = new ListNode(0);
                lsum = lsum.next;

                sum = l2.val + remainder;
                lsum.val = sum % 10;

                // new remainder
                remainder = (int) Math.floor(sum / 10.0);

                l2 = l2.next;
            }
        } else if (l2 == null) {
            while (l1 != null) {
                lsum.next = new ListNode(0);
                lsum = lsum.next;

                sum = l1.val + remainder;
                lsum.val = sum % 10;

                // new remainder
                remainder = (int) Math.floor(sum / 10.0);

                l1 = l1.next;
            }
        }

        if (remainder > 0) {
            lsum.next = new ListNode(remainder);
        }

        return head;
    }
}
