class Solution {
    public boolean containsDuplicate(int[] nums) {
      
       Set<Integer> st = new HashSet<>(nums.length);
        
        for(int a: nums) {
            if (st.contains(a)) return true;
            st.add(a);
        }
        return false;
        
    }
}