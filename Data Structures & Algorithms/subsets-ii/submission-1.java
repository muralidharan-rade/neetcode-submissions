class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sa = new ArrayList<>();

        Arrays.sort(nums);
        subset(nums, 0, sa, ans);

        return ans;
    }

    private void subset(int[] nums, int idx, List<Integer> sa, List<List<Integer>> ans) {
        if(idx == nums.length) {
            List<Integer> ad = new ArrayList<>(sa);
            ans.add(ad);
            return;
        }

        sa.add(nums[idx]);
        subset(nums, idx + 1, sa, ans);
        sa.remove(sa.size() - 1);

        while((idx < nums.length - 1) && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        
        subset(nums, idx + 1, sa, ans);
    }
}
