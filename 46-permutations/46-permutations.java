class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0, nums.length-1);
        return res;
    }
    
    public void helper(int[] nums, List<List<Integer>> res, int start, int end) {
        if(start==end) {
            List<Integer> you = Arrays.stream(nums).boxed().collect(Collectors.toList());

            res.add(you);
            return;
        }
        
        for(int i=start; i<=end; i++) {
            swap(nums, start, i);
            helper(nums, res, start+1, end);
            swap(nums, start, i);
        }
    }
    
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}