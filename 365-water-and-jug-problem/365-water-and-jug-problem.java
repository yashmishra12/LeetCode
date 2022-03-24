class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        
        return z%gcd(x,y)==0;
    }
    
    public static int gcd(int x, int y){
        if (y==0) return x;
        return gcd(y, x%y);
    }
}