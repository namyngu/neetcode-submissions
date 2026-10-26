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
    List<Integer> res;
    Stack<TreeNode> stack;
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode cur = root;
        res = new ArrayList<>();
        stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                res.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
            }
        }
        return res;
    }
}