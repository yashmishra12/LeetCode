class Solution {
    public int search(int[] nums, int target) {
        int lo=0, hi=nums.length-1;
        while(lo<=hi) {
            int mid = (lo+hi)/2;
            if(nums[mid]==target) return mid;
            
            else if (nums[lo]<=nums[mid]){ // this part of array is sorted. Hence we can apply Binary Search 
                if(target>=nums[lo] && target<nums[mid]) {hi = mid-1;}
                else {lo=mid+1;} // target not present in this part of sorted array. 
                
            } else if(nums[mid]<=nums[hi]){ // this part of array is sorted. Hence we can apply Binary Search
                if(target>nums[mid] && target<=nums[hi]) {lo = mid+1;}
                else {hi = mid-1;} // target not present in this part of sorted array. 
                
            }
        }
        return -1;
    }
}