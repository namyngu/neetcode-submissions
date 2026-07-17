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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null & subRoot == null) {
                return true;
            }
            return false;
        }

        if(checkTree(root, subRoot)) {
            return true;
        }
        if (isSubtree(root.left, subRoot)) {
            return true;
        }
        return isSubtree(root.right, subRoot);
    }

    public boolean checkTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            if (root == null & subRoot == null) {
                return true;
            }
            return false;
        }
        

        if (root.val != subRoot.val) {
            return false;
        }
        if (!checkTree(root.left, subRoot.left)) {
            return false;
        }
        if (!checkTree(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }
}
