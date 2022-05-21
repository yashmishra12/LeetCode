class Solution {
    public int minAreaRect(int[][] points) {
        
        HashSet<String> hs = createPointSet(points);
        int minArea = Integer.MAX_VALUE;
        
        for(int i=1; i<points.length; i++) {
            int p1x = points[i][0];
            int p1y = points[i][1];
            
            for(int j=0; j<i; j++) {
            
                int p2x = points[j][0];
                int p2y = points[j][1];
                
                if(p1x==p2x || p1y==p2y) continue;
                
                String p3 = Stringify(p1x, p2y);
                String p4 = Stringify(p2x, p1y);
                int curArea = 0;
                
                if(hs.contains(p3) && hs.contains(p4)) {
                    minArea = Math.min(minArea, Math.abs(p2x-p1x)*Math.abs(p2y-p1y));
                }
            }
        }
        return minArea==Integer.MAX_VALUE ? 0 : minArea;
        
    }
    
    public static HashSet<String> createPointSet(int[][] arr) {
         HashSet<String> hs = new HashSet<>();
        
        for(int[] a: arr) {
            int x = a[0];
            int y = a[1];
            hs.add(Stringify(x,y));
        }
        return hs;
    }
    
    public static String Stringify(int x, int y){
        return x+":"+y;
    }
}