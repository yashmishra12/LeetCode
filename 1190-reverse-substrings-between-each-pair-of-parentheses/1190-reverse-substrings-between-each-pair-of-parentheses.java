class Solution {
    public String reverseParentheses(String s) {
//         if (s.length()==1) {
//             return s;
//         }
        
        Stack<Character> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++) {
            Character curChar = s.charAt(i);
            
            if (curChar==')') {
                Queue<Character> q = new LinkedList<>();
                
                while(st.peek() != '(') {
                    q.add(st.pop());
                }
                st.pop(); //pop the "(" bracket
                
                while (q.size()>0) {
                    st.add(q.poll());
                }
            } 
            
            else {
                st.push(curChar);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c: st) {
            sb.append(c);
        }
        return sb.toString();
    }
}