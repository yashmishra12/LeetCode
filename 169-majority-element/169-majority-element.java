class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int curMax = Integer.MIN_VALUE;
        int res = -1;
        
        for(int a: nums) {
            int freq = map.getOrDefault(a, 0)+1;
            map.put(a, freq);
            
            if(curMax<freq){
                curMax = freq;
                res = a;
            }
        }
        
        return res;
        
    }
}