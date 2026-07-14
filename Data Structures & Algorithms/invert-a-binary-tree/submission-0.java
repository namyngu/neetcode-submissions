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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addFirst(root);

        while (!q.isEmpty()) {
            int qLength = q.size();
            for (int i = 0; i < qLength; i++) {
                TreeNode node = q.removeFirst();
                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }

                // swap nodes
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = tmp;

            }
        }
        return root;
    }
}
