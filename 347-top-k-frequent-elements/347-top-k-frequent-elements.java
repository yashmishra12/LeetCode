class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int a: nums) {
            hm.put(a, hm.getOrDefault(a,0)+1);
        }
        
        int[] res = new int[k];
        int i=0;
        int[] kvPair = new int[2];
        
        while(k>0) {
            for(Map.Entry<Integer,Integer> a: hm.entrySet()) {
                int key = a.getKey();
                int freq = hm.get(key);
                
                if(freq>kvPair[1]) {
                    kvPair[0] = key;
                    kvPair[1] = freq;   
                }
            }
            
            res[i++] = kvPair[0];
            hm.remove(kvPair[0]);
            Arrays.fill(kvPair, 0);
            k--;
        }
        
       return res; 
    }
}