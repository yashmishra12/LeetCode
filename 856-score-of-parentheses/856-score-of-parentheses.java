class Solution {
    public int scoreOfParentheses(String s) {
        return helper(s);
    }
    
        public int helper(String s) {
        Stack<String> st = new Stack<>();
        
        int curSum = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            String curChar = String.valueOf(s.charAt(i));
            
            if (curChar.equals("("))  {
                st.push(curChar);
            } else {
                
                if (check(st)) {
                    
                   while (st.size()>0 && check(st)) {
                        curSum += (Integer.valueOf(st.peek()));
                        st.pop();
                   }
                    
                } 
                

                if (curSum==0) {
                    st.pop(); 
                    curSum=1;
                } else {
                    st.pop();
                    curSum = 2*curSum;
                }
                st.push(String.valueOf(curSum));
              
                curSum = 0;
                
            }
        }
        
        int res = 0;
        while(st.size()>0) {
            res += Integer.valueOf(st.peek());
            st.pop();
        }
            
        return res;
    }
    
    public boolean check(Stack<String> st) {
        return st.peek().equals(")") == false && st.peek().equals("(") == false;
    }
    
}