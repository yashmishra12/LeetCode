class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        for(int i=0; i<rocks.length; i++){
            capacity[i]-=rocks[i];
        }
        
        Arrays.sort(capacity);
        
        int count = 0;
        
        for(int i: capacity){
            if(i==0){
                count++;
            }else{
                additionalRocks-=i;
                if(additionalRocks>=0){
                    count++;
                }else{
                    return count;
                }
            }
        }
        
        return count;
        
    }
}