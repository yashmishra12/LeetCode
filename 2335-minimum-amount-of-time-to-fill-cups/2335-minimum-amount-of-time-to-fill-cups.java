class Solution {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int a: amount) {
            pq.offer(a);
        }
        
        int time = 0;
        
        while(!pq.isEmpty()) {
            
            int first= pq.poll();
            int second = pq.poll();
            
            if(first==0 && second==0){
                break;
            }
            first = Math.max(0, --first);
            second = Math.max(0, --second);
            
            pq.offer(first);
            pq.offer(second);
            time++;
        }
        
        return time;
    }
}