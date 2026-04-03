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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge case
        if (k == 1) {
            return head;
        }

        ListNode currNode = head;

        // store all nodes in arraylist
        List<ListNode> linkedList = new ArrayList<>();
        while (currNode != null) {
            linkedList.add(currNode);
            currNode = currNode.next;
        }

        // Reverse k nodes in another list
        List<ListNode> reverseKGroup = new ArrayList<>();

        for (int i = 0; i < linkedList.size() - (linkedList.size() % k); i += k) {
            for (int j = k - 1; j >= 0; j--) {
                reverseKGroup.add(linkedList.get(i + j));
            }
        }

        for (int i = linkedList.size() - (linkedList.size() % k); i < linkedList.size(); i++) {
            reverseKGroup.add(linkedList.get(i));
        }

        // Convert arraylist back to linked list.
        int index = 0;
        for (ListNode node : reverseKGroup) {
            if (index + 1 < reverseKGroup.size()) {
                node.next = reverseKGroup.get(index + 1);
            }
            else if (index + 1 == reverseKGroup.size()) {
                node.next = null;
            }

            index++;
        }

        return reverseKGroup.get(0);
    }
}
