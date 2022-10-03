class Solution {
    public int minCost(String s, int[] neededTime) {
        int ans = 0;
        
   
        for(int i=1; i<neededTime.length; i++) {
            if (s.charAt(i)==s.charAt(i-1)) {
                if (neededTime[i]>neededTime[i-1]) {
                    ans += neededTime[i-1]; //consume the minimum
                    //no need to shift as max is already at right
                }else {
                    ans += neededTime[i]; //consume the minimum
                    neededTime[i] = neededTime[i-1]; //shifting max to right
                }
            }
        }
        
        return ans;
    }
}