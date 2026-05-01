class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;

        int[] pre = new int[n];
        pre[0] = 0;
        int preMax = height[0]; 

        for(int i=1; i<n; i++) {
            pre[i] = height[i] < preMax ? preMax : 0;
            preMax = Math.max(height[i], preMax);
        }

        int[] suf = new int[n];
        suf[n-1] = 0;
        int sufMax = height[n-1];

        for(int i=n-2; i>=0; i--) {
            suf[i] = height[i] < sufMax ? sufMax : 0;
            sufMax = Math.max(height[i], sufMax);
        }

        for(int i=0; i<n; i++) {
            int val = Math.min(pre[i], suf[i]) - height[i];
            ans += val > 0 ? val : 0;
        }

        return ans;
        
    }
}
