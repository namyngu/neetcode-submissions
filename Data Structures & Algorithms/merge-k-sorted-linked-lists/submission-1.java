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
        if (lists.length == 0) {
            return null;
        }

        List<Integer> sortedArray = new ArrayList<>();

        // add all nodes in an array
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while (node != null) {
                sortedArray.add(node.val);
                node = node.next;
            }
        }

        // Edge case - no nodes
        if (sortedArray.size() == 0) {
            return null;
        }

        // sort the array
        Collections.sort(sortedArray, (a,b) -> a - b);
        
        // convert back to linked list and return it.
        ListNode head = new ListNode(sortedArray.get(0));
        ListNode node = head;
        for (int i = 1; i < sortedArray.size(); i++) {
            node.next = new ListNode(sortedArray.get(i));
            node = node.next;
        }
        
        return head;
    }
}
