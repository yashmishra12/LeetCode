class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        
        int[] arr = new int[26];
        
        for (char c: mag) {
            arr[c-'a']++;
        }
        
        for(char c: ransom) {
            arr[c-'a']--;
            
            if(arr[c-'a']<0) {return false;}
        }
        
        return true;
        
    }
}