class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i: piles){
            pq.add(i);
        }
        
        while(k>0){
            int num = pq.remove();
            int newNum = num - (int)Math.floor(num/2);
            pq.add(newNum);
            k--;
        }
        
        int sum = 0;
        for(int i: pq){
            sum += i;
        }
        
        return sum;
    }
}