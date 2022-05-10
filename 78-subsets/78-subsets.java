class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    
    List<List<Integer>> res = new ArrayList();
    res.add(new ArrayList<Integer>());
      
     for(int i=0; i<nums.length; i++) {
         int size = res.size();
         
         for(int j=0; j<size; j++) {
             res.add(new ArrayList<>(res.get(j)));
             res.get(res.size()-1).add(nums[i]);
         }
     }

    return res;
  }
}