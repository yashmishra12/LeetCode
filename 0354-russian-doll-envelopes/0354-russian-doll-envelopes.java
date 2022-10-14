class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Width in increasing order
        // height in decreasing order
        Arrays.sort(envelopes, (a,b) -> a[0]-b[0] == 0 ? b[1]-a[1]:a[0]-b[0]);
        

        ArrayList<Integer> dp = new ArrayList<>();

        dp.add(envelopes[0][1]);
        
        for(int i=1; i<envelopes.length; i++) {
            int idx = binarySearch(dp, envelopes[i][1]);
// index of the search key, if it is in the array; otherwise, (-(insertion point) – 1)
            // if(idx<0) {
            //         idx += 1;
            //         idx *= -1;
            //     }

            if(idx<dp.size()) {
                 dp.set(idx, envelopes[i][1]);
            }
            else {
                dp.add(envelopes[i][1]);
            }
           

        }
        return dp.size();
    }
    
        public static int binarySearch(ArrayList<Integer> seq, int key) {
        
        int lo = 0, hi = seq.size()-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(seq.get(mid)<key){
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return hi+1;
    }
}