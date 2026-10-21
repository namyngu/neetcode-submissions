class SegmentTree {
    Node root;

    public SegmentTree(int[] nums) {
        // Build segment tree
        int sum = 0;
        int L = 0;
        int R = nums.length - 1;
        root = buildTree(nums, L, R);
    }

    Node buildTree(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return new Node(nums[L], L, R);
        }
        int M = (R + L) / 2;
        
        Node nodeL = buildTree(nums, L, M);
        Node nodeR = buildTree(nums, M + 1, R);
        Node node = new Node(nodeL.sum + nodeR.sum, L, R);
        node.nodeL = nodeL;
        node.nodeR = nodeR;
        return node;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public void updateHelper(Node root, int index, int val) {
        int M = (root.R + root.L) / 2;
        if (index < M) {
            updateHelper(root.nodeL, index, val);
        }
        else if (index > M) {
            updateHelper(root.nodeR, index, val);
        }
        else {
            if (root.L == root.R) {
                root.sum = val;
                return;
            }
            updateHelper(root.nodeL, index, val);
        }
        root.sum = root.nodeL.sum + root.nodeR.sum;
    }

    public int query(int L, int R) {
        return queryHelper(root, L, R);
    }

    public int queryHelper(Node root, int L, int R) {
        if (L == root.L && R == root.R) {
            return root.sum;
        }

        int M = (root.R + root.L) / 2;
        if (L > M) {
            return queryHelper(root.nodeR, L, R);
        }
        else if (R <= M) {
            return queryHelper(root.nodeL, L, R);
        }
        
        return queryHelper(root.nodeL, L, M) + queryHelper(root.nodeR, M + 1, R);
    }
}

class Node {
    int sum;
    int L;
    int R;
    Node nodeL;
    Node nodeR;

    public Node(int sum, int L, int R) {
        this.sum = sum;
        this.L = L;
        this.R = R;
    }
}
