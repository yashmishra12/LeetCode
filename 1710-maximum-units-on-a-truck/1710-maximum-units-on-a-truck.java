class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]); //desc. sorting on the basis of # units inside box
        int unitCount = 0;
        
        for(int[] bt: boxTypes) {
            int bigBoxFreq = bt[0];
            int smallBoxInside = bt[1];
                
            int boxCount = Math.min(truckSize, bigBoxFreq);
            unitCount += (boxCount * smallBoxInside);
            
            truckSize -= boxCount;
            
            if(truckSize==0) {return unitCount;}
        }
        return unitCount;
    }
}