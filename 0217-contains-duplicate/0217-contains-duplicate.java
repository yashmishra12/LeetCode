class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int a: nums){
            if(hs.add(a)==false){
                return true;
            }
        }
        return false;
    }
}