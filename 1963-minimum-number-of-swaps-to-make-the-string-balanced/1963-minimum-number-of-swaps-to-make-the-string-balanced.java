class Solution {
    public int minSwaps(String s) {
        int max = 0;
        int score = 0;
        
        for(int i=0; i<s.length();i++) {
            Character curChar = s.charAt(i);
            
            if(curChar == '[') {
                score--;
            } else {
                score ++;
            }
            max = Math.max(score, max);
        }
        
        return (max+1)/2;
    }
}