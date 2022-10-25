class Solution {
    static int[] par;
    
    public static int findPar(int u) {
        if(par[u]==u) {return u;}
        return par[u] = findPar(par[u]);
    }
    
    
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }
        par = new int[n];
        for(int i=0; i<n; i++) {
            par[i] = i; //everyone is his own parent at start
        }
        
        for(int[] connection: connections) {
            int u = connection[0];
            int v = connection[1];
            
            int p1 = findPar(u);
            int p2 = findPar(v);
            
            if(p1!=p2) {
                par[p2] = p1;
            }
        }
        
        int comp = 0;
        for(int i=0; i<n; i++) {
            int p = findPar(i);
            if(p==i){
                comp++;
            }
        }
        
        return comp-1;
        
    }
}