class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int min = getMin(piles);
        int max = getMax(piles);        

        long s = 1;
        long e = max;

        int ans = Integer.MAX_VALUE;

        while(s <= e) {
            long mid = s + (e - s) / 2;

            boolean isDone = isEatPossible(piles, mid, h);
            if(isDone) {
                ans = Math.min(ans, (int) mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            
        }

        return ans;
    }

    private boolean isEatPossible(int[] piles, long banana, int h) {
        int actualHours = 0;

        for (int i=0; i<piles.length; i++) {
            if (piles[i] < banana) {
                actualHours++;
            } else {
                long q = piles[i] / banana;
                long r = piles[i] % banana;
                actualHours += q;
                if(r > 0) {
                    actualHours += 1;
                }
            }
        }

        if(actualHours > h) {
            return false;
        }

        return true;
    }

    private int getMin(int[] piles) {
        int min = Integer.MAX_VALUE;
        for(int i : piles) {
            min = Math.min(min, i);
        }

        return min;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i : piles) {
            max = Math.max(max, i);
        }

        return max;
    }
}
