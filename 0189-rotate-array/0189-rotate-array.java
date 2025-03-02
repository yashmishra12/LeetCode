class Solution {
    public void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        if (rotations == 0) {
            return;
        }

        int[] result = new int[nums.length];
        int startingIndex = nums.length - rotations;

        int count = 0;

        for (int i = 0; i < result.length; i++) {
            result[i] = nums[startingIndex % nums.length];
            startingIndex++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
        // return;
    }
}