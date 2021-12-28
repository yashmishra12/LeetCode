class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        map.put(0,1); // 0 to already 1 baar mil hi chuka hai
        int diff = 0;
        int count=0;

        for(int i=0; i<nums.length; i++) {
            sum = sum+nums[i];
            diff = sum - k;
            if(map.containsKey(diff))
                count = count + map.get(diff);
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return count;
    }
}