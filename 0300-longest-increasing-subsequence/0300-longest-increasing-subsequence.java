class Solution {

    public int lengthOfLIS(int[] arr) {
        if (arr.length==1){ return 1;}
        if (arr.length==2 && arr[1]>arr[0]){return 2;}
        
        ArrayList<Integer> seq = new ArrayList<Integer>();
        seq.add(arr[0]);
        
        for(int i=1; i<arr.length; i++) {
            int curNum = arr[i];
            if(curNum>seq.get(seq.size()-1)) {
                seq.add(curNum);
            } else {
                int index = binarySearch(seq, curNum);
                seq.set(index, curNum);
            }
        }
        
        return seq.size();
        
    }
    public static int binarySearch(ArrayList<Integer> seq, int key) {
        int found = Collections.binarySearch(seq, key);
		if(found<0) {
			found += 1;
			found *= -1;
		}
        return found;
        
//         int lo = 0, hi = seq.size()-1;
//         while(lo<=hi){
//             int mid = lo+(hi-lo)/2;

//             if(seq.get(mid)<key){
//                 lo = mid+1;
//             } else {
//                 hi = mid-1;
//             }
//         }
//         return hi+1;
    }
}