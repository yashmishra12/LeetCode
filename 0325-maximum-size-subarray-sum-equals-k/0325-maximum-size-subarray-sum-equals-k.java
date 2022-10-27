class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int curSum = 0;
        int max = 0;
        
        
        for(int i = 0; i<nums.length; i++) {
            curSum += nums[i];
            int diff = curSum-k;
            if(hm.containsKey(diff)) {
                max = Math.max(i-hm.get(diff), max);
            }
            if(curSum==k){
                max = Math.max(max, i+1);
            }
            if(!hm.containsKey(curSum)){
                hm.put(curSum, i);
            }
        }
        
        return max;
    }
}