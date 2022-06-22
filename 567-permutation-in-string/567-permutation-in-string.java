public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        
        if (s1Len > s2Len) {return false;}
        
        int[] s1map = new int[26];
        
        for (int i = 0; i < s1Len; i++) {
            s1map[s1.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2Len - s1Len + 1; i++) {
            int[] s2map = new int[26];
            
            for (int j = 0; j < s1Len; j++) { //runs in slot of size s1 inside s2. 
                s2map[s2.charAt(i + j) - 'a']++;
            }
            if (matches(s1map, s2map))
                {return true;}
        }
        return false;
    }
    
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}