class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left=0;
        int right= 0;
        int numZero = 0;
        
        while(right<nums.length) {
            if(nums[right]==0){
                numZero++;
            }
            
            while(numZero==2){
                if(nums[left]==0){
                    numZero--;
                }
                left++;
            }
            
            max=Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}