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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        // Find Node.
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            // Found the root node.

            // Case 1: deleted node has 0 or 1 child.
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // Case 2: deleted node has 2 children
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;

                root.right = deleteNode(root.right, minNode.val);

            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return root;
        }

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}