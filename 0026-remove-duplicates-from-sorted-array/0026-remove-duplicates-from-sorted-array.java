class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int movingIndex = 1;
        int currentIndex = 0;
        while (currentIndex < nums.length) {
            while (movingIndex < nums.length && nums[movingIndex] == nums[currentIndex]) {
                movingIndex++;
            }
            currentIndex++;
            if (movingIndex >= nums.length || currentIndex >= nums.length) {
                break;
            }

            nums[currentIndex] = nums[movingIndex];
        }

        return currentIndex;
    }
}