class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int len = nums.length;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < len && diff != 0; ++i) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return target - diff;
    }
}