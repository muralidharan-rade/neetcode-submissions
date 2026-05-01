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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p.val, q.val);
    }

    private TreeNode lca(TreeNode root, int m, int n) {
        if (root == null) {
            return root;
        }

        if(root.val == m || root.val == n) {
            return root;
        }

        TreeNode l = lca(root.left, m, n);
        TreeNode r = lca(root.right, m, n);

        if(l != null && r != null) {
            return root;
        }

        if(l != null) {
            return l;
        }

        return r;
    }
}
