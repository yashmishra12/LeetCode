class Solution {
    public int numRabbits(int[] answers) {
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int a: answers) {
            hm.put(a, hm.getOrDefault(a, 0)+1);
        }
        
        int res = 0;
        
        for(Map.Entry<Integer, Integer> e: hm.entrySet()) {
            int groupSize = e.getKey()+1;
            int freq = e.getValue();
            
            int numOfGroups = (int)Math.ceil((double)freq/groupSize);
            int rabbitsInCurrGroup = numOfGroups * groupSize;
            
            res += rabbitsInCurrGroup;
        }
        return res;
        
    }
}