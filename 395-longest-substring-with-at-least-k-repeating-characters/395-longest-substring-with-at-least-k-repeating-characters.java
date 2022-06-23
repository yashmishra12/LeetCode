class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] freq = new int[26];
        
        for(char c: str ) {
            int index = c - 'a';
            freq[index]++;
        }
        
        int start = 0;
        int maxLen = 0;
        boolean  valid = true;
        for(int end=0; end< s.length(); end++) {
            if (freq[str[end]-'a'] > 0 && freq[str[end]-'a']<k) {
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