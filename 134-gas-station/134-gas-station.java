class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int def = 0;
        int pointer = 0;
        int curCost = 0;
        
        for(int i=0; i<gas.length; i++) {
            
           curCost = curCost + (gas[i] - cost[i]);
            
            if(curCost<0) {
                def += curCost;
                curCost = 0;
                pointer = i+1;
            }
        }
        
        if (curCost>=Math.abs(def)) return pointer;
        else return -1;
        
    }
}