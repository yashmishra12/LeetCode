// class Solution {
//     public static class Envelope implements Comparable<Envelope> {
//         int w;
//         int h;
        
//         Envelope(int w, int h) {
//             this.w = w;
//             this.h = h;
//         }
//         public int compareTo(Envelope o) {
//             return this.w - o.w;
//         }
//         public String toString(){
//             return "<"+w+", "+h+">";
//         }
        
//     }
    
    
//     public int maxEnvelopes(int[][] envelopes) {
//         if(envelopes.length<2) {return envelopes.length;}
//         Envelope[] arr = new Envelope[envelopes.length];
        
//         for(int i=0; i<envelopes.length; i++) {
//             arr[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
//         }
        
//         Arrays.sort(arr);
//         int[] h = new int[arr.length];
//         int[] w = new int[arr.length];
        
//         for(int i=0; i<arr.length; i++) {
//             h[i] = arr[i].h;
//             w[i] = arr[i].w;
//         }
        
//         ArrayList<Envelope> seq = new ArrayList<>();
//         seq.add(arr[0]);
        
//         for(int i=1;i<arr.length; i++) {
//             int curHeight = h[i];
//             Envelope lastEnvelope = seq.get(seq.size()-1);
//             if(curHeight>lastEnvelope.h && w[i]>lastEnvelope.w) {
//                 seq.add(arr[i]);
//             } else {
//                 int index = binarySearch(seq, curHeight);
//                  seq.set(index, arr[i]);
//             }
//         }
        
//         return seq.size();
        
// //         int[] dp = new int[envelopes.length];
// //         int omax = 0;
// //         for(int i=0; i<dp.length; i++) {
// //             int max = 0;
// //             for(int j=0; j<i; j++) {
// //                 if(arr[j].h < arr[i].h && arr[j].w < arr[i].w) {
// //                     if(dp[j]>max) {max = dp[j];}
// //                 }
// //             }
// //             dp[i] = max+1;
// //             omax = Math.max(dp[i], omax);
// //         }
        
// //         return omax;
//     }
    
//     public static int binarySearch(ArrayList<Envelope> arr, int key) {
//         int lo = 0, hi = arr.size()-1;
//         while(lo<=hi) {
//             int mid = lo + (hi-lo)/2;
//             // if(arr.get(mid).h==key) {return mid;}
//             if(arr.get(mid).h<key){
//                 lo = mid+1;
//             } else {
//                 hi = mid-1;
//             }
//         }
//         return  hi+1;
//     }
// }



class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Width in increasing order
        // height in decreasing order
        Arrays.sort(envelopes, (a,b) -> 
            a[0]-b[0] == 0 ? b[1]-a[1]:a[0]-b[0]
        );
        
        // int[] dp = new int[envelopes.length+1];
        ArrayList<Integer> dp = new ArrayList<>();
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // int len = 0;
        
        dp.add(envelopes[0][1]);
        
        for(int i=1; i<envelopes.length; i++) {
            int idx = Collections.binarySearch(dp, envelopes[i][1]);
            if(idx<0) {
                    idx += 1;
                    idx *= -1;
                }
            // dp[idx] = envelopes[i][1];
            if(idx<dp.size()) {
                 dp.set(idx, envelopes[i][1]);
            }
            else {
                dp.add(envelopes[i][1]);
            }
           

        }
        return dp.size();
    }
}