class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==1) {return s;}
        
        int[] curLongest = {0,1};
        
        for(int i=1; i<s.length(); i++) {
            int[] odd  = getLength(s, i-1, i+1);
            int[] even = getLength(s, i-1, i);
            int[] longest = odd[1]-odd[0] > even[1]-even[0] ? odd:even;
            
            curLongest = curLongest[1]-curLongest[0] > longest[1]-longest[0] ? curLongest : longest;
        }
        
        return s.substring(curLongest[0], curLongest[1]);
        
    }
    
    
    public static int[] getLength(String s, int left, int right) {
        while(left>=0 && right<s.length()) {
            if(s.charAt(left) != s.charAt(right)) {break;}
            
            left--;
            right++;
        }
        
        return new int[] {left+1, right};
    }
}