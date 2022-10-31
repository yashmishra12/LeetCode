class Solution {
    
    class Position {
        int val;
        int direction;
        Position(int val, int direction) {
            this.val = val;
            this.direction = direction;
        }
    }
    
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
       if(x==0) {return 0;}
        
        int steps = 0;
        int furthest = 8000;
         Set<Integer> forbiddenSpots = new HashSet<>();
        for(int i=0; i<forbidden.length; i++) {
            forbiddenSpots.add(forbidden[i]);
        }
       
        Set<String> visited = new HashSet<>();
        
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0,0));
        visited.add(0 + "-" + 0);
        steps++;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Position curPos = q.poll();
                int next_a = curPos.val + a;
                if(next_a==x) {
                    return steps;
                }
                if(next_a>=0 && next_a<=furthest && !forbiddenSpots.contains(next_a) && visited.add(next_a +"-"+1)) {
                    q.add(new Position(next_a, 1));
                }
                
                if(curPos.direction==1){
                    int next_b = curPos.val-b;
                    if(next_b==x){
                        return steps;
                    }
                    
                    if(next_b>=0 && next_b<=furthest && !forbiddenSpots.contains(next_b)
                      && visited.add(next_b+"-"+0)){
                        q.add(new Position(next_b,0));
                    }
                }
            }
            steps++;
            
        }
        return -1;
    }
}