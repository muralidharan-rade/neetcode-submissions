class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        
        for(int i=0; i<32; i++) {
            if(checkSetBit(n, i)) {
                ones++;
            }
        }

        return ones;
    }

    private boolean checkSetBit(int n, int pos) {
        int val = n & (1 << pos);
        if(val > 0) {
            return true;
        }
        return false;
    }
}
