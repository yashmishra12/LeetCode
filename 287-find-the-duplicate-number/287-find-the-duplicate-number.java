class Solution {
    public int findDuplicate(int[] nums) {
        
        for (int i=0; i<nums.length; i++) {
            int jump = Math.abs(nums[i])-1;
            if(nums[jump]<0) {
                return Math.abs(nums[i]);
            }else {
                nums[jump] *= -1;
            }
        }
        
        return -1;
        
    }
}