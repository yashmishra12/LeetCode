class Solution {
    public int titleToNumber(String s) {
        
        int res = 0;
        for(int i=0; i<s.length(); i++) {
            res = res*26;
            
            res += (s.charAt(i) - 64);
        }
        
        return res;
        
    }
}