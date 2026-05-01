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
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        balance(root);
        
        return isBalance;
    }

    private int balance(TreeNode root) {
        if(root == null) {
            return -1;
        }

        int lh = balance(root.left);
        int rh = balance(root.right);

        if(Math.abs(lh - rh) > 1) {
            isBalance = false;
        }

        return Math.max(lh, rh) + 1;
    }
}
