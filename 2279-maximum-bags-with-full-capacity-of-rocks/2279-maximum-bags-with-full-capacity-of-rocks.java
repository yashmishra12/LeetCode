class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=0; i<rocks.length; i++){
            int cap = capacity[i];
            int rock = rocks[i];
            int space = cap-rock;
            
            arr.add(space);
        }
        
        Collections.sort(arr);
        
        int count = 0;
        
        for(int i: arr){
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