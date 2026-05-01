class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;

        if(n == 0) {
            return result;
        }

        if(n == 1) {
            result[1] = 1;
            return result;
        }

        for(int i=1; i<=n; i++) {
            int ones = 0;

            for(int j=0; j<32; j++) {
                if(checkBit(i, j)) {
                    ones++;
                }
            }

            result[i] = ones;
        }

        return result;        
    }

    private boolean checkBit(int n, int pos) {
        int val = n & (1 << pos);
        if(val > 0) {
            return true;
        }

        return false;
    }
}
