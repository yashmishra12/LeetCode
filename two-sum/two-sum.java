class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int diff;
     
        map.put(nums[0], 0);
        for(int i=1; i<nums.length; i++) {
            int cur = nums[i];
            diff = target-cur;
            if(map.containsKey(diff)) {
                return new int[] {i, map.get(diff)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}