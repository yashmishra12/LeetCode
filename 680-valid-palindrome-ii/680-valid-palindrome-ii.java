class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        
        while(i<j) {
            if(s.charAt(i) != s.charAt(j)){
                return (helper(s, i, j-1) || helper(s, i+1, j));
            }
            i++;
            j--;
        }
        return true;
    }
    
     private boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}