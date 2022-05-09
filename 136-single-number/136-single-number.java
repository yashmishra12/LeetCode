class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int a: nums) {
            res ^= a;
        }
        
        return res;
    }
}