class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;

        int curXor = 0;
        for(int a: nums) {
            curXor ^= a;
        }
        
        int numXor = 0;
        
        for(int i=0; i<=len; i++) {
            numXor ^=  i;
        }
        
        return (numXor ^ curXor);
        
    }
}