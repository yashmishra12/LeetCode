class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        
        hm.put(0, 1);
        
        int diff = 0;
        int count=0; 
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            diff = sum - k;
            if(hm.containsKey(diff)) {count += hm.get(diff);}
            
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        
        return count;
        
    }
}