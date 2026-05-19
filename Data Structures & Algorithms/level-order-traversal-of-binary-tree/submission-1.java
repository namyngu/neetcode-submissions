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
    List<List<Integer>> res = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }

        q.addLast(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int lvlLength = q.size();
            for (int i = 0; i < lvlLength; i++) {
                TreeNode curr = q.removeFirst();
                level.add(curr.val);

                if (curr.left != null) {
                    q.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
