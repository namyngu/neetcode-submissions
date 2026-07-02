/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        Map<Node, Node> oldToNew = new HashMap<>();

        oldToNew.put(node, new Node(node.val));
        queue.addLast(node);

        // using bfs
        while (!queue.isEmpty()) {
            int qLength = queue.size();
            for (int i = 0; i < qLength; i++) {
                Node currNode = queue.removeFirst();
                Node copyNode = oldToNew.get(currNode);
            
                // add neighbors to copyNode
                for (Node neighbor : currNode.neighbors) {
                    if (oldToNew.containsKey(neighbor)) {
                        copyNode.neighbors.add(oldToNew.get(neighbor));
                    }
                    else {
                        Node copyNeighbor = new Node(neighbor.val);
                        oldToNew.put(neighbor, copyNeighbor);
                        copyNode.neighbors.add(copyNeighbor);
                        queue.addLast(neighbor);
                    }
                }
            }
        }
        return oldToNew.get(node);
    }
}