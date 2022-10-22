class Solution {
    public String minWindow(String s, String t) {
        int[] reqArr = new int[128];
        int start = 0, count = 0, minLen = Integer.MAX_VALUE;
        String res = "";
        for(char c: t.toCharArray()) {
            reqArr[c]++;
        }
        
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(--reqArr[c] >= 0 ) {
                count++;
            }
            
            while(count==t.length()) {
                if (minLen>i-start+1) {
                    minLen = i-start+1;
                    res = s.substring(start, i+1);
                }
                if(++reqArr[s.charAt(start)]>0) {
                    count--;
                }
                start++;
            }
        }
        
        return res;
    }
}