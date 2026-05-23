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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathHelper(root, targetSum, 0);
    }

    public boolean hasPathHelper(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                return true;
            }
            else {
                return false;
            }
        }

        if (hasPathHelper(root.left, targetSum, sum)) {
            return true;
        }
        if (hasPathHelper(root.right, targetSum, sum)) {
            return true;
        }
        return false;
    }

    
}