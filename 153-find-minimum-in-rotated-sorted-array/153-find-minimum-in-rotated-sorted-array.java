class Solution {
    public int findMin(int[] nums) {
        
        int lo = 0;
        int hi = nums.length-1;
        
        if(nums[lo]<=nums[hi]) { //arr is not rotated
            return nums[0];
        }        
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            else if(nums[mid]<nums[mid-1]) return nums[mid];
            
            else if(nums[lo] <= nums[mid]) {lo = mid+1;} //this is sorted, go to unsorted part
            else if(nums[mid] <= nums[hi]) {hi = mid-1;} //this is sorted, go to unsorted part
        }
        
        return -1;
        
    }
}