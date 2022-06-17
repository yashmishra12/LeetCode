class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) {return res;}
        
        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        helper(res, digits, "", 0, map);
        return res;
        
    }
    
    public void helper(List<String> res, String digits, String sb, int index, String[] map) {
        
        if(index == digits.length()) {
            res.add(sb);
            return;
        }
        
        String letters = map[digits.charAt(index) - '0'];
        
        for(int i=0; i<letters.length(); i++) {
            helper(res, digits, sb+letters.charAt(i), index+1, map);
        }
        
    }
}