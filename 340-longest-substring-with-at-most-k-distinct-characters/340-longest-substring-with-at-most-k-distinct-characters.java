class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        
        if(k==0) {return 0;} 
        
        int left = 0;
        int right =0;
        
        Map<Character, Integer> rightMostPosition = new HashMap<>();
        int maxLength = 1;
        
        while(right<n) {
            rightMostPosition.put(s.charAt(right), right);
            right++;
            
            if(rightMostPosition.size() == k+1){
                int lowestIndex = Collections.min(rightMostPosition.values());
                rightMostPosition.remove(s.charAt(lowestIndex));
                left = lowestIndex+1;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        
        return maxLength;
    }
}