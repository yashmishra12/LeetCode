class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] != b[1] ?  a[1]-b[1] :  a[0]-b[0]);
        
        for(int i=0; i<mat.length; i++) {
           int[] row = new int[2];
            row[0] = i;
            
            int count = 0;
            
            for(int m=0; m<mat[i].length; m++) {
                if(mat[i][m]==1) {count++;}    
            }
            row[1] = count;
          pq.add(row);
        }
        
        int[] res = new int[k];
        
       for(int i=0; i<k; i++) {
           res[i] = pq.remove()[0];
       }
        
        return res;
    }
}