class Solution {
    public int minTotalDistance(int[][] grid) {
        ArrayList<Integer> xcoord = new ArrayList<>();
        ArrayList<Integer> ycoord = new ArrayList<>();
        
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++) {
                if(grid[r][c]==1) {
                    xcoord.add(r);
                }
            }
        }
        
        
        for(int c=0; c<grid[0].length; c++) {
            for(int r=0; r<grid.length; r++) {
                if(grid[r][c]==1) {
                    ycoord.add(c);
                }
            }
        }
        
        int xMed=xcoord.get(xcoord.size()/2);
        int yMed = ycoord.get(ycoord.size()/2);
        
        int sum = 0;
        
        for(int i=0; i<xcoord.size();i++) {
            sum = sum + Math.abs(xcoord.get(i)-xMed);
        }
        
         for(int i=0; i<ycoord.size();i++) {
            sum = sum + Math.abs(ycoord.get(i)-yMed);
        }
        return sum;
    }
}