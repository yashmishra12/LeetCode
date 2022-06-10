class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0 || s.length()==1) return s.length();
        
        int maxLength = 0, start = 0, end = 0;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(end < s.length()) {
            char curChar = s.charAt(end);
            
            if(hm.containsKey(curChar)) {
                start = Math.max(start, hm.get(curChar)+1);
            }
            
            hm.put(curChar, end);
            maxLength = Math.max(end-start+1, maxLength);
            end++;
        }
        
        return maxLength;
    }
}