class Solution {
    public boolean digitCount(String num) {

        
        int[] count = new int[10];
       
        for (int i = 0; i < num.length(); i++) {
            int curNum = num.charAt(i) - '0';
            count[curNum]++;
        }

        for (int i = 0; i < num.length(); i++) {
            int curNum = num.charAt(i) - '0';
            if ( curNum != count[i]) {
                return false;
            }
          }
        
        
        return true;
        
        
    }
}