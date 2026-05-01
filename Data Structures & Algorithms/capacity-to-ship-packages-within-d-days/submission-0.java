class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s = getMaxWeight(weights);
        int e = getTotalWeight(weights);

        int ans = Integer.MAX_VALUE;

        while(s <= e) {
            int mid = s + (e - s) / 2;
            boolean isPossible = distribute(weights, days, mid);

            if (isPossible) {
                ans = Math.min(mid, ans);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return ans;        
    }

    private boolean distribute(int[] weights, int days, int maxWeight) {
        int daysNeeded = 1;
        int balanceWeight = maxWeight;

        for (int i = 0; i<weights.length; i++) {
            if(weights[i] > maxWeight) {
                return false;
            }

            balanceWeight -= weights[i];
            if(balanceWeight < 0) {
                daysNeeded++;
                balanceWeight = maxWeight - weights[i];
            }
        }

        if(daysNeeded <= days) {
            return true;
        }

        return false;
    }

    private int getMaxWeight(int[] weights) {
        int max = 0;
        for(int w : weights) {
            max = Math.max(max, w);
        }

        return max;
    }

    private int getTotalWeight(int[] weights) {
        int sum = 0;
        for(int w : weights) {
            sum += w;
        }

        return sum;
    }
}