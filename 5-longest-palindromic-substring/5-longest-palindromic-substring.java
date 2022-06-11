class Solution {
    public String longestPalindrome(String s) {
        if (s.length()==1) {return s;}
        
        int[] curLongest = {0,1};
        
        for(int i=1; i<s.length(); i++) {
            int[] odd  = getLength(s, i-1, i+1);
            int[] even = getLength(s, i-1, i);
            int[] longest = helper(odd, even);
            
            curLongest = helper(curLongest, longest);
        }
        
        return s.substring(curLongest[0], curLongest[1]);
        
    }
    
    public static int[] helper (int[] a, int[] b) {
        int[] res = a[1]-a[0] > b[1]-b[0] ? a:b;
        return res;
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