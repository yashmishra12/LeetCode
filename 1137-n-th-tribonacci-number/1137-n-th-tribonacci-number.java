class Solution {
    public int tribonacci(int n) {
        if(n==0 || n==1) {
            return n;
        }
        if(n==2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int d = 0;

        for(int i=3; i<n+1; i++) {
            d = a+b+c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}