class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<asteroids.length; i++) {
            int cur = asteroids[i];
            
            if(cur>0) st.push(cur);
            else {
                while(!st.isEmpty() && st.peek()>0 && st.peek()<-cur) st.pop();
                
                if(!st.isEmpty() && st.peek()>-cur){}
                else if(!st.isEmpty() && st.peek()==-cur) st.pop();
                else st.push(cur);
            }
        }
        
        int[] res = new int[st.size()];
        
        for(int i=res.length-1; i>=0; i--) res[i] = st.pop();
        
        return res;
    }
}