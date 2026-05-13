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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();    // [val, index]

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorder, 0, 0, preorder.length - 1, map);
    }

    // curr is the current index of preorder array.
    // l and r are the left and right boundary of inorder array.
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int curr, int l, int r, Map<Integer, Integer> map) {
        if (l > r || l < 0 || r > inorder.length - 1 || curr > preorder.length - 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[curr]);
        int mid = map.get(preorder[curr]);
        curr++;

        // Build left subtree (if it exists)
        int leftNodes = mid - l;
        if (leftNodes >= 1) {
            // left subtree exists
            root.left = buildTreeHelper(preorder, inorder, curr, l, mid - 1, map);
        }

        // build right subtree
        root.right = buildTreeHelper(preorder, inorder, curr + leftNodes, mid + 1, r, map);
        

        return root;
    }
}
