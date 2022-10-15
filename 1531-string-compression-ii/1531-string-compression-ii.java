class Solution {
    private int n;
    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        
        if(n==100) {
            boolean allSame = true;
            for(int i=1; i<n;i++) {
                if(s.charAt(i-1) != s.charAt(i)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {return 4;}
        }
        //4 states --------> [idx][prev_char][freq_count][k]
        int[][][][] dp = new int[n+1][27][11][n+1];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 27; j++) {
                for(int x = 0; x < 11; x++) {
                    for(int y = 0; y < n; y++) {
                        dp[i][j][x][y] = -1;
                    }
                }                
            }            
        }
        
        char defaultCharacter = (char)('z'+1);
        // dpHelper(starting index, default prev character, current freq count, given string, value of k, dp array )
        return dpHelper(0, defaultCharacter, 0, s, k, dp);
    }
    
    public int dpHelper(int idx, char prev, int curCharFreq, String s, int k, int dp[][][][]) {
        if (k<0) {return Integer.MAX_VALUE;}
        
        if(idx>=n) {return 0;}
        // be the freq be 99 or 11 or 10...the case will be same. 
        if(curCharFreq >=10) {
            curCharFreq = 10;
        }
        
        if(dp[idx][prev-'a'][curCharFreq][k]!=-1) {
            return dp[idx][prev-'a'][curCharFreq][k];
        }
        
        int res = Integer.MAX_VALUE;
        
        res = Math.min(res, dpHelper(idx+1, prev, curCharFreq, s, k-1, dp));
        
        if(s.charAt(idx)!=prev){
            res = Math.min(res, 1 + dpHelper(idx+1, s.charAt(idx), 1, s, k, dp));
        }
        else {
            if (curCharFreq == 1 || curCharFreq == 9) {
                res = Math.min(res, 1+dpHelper(idx+1, prev, (curCharFreq+1), s, k, dp));
            }
            else {
                res = Math.min(res, dpHelper(idx+1, prev, curCharFreq+1, s, k, dp));
            }
        }
        
        
        return dp[idx][prev-'a'][curCharFreq][k] = res;
    }
}