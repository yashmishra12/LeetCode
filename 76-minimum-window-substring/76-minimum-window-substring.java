class Solution {
    public String minWindow(String s, String t) {
        
        int right = 0, count=0, left=0, minLen = Integer.MAX_VALUE;
        String res = "";
        
        int[] letterCount = new int[128];
        
        for(char c: t.toCharArray()) { letterCount[c]++; }

        for(right=0; right<s.length(); right++) {
           if(--letterCount[s.charAt(right)]>=0) { count++; }
            
            while (count==t.length()) {
                if(minLen>right-left+1) {
                    minLen = right-left+1;
                    res = s.substring(left, right+1);
                }
                
                if(++letterCount[s.charAt(left)]>0) {
                    count--;
                }
                
                left++;
            }
        }
        
        return res;
        
        
    }
}