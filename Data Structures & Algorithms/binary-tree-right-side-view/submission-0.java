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
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> q = new ArrayDeque<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }

        q.addFirst(root);
        while (!q.isEmpty()) {
            int lvlLength = q.size();
            for (int i = 0; i < lvlLength; i++) {
                TreeNode curr = q.removeFirst();

                if (i == 0) {
                    res.add(curr.val);
                }
                

                if (curr.right != null) {
                    q.addLast(curr.right);
                }
                if (curr.left != null) {
                    q.addLast(curr.left);
                }
            }
        }

        return res;
    }
}
