class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        
        for(char c: str ) {
            freq[c-'a']++;
        }
        
        int start = 0;
        int maxLen = 0;
        boolean  valid = true;
        for(int end=0; end< s.length(); end++) {
            char curChar = s.charAt(end);
            if (freq[curChar-'a']<k) {
                String sb = s.substring(start, end);
                maxLen = Math.max(maxLen, longestSubstring(sb, k));
                start = end+1;
                valid=false;
            }
        }
        
        
        if(valid){
            return s.length();
        } else {
            return Math.max(maxLen, longestSubstring(s.substring(start), k));
        }
    }      
}