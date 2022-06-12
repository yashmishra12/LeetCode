class Solution {
    public int myAtoi(String str) {
    
        if(str==null || str.isEmpty()) return 0;
        
        int sign=1, i=0, n=str.length();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        while (i<n &&  Character.isSpace(str.charAt(i))) {i++;}
        
        if(i>=n) {return 0;}
        
        if(str.charAt(i)=='+' || str.charAt(i)=='-'){sign = str.charAt(i) == '+' ? 1 : -1; i++;}
        
        long res = 0;
        
        while(i<n && Character.isDigit(str.charAt(i))) {
            res = res*10 + (str.charAt(i) - '0');
            
            if(res*sign > max || res*sign < min) {return sign == 1 ? max : min;}
            
            i++;
        }
        
        return (int)(res*sign);
    }
}