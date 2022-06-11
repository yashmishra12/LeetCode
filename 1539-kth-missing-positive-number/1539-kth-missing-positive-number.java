class Solution {
    public int findKthPositive(int[] arr, int k) {
        int expectedNum = 1;
        
        for(int n: arr) {
            
            if (n != expectedNum) {
                
               while(expectedNum != n) {
                    k--;
                    if(k==0) {return expectedNum;}
                    expectedNum++;
               }
                expectedNum++;
            }
            else {
                expectedNum++;
            }
        }
        
        while(k>0) {
            expectedNum++;
            k--;
        }
        
        return expectedNum-1;
    }
}