class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        
        int leftSum=0;
        for(int i=0; i<nums.length;i++) {
            int rightSum = totalSum - (leftSum+nums[i]);
            if(leftSum==rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}