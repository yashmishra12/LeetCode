class Solution {
    public boolean digitCount(String num) {

        
        int[] count = new int[10];
       
        for (int i = 0; i < num.length(); i++) {
            int curNum = Character.digit(num.charAt(i), 10);
            count[curNum]++;
        }

        for (int i = 0; i < num.length(); i++) {
            int curNum = Character.digit(num.charAt(i), 10);
            if ( curNum != count[i]) {
                return false;
            }
          }
        
        
        return true;
        
        
    }
}