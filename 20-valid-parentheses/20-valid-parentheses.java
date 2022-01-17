class Solution {
    public boolean isValid(String s) {
    
        if(s.length()==1) return false;
        
     Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            Character cur = s.charAt(i);
            
            if(cur=='(' || cur=='[' || cur=='{') {
                st.push(cur);
            } else {
                if(st.isEmpty()) return false;
                Character top = st.pop();
                
                if(cur==')' && top!='(')    return false; 
                
                else if (cur==']' && top != '[') return false;
                
                else if (cur=='}' && top != '{') return false;
                        
            }
        }
        
        return st.isEmpty() ? true:false;
    }
}