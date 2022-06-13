class Solution {
    public int lengthOfLastWord(String s) {
         
        s = s.trim();  
        int totalLen = s.length();
        int lastWordStart =  s.lastIndexOf(" ") + 1;
        return (totalLen-lastWordStart);
    }
}