class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int furthestReachSoFar = 0;
        for (int i=0; i<n; i++) {
            if(i>furthestReachSoFar || furthestReachSoFar>=n-1) break;
            furthestReachSoFar = Math.max(furthestReachSoFar, i+nums[i]);
        }
        
        return furthestReachSoFar >=n-1;
        
    }
}