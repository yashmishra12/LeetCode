class Solution {
    public int calculate(String s) {
       if(s==null || s.isEmpty()) return 0;
        s = s.trim();
        int len = s.length();
        
        Stack<Integer> st = new Stack<>();
        int curNum = 0;
        char operation = '+';
        
        for(int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if(Character.isSpace(cur)) continue;
            if(Character.isDigit(cur)) curNum = curNum*10 + (cur - '0');
            
            if(!Character.isDigit(cur) && !Character.isWhitespace(cur) || i==len-1) {
                if(operation == '-') st.push(-curNum);
                else if(operation=='+') st.push(curNum);
                else if(operation=='*') st.push(st.pop()*curNum);
                else if(operation=='/') st.push(st.pop()/curNum);
                
                operation = cur;
                curNum = 0;
            }
        }
        
        int res = 0;
        
        while(!st.isEmpty()) res+=st.pop();
        
        return res;
    }
}