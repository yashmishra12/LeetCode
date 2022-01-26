class Solution {
    public int calculate(String s) {
       if(s==null || s.isEmpty()) return 0;
        int len = s.length();
        
        Stack<Integer> st = new Stack<>();
        int curNum = 0;
        char operation = '+';
        
        for(int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if(Character.isDigit(cur)) curNum = curNum*10 + (cur - '0');
            
            if(!Character.isDigit(cur) && !Character.isWhitespace(cur) || i==len-1) {
                if(operation == '+') st.push(curNum);
                else if(operation=='-') st.push(-curNum); //opration begins with '+'
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

/*  "+", "-" ---> PUSH 
    "/", "*" --> Pop, operate, push
    
It is important to understand that we do not have negative numbers and therefore, the first number will be POSTIVE. That's why we start with + operation. We push into stack and change our operation only on receiving a NON-DIGIT number. 

*/