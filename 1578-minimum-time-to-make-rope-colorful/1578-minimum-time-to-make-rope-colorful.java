class Solution {
    public int minCost(String s, int[] neededTime) {
        int n = neededTime.length, groupSum = neededTime[0], groupMax = neededTime[0], ans = 0;
        
   
        for(int i=1; i<n; i++) {
            if (s.charAt(i)==s.charAt(i-1)) {
                if (neededTime[i]>neededTime[i-1]) {
                    ans += neededTime[i-1];
                    
                }else {
                    ans += neededTime[i];
                    neededTime[i] = neededTime[i-1];
                }
            }
        }
        
        return ans;
    }
}