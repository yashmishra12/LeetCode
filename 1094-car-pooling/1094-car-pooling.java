class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001]; //mentioned that there are 1000 locations
        
        for(int[] t: trips) {            
            res[t[1]] += t[0];
            res[t[2]] -= t[0];
        }
        
        for(int n: res) {
            capacity = capacity - n;
            if(capacity<0) return false;
        }
        
        
        return true;
    }
}