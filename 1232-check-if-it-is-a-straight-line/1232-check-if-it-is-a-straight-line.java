class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int xDiff=coordinates[1][0]-coordinates[0][0];
        int yDiff=coordinates[1][1]-coordinates[0][1];

        
        for(int i=2;i<coordinates.length;i++)
        {
            int curXDiff = coordinates[i][0]-coordinates[i-1][0];
            int curYDiff = coordinates[i][1]-coordinates[i-1][1];
            if(yDiff*curXDiff != curYDiff*xDiff) {return false;}
        }
        return true;
    }
}