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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.right == null) {
            int h = findHeight(root.left, 0);
            return h > 1 ? false : true;
        }
        else if (root.left == null) {
            int h = findHeight(root.right, 0);
            return h > 1 ? false : true;
        }
        else {
            if (isBalanced(root.left) && isBalanced(root.right)) {
                int h1 = findHeight(root.left, 0);
                int h2 = findHeight(root.right, 0);
                int h0 = Math.abs(h2 - h1);
                return h0 > 1 ? false : true;
            }
            else {
                return false;
            }
        }
    }

    private int findHeight(TreeNode root, int h) {
        if (root == null) {
            return h;
        }

        h++;
        return Math.max(findHeight(root.left, h), findHeight(root.right, h));
    }
}
