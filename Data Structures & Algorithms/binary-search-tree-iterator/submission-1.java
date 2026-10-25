/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode curr = null;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // Go to the beginning of BST
        stack = new Stack<>();
        curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        // return the value of current pointer and increment it.
        curr = stack.pop();
        int val = curr.val;

        if (curr.right != null) {
            // go to the right subtree then to the bottom left.
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return val;
    }
    
    public boolean hasNext() {
        if (!stack.empty()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */