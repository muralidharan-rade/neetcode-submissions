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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Queue<TreeNode> levels = new LinkedList<>();
        levels.add(root);

        while(!levels.isEmpty()) {
            int levelSize = levels.size();
            List<Integer> sa = new ArrayList<>();

            while(levelSize > 0) {
                TreeNode curr = levels.poll();
                sa.add(curr.val);

                if (curr.left != null) {
                    levels.add(curr.left);
                }

                if (curr.right != null) {
                    levels.add(curr.right);
                }

                levelSize--;
            }
            
            ans.add(sa);
        }

        return ans;
    }
}
