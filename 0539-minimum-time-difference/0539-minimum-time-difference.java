class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] time = new boolean[24*60];
        for(String r: timePoints) {
            String[] time_split = r.split(":");
            int hour = Integer.parseInt(time_split[0]);
            int min = Integer.parseInt(time_split[1]);
            if(time[(hour*60)+min]) {return 0;}
            time[(hour*60)+min] = true;
        }
        
        int first = -1, prev = -1, min = Integer.MAX_VALUE;
        
        for(int i=0; i<1440; i++) {
            if(time[i]){
                if(first==-1){
                    first = i;
                    prev = i;
                }
                else {
                    min = Math.min(min, i-prev);
                    prev = i;
                }
            }
        }
        
        min = Math.min(min, 1440-(prev-first));
        return min;
    }
}