class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> arr = new ArrayList<>();
        List<Integer> dep = new ArrayList<>();
        
        for(int[] a: intervals) {
            arr.add(a[0]);
            dep.add(a[1]);
        }
        
        Collections.sort(arr);
        Collections.sort(dep);
        
        int pt=1;
        int res=1;
        
        int start=1, end=0;
        int n = arr.size();
        
       while(start<n && end<n) {
           if(arr.get(start)<dep.get(end)){
               start++;
               pt++;
           } else {
               end++;
               pt--;
           }
           res = Math.max(res, pt);
       }
        return res;
    
    }
}