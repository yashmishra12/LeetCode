class Solution {
    public int findPairs(int[] nums, int k) {
        int res=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int n: nums) {
            hm.put(n, hm.getOrDefault(n,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(k!=0 && hm.containsKey(k+key)) {
                res++;
            } else if (k==0 && val>1) {
                res++;
            }
        }
        
        return res;
    }
}