class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        ArrayList<Integer> res = new ArrayList<>();
        int n = nums.length;
       
        int[] nonInc = new int[n];
        int[] nonDec = new int[n];
        Arrays.fill(nonInc, 1);
        Arrays.fill(nonDec, 1);
        
        
        for(int i =n-2; i>=0; i--) {
            if(nums[i] <= nums[i+1]) {
                nonDec[i] = 1+nonDec[i+1];
            }
        }
        
         for(int i=1; i<n; i++) {
            if(nums[i] <= nums[i-1]) {
                nonInc[i] = 1+nonInc[i-1];
            }
        }
        
        for(int i=k; i<n-k; i++) {
            if(nonInc[i-1] >= k && nonDec[i+1]>=k) {
                res.add(i);
            }
        }
        
        
        return res;
    }
}