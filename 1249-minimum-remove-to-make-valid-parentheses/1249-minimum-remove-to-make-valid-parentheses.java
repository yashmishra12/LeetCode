class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Set<Integer> indxToRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            else if (s.charAt(i)== ')') {
                if (st.isEmpty()) {
                    indxToRemove.add(i);
                } else {
                    st.pop();
                }
            }
        }
        
        while(!st.isEmpty()) {
            indxToRemove.add(st.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++) {
            if(indxToRemove.contains(i)==false) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        
    }
}