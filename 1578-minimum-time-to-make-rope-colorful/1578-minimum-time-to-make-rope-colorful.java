class Solution {
    public int minCost(String s, int[] neededTime) {
        int n = neededTime.length, groupSum = neededTime[0], groupMax = neededTime[0], ans = 0;
        
        
        
        for(int i=1; i<n; i++) {
            if(s.charAt(i)!=s.charAt(i-1)) {
                ans += groupSum - groupMax;
                groupSum = 0;
                groupMax = 0;
            }
            groupSum += neededTime[i];
            groupMax = Math.max(groupMax, neededTime[i]);
        }
        
        ans += groupSum - groupMax;
        
        return ans;
    }
}