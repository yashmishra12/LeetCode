class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,0);
        int sum = 0;
        
        for(int i=0; i<nums.length;i++) {
            sum += nums[i];
            if(sum%k==0 && i>0) {return true;}
            if(!hm.containsKey(sum%k)) {
                hm.put(sum%k, i);
            }
            else {
                int pastIndex = hm.get(sum%k);
                int curIndex = i;
                int diff = curIndex - pastIndex;
                if(diff>=2) {
                    return true;
                }
            }
        }
        
        return false;
    }
}