class Solution {
    public void reverseString(char[] s) {
        if(s.length==1) return;
        
        int i=0, j=s.length-1;
        
        while(i<j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            
            i++;
            j--;
        }
    }
}