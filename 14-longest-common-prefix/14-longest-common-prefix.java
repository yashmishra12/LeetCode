class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        
        for(int i=0;i<strs[0].length(); i++) {
            for(int k=1; k<strs.length; k++) {
                if (i>=strs[k].length() || strs[k].charAt(i) != strs[0].charAt(i)) 
                {
                    return strs[k].substring(0, i);
                }
                
            }
        }
        
        return strs[0];
    }
}