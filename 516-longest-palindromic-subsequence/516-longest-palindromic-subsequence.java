class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = "";
        for(int i = 0; i < s.length(); i++) {
            r = s.charAt(i) + r;
        }
        
        int max = 0;
        int[][] dp = new int[s.length() + 1][r.length() + 1];
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < r.length(); j++) {
                
                if(s.charAt(i) == r.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                
                max = Math.max(max, dp[i + 1][j + 1]);
            }
        }
        
        return max;
    }
}