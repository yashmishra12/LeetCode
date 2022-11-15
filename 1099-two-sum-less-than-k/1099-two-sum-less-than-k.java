class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        
        int maxSum = -1;
        
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum<k){
                maxSum = Math.max(maxSum,sum);
                i++;
            }
            else {
                j--;
            }
        }
        
        return maxSum;
    }
}