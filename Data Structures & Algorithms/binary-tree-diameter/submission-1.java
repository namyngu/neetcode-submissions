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

// Go to each node and find the height of the left and right subtree.
// Add the height of the left and right subtree and that is your diameter.
class Solution {
    int diaMax = 0;
    Map<TreeNode, Integer> cache;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cache = new HashMap<>();
        inorder(root);
        return diaMax;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        int h1 = findHeight(root.left);
        int h2 = findHeight(root.right);
        int dia = h1 + h2;
        diaMax = Math.max(diaMax, dia);
        inorder(root.right);
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int hLeft = findHeight(root.left);
        int hRight = findHeight(root.right);
        cache.put(root, 1 + Math.max(hLeft, hRight));
        return cache.get(root);
    }
}
