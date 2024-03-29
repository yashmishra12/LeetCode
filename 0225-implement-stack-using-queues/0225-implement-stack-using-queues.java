class MyStack {

    private Queue<Integer> q1 = new LinkedList<>();
    private int top;
    
    public MyStack() {}
    
    public void push(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
        top = x;
    }
    
    public int pop() {
        
       int x =  q1.remove();
       if(q1.isEmpty() == false){
           top = q1.peek();
       } 
        return x;
        
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */