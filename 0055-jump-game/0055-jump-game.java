class Solution {
    public boolean canJump(int[] nums) {
        int curMaxReach = 0;
        for(int i=0; i<nums.length; i++) {
            int n = nums[i];
            int curReach = n+i;
            
            curMaxReach = Math.max(curMaxReach, curReach);
            
            if(i>=curMaxReach && i!=nums.length-1){
                return false;
            }
            if(curMaxReach>=nums.length-1){
                return true;
            }
           
        }
        return false;
    }
}