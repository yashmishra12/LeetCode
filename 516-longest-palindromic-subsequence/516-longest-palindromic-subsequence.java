class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = "";
        for(int i = 0; i < s.length(); i++) {
            r = s.charAt(i) + r;
        }
        
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                if(s.charAt(i) == r.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                
                // max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        
        return dp[n][n];
    }
}