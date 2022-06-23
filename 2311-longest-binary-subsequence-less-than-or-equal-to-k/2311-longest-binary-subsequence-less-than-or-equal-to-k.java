class Solution {
    public int longestSubsequence(String s, int k) {
        int sum = 0, one = 0, zero = 0;
        
        for(char c: s.toCharArray() ) {
            if (c=='0') {zero++;}
        }
        
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(c=='1'){
                sum += Math.pow(2, s.length()-1-i);
                if(sum<=k) {
                    one++;
                } else {
                    break;
                }
            }
        }
        
        return one+zero;
        
    }
}