class Solution {
    public int findPeakElement(int[] nums) {
        
        int maxLength = 0;
        int potIndex = -1;
            
        for(int i=1; i<nums.length-1; i++) {
            
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]) {
                
                int curLength=0;
                int right=i;
                while(right>=0 && nums[right]>nums[right-1]) {
                    right--;
                    curLength++;
                    if(right==0) break;
                }
                
                int left=i;
                while(left>=nums.length-1 && nums[left]>nums[left+1]) {
                    left++;
                    curLength++;
                    if(left==nums.length-1) break;
                }
                
                if(curLength>maxLength) {
                    maxLength = curLength+1;
                    potIndex = i;
                }
            }
        }
        
        if(potIndex==-1) {
            List<Integer> list = new ArrayList<>();
            for(int a: nums) {list.add(a);}
            int res = list.indexOf(Collections.max(list));
            return res;
        }
        
        return potIndex;
    }
}