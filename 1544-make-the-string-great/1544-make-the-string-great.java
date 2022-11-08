class Solution {
    public String makeGood(String s) {

        Stack<Character>st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        st.add(s.charAt(0));
        for(int i=1; i<s.length();i++){
            char curChar = s.charAt(i);
            boolean flag = true;
            if(!st.isEmpty() && Math.abs(curChar-st.peek())==32){
                flag = false;
                st.pop();
            }
            if(flag) {
                st.push(curChar);
            }
        }
        while(!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        
        return sb.toString();
    }
}