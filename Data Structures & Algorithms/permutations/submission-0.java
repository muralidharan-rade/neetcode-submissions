class Solution {
    
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> sa = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        generatePermutations(nums, 0, sa, visited);

        return result;        
    }

    private void generatePermutations(int[] nums, int idx, List<Integer> sa, HashSet<Integer> visited) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(sa));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            int j = nums[i];
            if(!visited.contains(j)) {
                visited.add(j);
                sa.add(j);
                generatePermutations(nums, idx+1, sa, visited);
                sa.remove(sa.size()-1);
                visited.remove(j);
            }
        }

    }
}
