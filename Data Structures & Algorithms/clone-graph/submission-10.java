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
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> oldToNew = new HashMap<>();

        queue.addLast(node);
        visited.add(node);

        // using bfs
        while (!queue.isEmpty()) {
            int qLength = queue.size();
            for (int i = 0; i < qLength; i++) {
                Node currNode = queue.removeFirst();

                Node copyNode;
                if (!oldToNew.containsKey(currNode)) {
                    copyNode = new Node(currNode.val);
                    oldToNew.put(currNode, copyNode);
                }
                else {
                    copyNode = oldToNew.get(currNode);
                }

                // add neighbors to copyNode
                for (Node neighbor : currNode.neighbors) {
                    if (oldToNew.containsKey(neighbor)) {
                        copyNode.neighbors.add(oldToNew.get(neighbor));
                    }
                    else {
                        Node copyNeighbor = new Node(neighbor.val);
                        oldToNew.put(neighbor, copyNeighbor);
                        copyNode.neighbors.add(copyNeighbor);
                    }

                    if (!visited.contains(neighbor)) {
                        queue.addLast(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            
        }
        return oldToNew.get(node);
    }
}