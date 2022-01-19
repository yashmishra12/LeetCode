class Solution {
    public int orangesRotting(int[][] grid) {
        
        HashSet<String> fresh = new HashSet<>();
        HashSet<String> rotten = new HashSet<>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                int cur = grid[i][j];
                if(cur==1) fresh.add(i+":"+j);
                else if (cur==2) rotten.add(i+":"+j);
            }
        }
        

        
        int res = 0;
        
        while(fresh.size()>0) {
            HashSet<String> infected = new HashSet<>();
            for(String r: rotten) {
                int x = Integer.parseInt(r.split(":")[0]);
                int y = Integer.parseInt(r.split(":")[1]);
                
                int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                
                for(int[] d: dir) {
                    int newX = x+d[0];
                    int newY = y+d[1];
                    
                    String cord = newX+":"+newY;
                    
                    if(fresh.contains(cord)) {
                        fresh.remove(cord);
                        infected.add(cord);
                    }
                }
            }
            if(infected.size()==0) return -1;
            
            res++;
            rotten = infected;
            
        }
        
        return res;
    }
}