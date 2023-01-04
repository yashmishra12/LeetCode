class Solution {
    public int minimumRounds(int[] tasks) {

        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int a: tasks){
            mp.put(a, mp.getOrDefault(a,0)+1);
        }

        
        int res = 0;
        
        for(Integer freq: mp.values()){
            
            if(freq==1){
                return -1;
            }
            int x = freq/3;
            if(freq%3==0){
                res += x;
            }else if(freq%3 == 1) {
                res += (x-1) + 2;
            } else if(freq%3==2) {
                res += (x + 1);
            }
        }
        
        return res;
        
    }
}