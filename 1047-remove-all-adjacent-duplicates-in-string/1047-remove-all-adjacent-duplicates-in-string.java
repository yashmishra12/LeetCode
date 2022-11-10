class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        
        for(int i=1; i<s.length();i++){
            char c = s.charAt(i);
            boolean flag = true;
            while(!st.isEmpty() && c == st.peek()){
                st.pop();
                flag = false;
            }
            
            if(flag) {
                st.push(c);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        
        return sb.toString();
    }
}