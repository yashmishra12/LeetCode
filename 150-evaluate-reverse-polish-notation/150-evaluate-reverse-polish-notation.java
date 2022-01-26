class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        List<String> op = new ArrayList<>(Arrays.asList(new String[]{"*","+","/","-"}));
        
        for(int i=0; i<tokens.length; i++) {
            String curr = tokens[i];
            if(op.contains(curr)) {
                if(curr.equals("*")) {
                    int num2 = Integer.parseInt(st.pop());
                    int num1 = Integer.parseInt(st.pop());
                    int res = num1 * num2;
                    st.push(String.valueOf(res));
                } 
                  else if(curr.equals("+")) {
                    int num2 = Integer.parseInt(st.pop());
                    int num1 = Integer.parseInt(st.pop());
                    int res = num1 + num2;
                    st.push(String.valueOf(res));
                }  
                  else if(curr.equals("/")) {
                    int num2 = Integer.parseInt(st.pop());
                    int num1 = Integer.parseInt(st.pop());
                    
                    int res = num1 / num2;
                   st.push(String.valueOf(res));
                }  
                  else {
                    
                    int num2 = Integer.parseInt(st.pop());
                    int num1 = Integer.parseInt(st.pop());
                    int res = num1 - num2;
                    st.push(String.valueOf(res));
                }   
            }else {
                st.push(curr);
            }
            
        }
        
        int res = Integer.parseInt(st.pop());
        return res;
    }
}