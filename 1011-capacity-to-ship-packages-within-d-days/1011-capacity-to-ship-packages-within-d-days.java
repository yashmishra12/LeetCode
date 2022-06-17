class Solution {
    public int shipWithinDays(int[] wt, int days) {
        
        int max = 0, sum = 0;
        
        for(int val: wt) {
            sum += val;
            max = Math.max(max, val);
        }
        
        if(wt.length == days) { return max;}
        
        int lo = max, hi = sum, ans = 0;
        
        while (lo<=hi) {
            int mid = (hi+lo)/2;
            
            if(isPossible(wt, mid, days)) {
                ans = mid;
                hi = mid-1;
            } 
            else { lo = mid+1; }
        }
        
        return ans;
    }
    
    public static boolean isPossible (int[] wt, int mid, int days) {
        int d = 1;
        int sum = 0;
        
        for(int i=0; i<wt.length; i++) {
            sum += wt[i];
            
            if(sum>mid) {
                d++;
                sum = wt[i]; //reset sum to take this parcel on next day (d++)
            }
            
            if(d>days) {return false;}
        }
        
        return true;
    }
}