class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCount=0;
        int zeroPosition = -1;
        int product=1;
        
        for(int i=0;i<nums.length; i++) {
            int a = nums[i];
            if(a==0) {
                zeroCount++;
                zeroPosition = i;
            }
            else product *= a;
        }
        
        int[] res = new int[nums.length];
        
        if(zeroCount>1) {
            Arrays.fill(res, 0);
        } 
        else if(zeroCount==1) {
            Arrays.fill(res, 0);
            res[zeroPosition] = product;
        } 
        else {
            for(int i=0; i<nums.length; i++) {
                res[i] = product / nums[i];
            }
        }
        
        return res;
        
    }
}