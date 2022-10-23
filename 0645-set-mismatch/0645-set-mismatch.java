class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = new int[2];
        // for(int a: nums) {
        //     if(hs.add(a)==false){
        //         arr[0] = a;
        //     }
        // }
        Arrays.sort(nums);
        for(int i=1;i<=nums.length; i++) {
            int a = nums[i-1];
            if(hs.add(a)==false){
                arr[0] = a;
            }
            if (!hs.contains(i)){
                arr[1]=i;
                // break;
            }
        }
        return arr;
    }
}