class Solution {
     HashSet<String> visited=new HashSet<>();
    
    public List<String> removeInvalidParentheses(String s) {
    
        int minRemovals = getMinRemovals(s);
        HashSet<String> hs = new HashSet<>(); //checks duplicate
        helper(s, minRemovals, hs);
        
        List<String> result = new ArrayList<>(hs);
        
        return result;
        
    }
    
    public void helper(String s, int removal, HashSet<String> hs) {

       if (removal==0 && getMinRemovals(s)==0) {
           hs.add(s);
           return;
       }

        
        for (int i=0; i<s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            
            if (!visited.contains(left+right)) {
                visited.add(left+right);
                helper(left+right, removal-1, hs);
            }
            
        }
    }
    
    public int getMinRemovals(String s) {
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            Character curChar = s.charAt(i);

            
            if (curChar == '(') {
                st.push(curChar);
            } else if (curChar == ')') {
                if (st.size()==0) {
                    st.push(curChar);
                }
                else if(st.peek() == '(') {
                    st.pop();
                } else {
                    st.push(curChar);
                }
            } 
        }
        
        return st.size();
    }
}


