class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       List<Integer>[] bucket = new List[nums.length+1];
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) 
            {hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);}
        
        for(Map.Entry<Integer,Integer> e: hm.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            
            if(bucket[value]==null) {bucket[value] = new ArrayList<>();}
            
            bucket[value].add(key);
        }
        
        int res[] = new int[k];
        int count = 0;
        
        for(int i=bucket.length-1; i>=0; i--) {
            if(bucket[i] != null) {
                for(int j=0; j<bucket[i].size(); j++) {
                    res[count++] = bucket[i].get(j);
                }
            }
            
            if(count==k) {return res;}
        }
        
        return res;
        
        
        
    }
}

