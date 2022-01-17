class Solution {
    public boolean isValid(String s) {
        
        if(s.length()==1) return false;
        
        Stack<Character> st=new Stack<>();
        
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i)==')'){
                if(st.isEmpty()) return false;
                
                if(st.peek()=='(')
                    st.pop();
                else return false;
            }
             else if(s.charAt(i)==']'){
                 if(st.isEmpty()) return false;
                
                 if(st.peek()=='[')
                    st.pop();
                 else return false;
            }
             else if(s.charAt(i)=='}'){
                 if(st.isEmpty()) return false;
                
                 if(st.peek()=='{')
                    st.pop();
                 else return false;
            }
            else{
               st.push(s.charAt(i)); 
            }

    } 
        
        boolean res =  (st.isEmpty()) ?  true :  false;
        return res;
    }
}

