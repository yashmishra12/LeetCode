class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        
        for(int[] t: trips) {
            for(int i=t[1]; i<t[2]; i++) { //i doen't go till t[2] because people are boarded-off
                res[i] += t[0];
                if(res[i]>capacity) return false;
            }
        }
        return true;
    }
}