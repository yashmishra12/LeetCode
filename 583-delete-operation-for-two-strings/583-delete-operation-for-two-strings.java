class Solution {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * lcs(word1, word2);
    }
    
    public static int lcs (String s1, String s2) {
        int[][] len = new int[s2.length()+1][s1.length()+1];
        
        for(int i=1; i<=s2.length(); i++) {
            for(int j=1; j <= s1.length(); j++) {
                
                if(s2.charAt(i-1) == s1.charAt(j-1)) { 
                    len[i][j] = 1+len[i-1][j-1];
                }
                else {
                    len[i][j] = Math.max(len[i][j-1], len[i-1][j]);
                }
            }
        }
        
        return len[s2.length()][s1.length()];
    }
}