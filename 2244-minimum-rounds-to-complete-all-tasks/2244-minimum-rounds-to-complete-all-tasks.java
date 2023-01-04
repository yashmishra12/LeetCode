class Solution {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int a: tasks){
            mp.put(a, mp.getOrDefault(a,0)+1);
        }

        
        int res = 0;
        
        for(Map.Entry<Integer, Integer> e: mp.entrySet()){
            Integer num = e.getKey();
            Integer freq = e.getValue();
            
            if(freq==1){
                return -1;
            }
            
            if(freq%3==0){
                res += freq/3;
            }else {
                res += freq/3 + 1;
            }
        }
        
        return res;
        
    }
}