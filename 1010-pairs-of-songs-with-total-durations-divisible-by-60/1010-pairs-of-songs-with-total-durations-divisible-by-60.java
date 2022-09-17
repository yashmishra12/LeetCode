class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int t: time) {
            int newTime = t%60;
            
            if(newTime==0) {
                count += hm.getOrDefault(0, 0);
            }
            else {
                count += hm.getOrDefault(60-newTime,0);
            }
            
            hm.put(newTime, hm.getOrDefault(newTime,0)+1);
        }
        
        return count;
    }
}