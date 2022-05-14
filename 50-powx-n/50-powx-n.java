class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        long N = n;
        if (N<0) {
            x = 1/x;
            N *=-1;
        }
        while(N>0){
            if(N%2==0) {
                x = x*x;
                N/=2;
            }else {
                res*= x;
                N--;
            }
        }
        
        return res;
    }
}