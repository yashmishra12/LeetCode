class Solution {
    public void moveZeroes(int[] nums) {
        
        int k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                nums[k++]=nums[i];
            }
        }
        
        while(k<nums.length) {
            nums[k]=0;
            k++;
        }
    }
}

/*
------------ ALTERNATIVE SOLUTION -------------
class Solution {
    public void moveZeroes(int[] nums) {
        int numberOfZeros = 0;
        int nonZeroNumber = 0;
        int currentPointer = 0;

        while (currentPointer < nums.length) {
            while (currentPointer < nums.length && nums[currentPointer] == 0) {
                currentPointer++;
            }

            if (currentPointer >= nums.length) {
                break;
            }
            nums[nonZeroNumber] = nums[currentPointer];
            nonZeroNumber++;
            currentPointer++;
        }

        while (nonZeroNumber < nums.length) {
            nums[nonZeroNumber] = 0;
            nonZeroNumber++;
        }

    }
}
*/
