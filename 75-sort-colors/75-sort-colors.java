class Solution {
    public void sortColors(int[] nums) {
        int st = 0, mid = 0, end = nums.length-1;
        
        while(mid<=end) {   
        
            if (nums[mid]==0) swap(nums, st++, mid++);
            else if (nums[mid]==1) mid++;
            else if (nums[mid]==2) swap(nums, end--, mid);
        }
        
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}