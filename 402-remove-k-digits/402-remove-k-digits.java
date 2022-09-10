class Solution {
    public String removeKdigits(String num, int k) {
        
        if (k==num.length()) {
            return "0";
        }
        
        Stack<Character> st = new Stack<>();
        
        st.push(num.charAt(0));
        
        for(int i = 1; i<num.length();i++) {
            Character curChar = num.charAt(i);
            
            while(st.size() > 0 && k>0 && st.peek()>curChar){
                st.pop();
                k--;
            }
            st.push(curChar);
        }
        
        while(k>0) {
            st.pop();
            k--;
        }
        
        Character[] arr = new Character[st.size()];
        
        for(int i=arr.length-1; i>=0; i--) {
            arr[i] = st.pop();
        }
        
        int d = 0;
        while(d<arr.length && arr[d] == '0') {
            d++;
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        while(d<arr.length) {
            sb.append(arr[d++]);
        }
        
        if (sb.length()==0) {return "0";}
        
        return sb.toString();
        
    }
}