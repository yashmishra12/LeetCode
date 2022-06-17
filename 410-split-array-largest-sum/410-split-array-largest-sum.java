class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        
        for(int n: nums) {
            max = Math.max(n, max);
            sum += n;
        }
        
        if (m==nums.length) {
            return max;
        }
        
        int lo = max, hi = sum, ans = 0;
        
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            
            if (isPossible(nums, mid, m)) {
                ans = mid;
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
             
        }
        
        return ans;
    }
    
    public static boolean isPossible(int[] wt, int mid, int days) {
        int d = 1;
        int sum = 0;
        
        for(int i=0; i<wt.length; i++) {
            sum += wt[i];
            if(sum>mid) {
                d++;
                sum = wt[i];
            }
            if(d>days){return false;}
        }
        return true;
    }
}