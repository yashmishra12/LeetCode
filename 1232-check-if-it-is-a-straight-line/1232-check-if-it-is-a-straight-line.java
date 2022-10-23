class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] firstPoint = coordinates[0];
        int[] secondPoint = coordinates[1];
        int y2 = secondPoint[1];
        int y1 = firstPoint[0];
        int x2 = 0;
        int x=coordinates[0][0]-coordinates[1][0]; //x2 - x1
        int y=coordinates[1][1]-coordinates[0][1]; //y2 - y1
        
        int slope=y*coordinates[1][0]+x*coordinates[1][1];
        
        
        for(int i=2;i<coordinates.length;i++)
        {
            int curSlope=x*coordinates[i][1]+y*coordinates[i][0];
            if(curSlope!=slope) {
                return false;
            }
        }
        return true;
    }
}