/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Edge case
        if (head == null) return null;

        Map<Node, Integer> map1 = new HashMap<>();
        Map<Integer, Node> map2 = new HashMap<>();
        Node headCopy = new Node(head.val);
        Node list1 = head;
        Node list2 = headCopy;


        int index = 0;
        // First pass
        while (list1 != null) {
            map1.put(list1, index);
            map2.put(index, list2);

            // Increment
            if (list1.next == null) {
                break;
            }
            list2.next = new Node(list1.next.val);
            list1 = list1.next;
            list2 = list2.next;
            index++;
        }

        // Second pass
        list1 = head;
        list2 = headCopy;
        while (list1 != null) {
            if (list1.random == null) {
                list2.random = null;

                list1 = list1.next;
                list2 = list2.next;
                continue;
            }

            int indexOfRandom = map1.get(list1.random);

            list2.random = map2.get(indexOfRandom);

            // Increment
            list1 = list1.next;
            list2 = list2.next;
        }

        return headCopy;
    }
}
