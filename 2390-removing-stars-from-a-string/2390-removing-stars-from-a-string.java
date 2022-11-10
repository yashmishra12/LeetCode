class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='*'){
                st.pop();
            }else{
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