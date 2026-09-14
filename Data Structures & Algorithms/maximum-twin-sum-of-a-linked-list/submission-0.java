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

 /* Simply copy the linked list into an array then use two pointers to add up the twin sum.
    Not optimal in terms of space.
    Time: O(n)
    Space: O(n)
 */
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode ptr = head;
        while (ptr != null) {
            arr.add(ptr.val);
            ptr = ptr.next;
        }
        int res = 0;
        int L = 0;
        int R = arr.size() - 1;
        while (L < R) {
            res = Math.max(res, arr.get(L) + arr.get(R));
            L++;
            R--;
        }
        return res;
    }
}