public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        
        for(int i=0; i<16; i++)
            n = rev(n, i, 31-i);
        
        return n;
        
    }
    
    public static int rev (int x, int j, int k) {
        
        int a = (x >>(j)) & 1;
        int b = (x >>(k)) & 1;
            
        if (a!=b) {
        int t = a^b;
        x = x ^ (t << (j));
        x = x ^ (t << (k));
        }
        
        return x;
    }

}