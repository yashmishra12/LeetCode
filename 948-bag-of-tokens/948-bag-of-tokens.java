class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
       Arrays.sort(tokens);
        int finalAns = 0, left = 0, right = tokens.length-1, score = 0;
        
        
        while(left<=right) {
            if(power>=tokens[left]){
                power -= tokens[left++];
                score++;
                finalAns = Math.max(score, finalAns);
            } 
            else if (score>0) {
                power += tokens[right--];
                score--;
            }
            else {
                return finalAns;
            }
        }
        
        return finalAns;
    }
}