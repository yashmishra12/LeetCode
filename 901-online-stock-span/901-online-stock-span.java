class StockSpanner {

    Stack<int []> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
      
    public int next(int price) {
        int i=1;
        while(!st.isEmpty() && st.peek()[0]<=price)
        {
            i += st.pop()[1];
        }
        st.push(new int[]{price,i});
        return i;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

