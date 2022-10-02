class Solution {
    public int fib(int n) {
        
        if(n==0 || n==1) {return n;}
        int[] arr = new int[n+1];
       
        int prev1 = 0;
        int prev2 = 1;
        int prev3 = 0;
        
        for(int i=2; i<arr.length; i++) {
            prev3 = prev2+prev1;
            prev1 = prev2;
            prev2 = prev3;
        }
        
        return prev3;
    }
}