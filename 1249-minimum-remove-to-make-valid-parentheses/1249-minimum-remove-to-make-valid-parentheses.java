class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Set<Integer> indxToRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i); //index of opening braces added
            }
            else if (s.charAt(i)== ')') {
                if (st.isEmpty()) {
                    indxToRemove.add(i); //close braces with no open braces...IMBALANCE -> add index
                } else {
                    st.pop(); //the close braces consumed the open braces. 
                }
            }
        }
        
         //LeftOver open braces index added
        while(!st.isEmpty()) {
            indxToRemove.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++) {
            if(indxToRemove.contains(i) == false) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        
    }
}