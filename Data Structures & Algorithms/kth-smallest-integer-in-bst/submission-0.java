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
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, new int[]{k, -1})[1];

    }

    // [k, kth]
    private int[] inorder(TreeNode root, int[] res) {
        if (root == null) {
            return res;
        }

        res = inorder(root.left, res);

        if (res[0] == 0) {
            return res;
        }
        res[0]--;
        if (res[0] == 0) {
            return new int[]{res[0], root.val};
        }

        return inorder(root.right, res);
    }
}
