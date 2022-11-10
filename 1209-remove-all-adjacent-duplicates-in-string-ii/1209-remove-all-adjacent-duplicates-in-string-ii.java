class Solution {
    public String removeDuplicates(String s, int k) {
    StringBuilder sb = new StringBuilder();
    Stack<int[]> st = new Stack<>();
    
    for(char c: s.toCharArray()){
      if(!st.isEmpty() && st.peek()[0]==c){
          st.peek()[1]++;
      }
        else{
            st.push(new int[]{c,1});
        }
        
        
        if(st.peek()[1]==k){
            st.pop();
        }
    }
    
    while(!st.isEmpty()){
        int[] top = st.pop();
        while(top[1]>0){
            sb.insert(0, (char)top[0]);
            top[1]--;
        }
        
    }
    
    return sb.toString();
    }
}