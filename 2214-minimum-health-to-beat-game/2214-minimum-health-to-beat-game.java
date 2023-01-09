class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 1;
        long max = Integer.MIN_VALUE;
        long lo = Integer.MAX_VALUE;

        for(int a: damage){
            sum += a;
            max = Math.max(max, a);
            
        }
        
        return sum - Math.min(max, armor);
        
    }
     
}