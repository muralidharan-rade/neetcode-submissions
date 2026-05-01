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
    int ans = -1; 

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);

        return ans;
    }

    private int diameter(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int lh = diameter(root.left);
        int rh = diameter(root.right);

        ans = Math.max(ans, lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }
}
