class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<heights.length; i++) {
            if(st.isEmpty()) {
                left[i] = 0;
                st.push(i);
            } else {
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                    st.pop();
                }
                if(st.isEmpty()) left[i] = 0;
                else left[i] = st.peek()+1;
                
                st.push(i);
            }
        }
        
        while(!st.isEmpty()) st.pop();
        
         for(int i=heights.length-1; i>=0; i--) {
            if(st.isEmpty()) {
                right[i] = heights.length-1;
                st.push(i);
            } else {
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]) {
                    st.pop();
                }
                if(st.isEmpty()) right[i] = heights.length-1;
                else right[i] = st.peek()-1;
                
                st.push(i);
            }
        }
        
        int max=0;
        
        for(int i=0;i<heights.length; i++) {
            max = Math.max(max, heights[i]*(right[i]-left[i]+1));
        }
        
        return max;
    }
}