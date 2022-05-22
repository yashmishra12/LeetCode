class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        
        for(int a: nums) {
            hm.put(a, false);    
        }
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length;i++){
            int curNum = nums[i];
            if(hm.get(curNum)) continue;
            
            int curLength=1;
            
            int left=curNum-1;
            while(hm.containsKey(left)) {
                if(hm.get(left)) break;
                hm.put(left, true);
                
                left--;
                curLength++;
            }
            
            int right=curNum+1;
            while(hm.containsKey(right)) {
                if(hm.get(right)) break;
                hm.put(right, true);
                
                right++;
                curLength++;
            }
            
            res = Math.max(res, curLength);
        }
        
        return res;
        
    }
}