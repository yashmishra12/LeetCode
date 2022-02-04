class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), (a,b)->a[0]-b[0]);
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i-1][1]>intervals[i][0]) return false;
        }
        return true;
    }
}