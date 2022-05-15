class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> res = new ArrayList<>();
        int prev = lower-1, curr = 0;
        
        for(int i=0; i<=nums.length; i++) {
            if(i==nums.length) curr = upper+1;
            else curr = nums[i];
            
            
            
            if (prev+1 <= curr-1) {
                res.add(printRes(prev+1, curr-1));
            }
            prev = curr;
        }
        
        return res;
    }
    
    public static String printRes(int l, int h) {
        if (l==h) return String.valueOf(h);
        
        return l+"->"+h;
    }
}