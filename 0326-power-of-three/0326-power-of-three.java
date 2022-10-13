class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){return false;}
        if(n==1) {return true;}

        
        boolean check =  (Math.log10(n) / Math.log10(3)) % 1 == 0;
        return check;

    }
}