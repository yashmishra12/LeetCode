class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int lo = 0, hi = nums.length - 1;
        
        if(hi==0) { return nums[hi]; } //nums.length == 1
        if (nums[0] != nums[1]) { return nums[0]; } //first elem. is unique
        if (nums[hi] != nums[hi-1]) { return nums[hi]; } //last elem. is unique
        
        
        while(lo <= hi) {    
            int mid = (lo+hi)/2;
            if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) { return nums[mid]; }
            
            boolean cond1 = (mid%2)==0 && nums[mid]==nums[mid+1]; // mid even pe and pair ends at odd. right mai dekh
            boolean cond2 = (mid%2)==1 && nums[mid]==nums[mid-1]; //mid odd pe hai and pair ends here. right mai dekh
            
            if( cond1 || cond2) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
            
        }
        
        return -1;
    }
}