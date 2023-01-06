class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        
        for(int a: costs){
            if(coins>=a){
                coins -= a;
                res++;
            }
        }
        return res;
    }
}