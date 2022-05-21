class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        if(k%n==0) return;
        k = k%n;
        
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    
    public static void reverse(int[] nums, int a, int b) {
        while(a<b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            
            a++;
            b--;
        }
    }
}
