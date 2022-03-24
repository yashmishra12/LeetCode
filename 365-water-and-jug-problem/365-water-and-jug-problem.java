class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        
        if(x+y<z) return false;
        int[] dirs = {x, y,-x, -y};
        Deque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();        
        q.offer(0);

        while(q.size()>0){
            int cur = q.poll();
            if(cur==z) return true;

            for(int d: dirs){
                int newNode = cur+d;
                if (newNode<0 || newNode>x+y) continue;
                if (newNode==z) return true;
                
                if(!seen.contains(newNode)) {
                    q.offer(newNode);  
                    seen.add(newNode);
                }
            }
        }
        
          return false;
    }
    
    //         if(x+y<z) return false;
        
//         return z%gcd(x,y)==0;
//     }
    
//     public static int gcd(int x, int y){
//         if (y==0) return x;
//         return gcd(y, x%y);
//     }
}

