class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        ArrayList<int[]> res = new ArrayList<>();
        
        int[] curInterval = intervals[0];
        
        res.add(curInterval);
        
        for(int i=1; i<intervals.length; i++) {
            int[] nextInterval = intervals[i];
            
            int curEnd = curInterval[1], nxtStart = nextInterval[0], nxtEnd = nextInterval[1];
            
            if(curEnd>=nxtStart) {
                curInterval[1] = Math.max(curEnd, nxtEnd);
            }
            else {
                curInterval = intervals[i];
                res.add(curInterval);
            }
            
        }
        
        return res.toArray(new int[res.size()][]);
    }
}

