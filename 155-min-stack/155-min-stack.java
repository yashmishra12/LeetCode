class MinStack {
    List<Integer> stack = new ArrayList<>();
    List<Integer> minStack = new ArrayList<>();
    
    public MinStack() {}
    
    public void push(int val) {
        if(stack.size()==0) {
            stack.add(val);
            minStack.add(val);
        } else {
            int sm = Math.min(val, minStack.get(stack.size()-1));
            minStack.add(sm);
            stack.add(val);
        }
    }
    
    public void pop() {
        
        minStack.remove(stack.size()-1);
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        int res = minStack.get(stack.size()-1);
        return res;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */