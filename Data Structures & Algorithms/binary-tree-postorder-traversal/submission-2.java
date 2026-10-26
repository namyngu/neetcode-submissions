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

// Iterative method
class Solution {
    Stack<TreeNode> stack;
    Stack<Boolean> visit;
    List<Integer> res;
    
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        stack = new Stack<>();
        visit = new Stack<>();

        stack.push(root);
        visit.push(false);
        TreeNode cur = new TreeNode();
        while (!stack.isEmpty()) {
            cur = stack.pop();
            boolean isVisited = visit.pop();
            if (cur == null) {
                continue;
            }
            if (!isVisited) {
                stack.push(cur);
                visit.push(true);
                stack.push(cur.right);
                visit.push(false);
                stack.push(cur.left);
                visit.push(false);
            }
            else {
                res.add(cur.val);
            }
        }
        return res;
    }
}