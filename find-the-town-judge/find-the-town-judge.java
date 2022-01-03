class Solution {
    public int findJudge(int n, int[][] trust) {
    
        if(trust.length < n-1) return -1;
        
        int[] indeg = new int[n+1];
        int[] outdeg = new int[n+1];
        
        for(int[] a: trust) {
            indeg[a[1]]++;
            outdeg[a[0]]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(indeg[i]==n-1 && outdeg[i]==0) return i;
        }
        
        
        return -1;
    }
}