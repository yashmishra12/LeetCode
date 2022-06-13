class Solution {
    public int lengthOfLastWord(String s) {
        
        
        String[] res = s.split(" ");
        String lastWord = res[res.length-1];
        return lastWord.length();
    }
}