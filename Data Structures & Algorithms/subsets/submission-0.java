class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sa  = new ArrayList<>();
        
        genSubsets(nums, 0, sa, ans);
        return ans;
    }

    private void genSubsets(int[] nums, int idx, List<Integer> sa, List<List<Integer>> ans) {
        if(idx < 0) {
            return;
        }

        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(sa));
            return;
        }

        sa.add(nums[idx]);
        genSubsets(nums, idx + 1, sa, ans);

        sa.remove(sa.size() - 1);
        genSubsets(nums, idx + 1, sa, ans);
    }
}
