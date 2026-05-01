class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int v : nums) {
            if(map.containsKey(v)) {
                return true;
            } else {
                map.put(v, 1);
            }
        }

        return false;
    }
}