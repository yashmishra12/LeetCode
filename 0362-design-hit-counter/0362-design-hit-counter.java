class HitCounter {

    Queue<Integer> q;
    
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        q.add(timestamp);
        
        int start = timestamp - 300;
        while(!q.isEmpty() && q.peek()<=start) {q.poll();}
    }
    
    public int getHits(int timestamp) {
        int start = timestamp - 300;
        while(!q.isEmpty() && q.peek()<=start) {q.poll();}
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */