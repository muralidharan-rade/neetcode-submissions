class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sa = new ArrayList<>();
        Arrays.sort(nums);
        generateCombi(nums, target, sa, target, 0);

        return result;        
    }

    private void generateCombi(int[] nums, int target, List<Integer> sa, int sum, int idx) {
        if (sum < 0 || idx >= nums.length) {
            return ;
        }

        if (sum == 0) {
            result.add(new ArrayList<>(sa));
            return;
        }

        if(nums[idx] <= sum) {
            sa.add(nums[idx]);
            generateCombi(nums, target, sa, sum-nums[idx], idx);
            
            sa.remove(sa.size() - 1);
        }

        generateCombi(nums, target, sa, sum, idx+1);
        
    }
}
