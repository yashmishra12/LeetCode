class Solution {
    public int countQuadruplets(int[] nums) {
        
    int count = 0, n = nums.length;
        
    for (int i = 0; i < n - 3; i++) {
        for (int j = i + 1; j < n - 2; j++) {
            for (int k = j + 1; k < n - 1; k++) {
                for (int l = k + 1; l < n; l++) {
                    if (nums[i] + nums[j] + nums[k] == nums[l] ) { count++; }
                }
            }
        }
    }
    return count;
        
    }
}