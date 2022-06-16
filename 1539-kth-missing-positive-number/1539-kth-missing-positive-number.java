class Solution {
    public int findKthPositive(int[] arr, int k) {
//         int expectedNum = 1;
        
//         for(int n: arr) {
            
//             if (n != expectedNum) {
                
//                while(expectedNum != n) {
//                     k--;
//                     if(k==0) {return expectedNum;}
//                     expectedNum++;
//                }
//                 expectedNum++;
//             }
//             else {
//                 expectedNum++;
//             }
//         }
        
//         while(k>0) {
//             expectedNum++;
//             k--;
//         }
        
//         return expectedNum-1;
        
        int n = arr.length;
        int left = 0, right = arr.length - 1;
        
        int missing = compute(arr[n-1], n); //expected = index+1
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            missing = compute(arr[mid], mid+1);
            
            if(missing >= k) { //no. lies on left
                right = mid -1;
            } else {
                 left = mid+1;
            }

        }
        
        
        if (right==-1) {return k;}
        return arr[right] + (k - compute(arr[right], right+1));
    }
    
    public static int compute(int actual, int expected) {
        return actual-expected;   
    }
}