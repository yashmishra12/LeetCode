class Solution {


    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    
    public void backtrack(List<String> ans, String prefix, int open, int close, int n) {
        
        if (open < n) {
            String newPrefix = prefix + "(";
            backtrack(ans, newPrefix, open+1, close, n);
        }
        
         if (close < open) {
            String newPrefix = prefix + ")";
            backtrack(ans, newPrefix, open, close+1, n);
        }
        
        if (close==n) {
            ans.add(prefix);
            return;
        }
    }

}
