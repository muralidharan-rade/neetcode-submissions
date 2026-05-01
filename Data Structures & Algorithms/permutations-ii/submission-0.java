class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    Set<String> uniq = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> sa = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        permutate(nums, sa, visited, 0, "", uniq);

        return result;
    }

    private void permutate(int[] nums, List<Integer> sa, HashSet<Integer> visited, int idx, String str, Set<String> uniq) {
        if(idx == nums.length) {
            if(uniq.contains(str)) {
                return;
            }
            result.add(new ArrayList<>(sa));
            uniq.add(str);
            return;
        }
        
        for(int i=0; i<nums.length; i++) {
            if(!visited.contains(i)) {
                sa.add(nums[i]);
                visited.add(i);
                permutate(nums, sa, visited, idx+1, str+nums[i], uniq);
                sa.remove(sa.size()-1);
                visited.remove(i);
            }
        }
    }
}