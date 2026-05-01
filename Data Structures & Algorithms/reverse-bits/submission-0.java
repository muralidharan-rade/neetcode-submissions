class Solution {
    public int reverseBits(int n) {
        int res = 0;
        
        for(int i=0; i<32; i++) {
            if(rightBit(n, i)) {
                res |= (1 <<(31-i));
            }
        }

        return res;
    }

    private boolean rightBit(int n, int pos) {
        int val = (n >> pos) & 1;
        if(val > 0) {
            return true;
        }

        return false;
    }
}
