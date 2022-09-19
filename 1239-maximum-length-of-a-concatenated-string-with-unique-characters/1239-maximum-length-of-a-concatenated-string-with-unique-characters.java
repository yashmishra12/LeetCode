class Solution {
    public int maxLength(List<String> arr) {
        List<String> ansList = new ArrayList<>();
        int ans = 0;
        
        ansList.add("");
        
        for(String str: arr) {
            if (!checkUnique(str)) {continue;}
            
            List<String> newList = new ArrayList<>();
            
            for(String candidate: ansList) {
                String potCand = candidate+str;
                if (checkUnique(potCand)) {
                    newList.add(potCand);
                    ans = Math.max(ans, potCand.length());
                }
            }
            
            ansList.addAll(newList);
        }
        
        return ans;
        
        
    }
    
    boolean checkUnique(String str) {
        if (str.length()>26) { return false;}
        
        int[] freq = new int[26];
        char[] arr = str.toCharArray();
        
        for(char ch: arr) {
            freq[ch-'a']++;
            if(freq[ch-'a']>1) {
                return false;
            }
        }
        return true;
    }
}