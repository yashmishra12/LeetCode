
class Solution {
    class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>(); 
    public DisjointSet(int n) {
        for(int i = 0;i<=n;i++) {
            parent.add(i); 
            size.add(1); 
        }
    }

    public int findUPar(int node) {
        if(node == parent.get(node)) {
            return node; 
        }
        int ulp = findUPar(parent.get(node)); 
        parent.set(node, ulp); 
        return parent.get(node); 
    }

    
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u); 
        int ulp_v = findUPar(v); 
        if(ulp_u == ulp_v) return; 
        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v); 
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u)); 
        }
        else {
            parent.set(ulp_v, ulp_u); 
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
    
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int n = stones.length;
        for(int i=0; i<n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        
        DisjointSet ds = new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = maxRow + stones[i][1] + 1;
            ds.unionBySize(nodeRow, nodeCol);
            hs.add(nodeRow);
            hs.add(nodeCol);
        }
        
        int count = 0;
        
        for(Integer i: hs){
            if(ds.findUPar(i)==i){
                count++;
            }
        }

        
        return stones.length - count;
    }
}