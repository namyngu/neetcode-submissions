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

    public void mergeSort(int[] arr, int l, int r) {
        if (r - l + 1 == 1) {
            return;
        }

        
        mergeSort(arr, l, r / 2);     // Sort left side
        mergeSort(arr, (int) Math.ceil(r / 2.0), r);      // sort right side
        merge(arr, l, r / 2, r);      // merge two halves                                            // merge
    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] leftArr = new int[m - l + 1];
        int[] rightArr = new int[r - m];

        for (int i = l; i <= m; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = m + 1; i <= r; i++) {
            rightArr[i] = arr[i];
        }

        int leftPtr = l;
        int rightPtr = m + 1;
        for (int i = l; i <= r; i++) {

            if (leftPtr > m) {
                arr[i] = rightArr[rightPtr];
            }
            else if (rightPtr > r) {
                arr[i] = leftArr[leftPtr];
            }
            else {
                if (leftArr[leftPtr] <= rightArr[rightPtr]) {
                    arr[i] = leftArr[leftPtr];
                    leftPtr++;
                } 
                else {
                    arr[i] = rightArr[rightPtr];
                    rightPtr++;
                }
            }
        }
        
        
    }
}
