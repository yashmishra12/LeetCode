class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(prefixSum[0], 0);
        
        for(int i=1; i<nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
            tm.put(prefixSum[i], i);
        }
        
        int[] ans = new int[queries.length];
        int i = 0;
    
        for(int query: queries){
            Map.Entry<Integer, Integer> e = tm.floorEntry(query);
            if(e!=null){
                ans[i] = e.getValue()+1;
            }
            i++;
        }
        
        return ans;
    }
    
}