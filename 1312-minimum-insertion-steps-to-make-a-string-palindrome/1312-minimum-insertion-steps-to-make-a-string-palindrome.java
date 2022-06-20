class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int[][] dp = new int[n][n];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp.length; j++) {
                dp[i][j] = -1;
            }
        }
        
        return minInsert(s, 0, s.length()-1, dp);
    }
    
    int minInsert(String s, int i, int j, int[][] dp) {
        if (i>=j) {return 0;}
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(s.charAt(i)==s.charAt(j)) {
            dp[i][j] = minInsert(s, i+1, j-1, dp);
            return dp[i][j];
        }
        else {
            int dec1 = 1+minInsert(s, i+1, j, dp);
            int dec2 = 1+minInsert(s, i, j-1, dp);
            dp[i][j] = Math.min(dec1, dec2);
            return dp[i][j];
        }
        
    }
}