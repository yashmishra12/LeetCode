class Solution {
//     public List<String> generateParenthesis(int n) {
        
//         List<String> ans = new ArrayList<>();
        
//         backtrack(ans, new StringBuilder(), 0, 0, n);
//         return ans;
//     }
    
//     public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n) {
//         if (sb.length() == n*2) {
//             ans.add(sb.toString());
//             return;
//         }
        
//         if (open < n) {
//             sb.append("(");
//             backtrack(ans, sb, open+1, close, n);
//             sb.deleteCharAt(sb.length()-1);
//         }
        
//          if (close < open) {
//             sb.append(")");
//             backtrack(ans, sb, open, close+1, n);
//             sb.deleteCharAt(sb.length()-1); // undoes sb.append("*") 
//         }
//     }
        public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        generateParenthesis(n, n, "", results);
        return results;
    }

    public void generateParenthesis(int openCount, int closeCount, String result, List<String> results) {
        if(closeCount < openCount) return;
        if(openCount < 0) return;
        if(openCount == 0 && closeCount == 0) {
            results.add(result);
            return;
        }

        generateParenthesis(openCount - 1, closeCount, result + "(", results);
        generateParenthesis(openCount, closeCount - 1, result + ")", results);
    }

}